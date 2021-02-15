package com.napier.sem.group10;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.napier.sem.group10.filters.city.*;
import com.napier.sem.group10.filters.capitalcity.*;
import com.napier.sem.group10.filters.country.*;
import fi.iki.elonen.NanoHTTPD;

public class App extends NanoHTTPD {
    private static final String _databaseHost = IsRunningInsideDocker() ? "db:3306" : "127.0.0.1:3306";
    private static final String _databaseStore = "world";
    private static final String _databaseUsername = "root";
    private static final String _databasePassword = "therecanbeonlyone";

    private static final int MAX_CONNECTION_ATTEMPTS = 10;

    private Connection _connection;
    private final Map<String, ICommandHandler> _resultHandlers = new HashMap<>();

    /**
     * App constructor.
     * Connects to the database and initializes the NanoHTTP server
     *
     * @throws IOException          In the case the NanoHTTP server could not be started
     * @throws InterruptedException In the case the thread is interrupted
     */
    public App() throws IOException, InterruptedException {
        super(2904);
        registerHandlers();
        connectDatabase();
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nHTTP server running @ http://localhost:2904/ \n");
    }

    /**
     * Checks if the application is running inside a docker container
     * Source: https://stackoverflow.com/a/52581380
     */
    public static Boolean IsRunningInsideDocker() {
        try (Stream<String> stream =
                     Files.lines(Paths.get("/proc/1/cgroup"))) {
            return stream.anyMatch(line -> line.contains("/docker"));
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Map all implementations of IPopulationResult to their command name.
     */
    private void registerHandlers() {
        registerHandler(new CountriesInWorld());
        registerHandler(new CountriesInRegion());
        registerHandler(new CountriesInContinent());

        registerHandler(new CitiesInContinent());
        registerHandler(new CitiesInCountry());
        registerHandler(new CitiesInDistrict());
        registerHandler(new CitiesInRegion());
        registerHandler(new CitiesInWorld());

        registerHandler(new CapitalCitiesInWorld());
        registerHandler(new CapitalCitiesInRegion());
        registerHandler(new CapitalCitiesInContinent());

    }

    /**
     * Map the given implementation of IPopulationResult to its command name.
     */
    private void registerHandler(ICommandHandler handler) {
        _resultHandlers.put(handler.getCommand(), handler);
    }

    /**
     * Attempts to connect to the database.
     * Will continuously loop until the database is running.
     *
     * @throws InterruptedException If the thread is interrupted
     */
    private void connectDatabase() throws InterruptedException {
        var databaseUrl = String.format("jdbc:mysql://%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                _databaseHost, _databaseStore);

        for (int i = 0; i < MAX_CONNECTION_ATTEMPTS; i++) { // mysql isn't ready to start with so keep trying to connect...
            try {
                System.out.println("Trying to connect to MySQL database @ " + _databaseHost + " ...");
                _connection = DriverManager.getConnection(
                        databaseUrl,
                        _databaseUsername, _databasePassword);
                System.out.println("Connected to MySQL database.");
                break;
            } catch (SQLException ex) {

                //System.out.println("An error occurred attempting to connect to the database.");
                System.out.println(ex.getMessage());
                //ex.printStackTrace();

            }
            Thread.sleep(2000);
        }
    }

    /**
     * Executes the SQL statement for the given handler and returns the result string.
     *
     * @param result The command handler to use
     * @param args   List of user-provided parameters.
     * @return A string containing either the SQL rows in CSV format or an error string.
     */
    private String executeCommand(ICommandHandler result, Map<String, String> args) {
        StringBuilder resultBuilder = new StringBuilder();
        try {
            var statement = result.prepareStatement(_connection, args);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String line = result.getResultRow(set);
                resultBuilder.append(line);
                resultBuilder.append("\n");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred attempting to execute: " + result.toString());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return String.format("!ERROR:%s", ex.getMessage());
        }
        return resultBuilder.toString();
    }

    /**
     * Serves an HTTP request with an appropriate response
     *
     * @param session HTTP Session object
     * @return HTTP Response object
     */
    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();

        // if the URL path starts with /api/ then we serve the API request.
        if (uri.startsWith("/api/")) {
            String command = uri.substring(5);
            System.out.println(command);

            ICommandHandler handler = _resultHandlers.getOrDefault(command, null);

            if (handler == null) {
                System.out.println(String.format("No handler registered for command \"%s\"", command));
                return newFixedLengthResponse("!ERROR");
            }

            String result = executeCommand(handler, session.getParms());
            return newFixedLengthResponse(result);
        } else { // otherwise, serve the HTML page.
            String msg = "";
            Path devTestPath = Paths.get("C:\\Users\\Daniel\\IdeaProjects\\SEM-CW\\src\\main\\resources\\sem-cw.html");
            if (Files.exists(devTestPath)) {
                try {
                    msg = new String(Files.readAllBytes(devTestPath));
                } catch (IOException e) {
                }
            } else {
                try {
                    URL resource = App.class.getResource("/sem-cw.html");
                    msg = new String(Files.readAllBytes(Paths.get(resource.toURI())));
                } catch (IOException | URISyntaxException e) {
                }
            }
            return newFixedLengthResponse(msg);
        }
    }

    /**
     * Application entry point. Instantiates the App.
     *
     * @param args Program arguments
     * @throws InterruptedException In the case the thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        try {
            new App();
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
        }
    }
}