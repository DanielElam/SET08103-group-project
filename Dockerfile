#
# Build stage
#
FROM maven:3.6.3-jdk-13 AS build
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.1.1:go-offline
COPY . .
RUN mvn -B -e -T 1C install

#
# Package stage
#
FROM adoptopenjdk/openjdk13:ubuntu-jre
ARG JAR_FILE=/usr/src/app/target/*-with-dependencies.jar
COPY --from=0 ${JAR_FILE} app.jar
EXPOSE 2004
EXPOSE 2904
ENTRYPOINT ["java","-jar","/app.jar"]