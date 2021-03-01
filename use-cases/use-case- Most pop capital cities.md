# USE CASE: 3 Obtain a report on the most populated capital cities in a continent, region, country or district

## CHARACTERISTIC INFORMATION

### Goal in Context


As an employee of the World Health Organisation, I want to produce a report on all the capital cities in the world organised by largest population to smallest, so that I can supply governments with information about the effects of the ongoing pandemic.

### Scope

Capital city queries.

### Level

Primary task.

### Preconditions

We know which cities are capitals, and they are in the database.

### Success End Condition

A report on the population's of capital cities in the given area is produced

### Failed End Condition

No report is produced

### Primary Actor

W.H.O. Employee

### Trigger

A request is made by W.H.O. manager/coordinator or government for population
totals in capital cities.

## MAIN SUCCESS SCENARIO

1. Request is made for capital city information.
2. W.H.O. employee captures capital city name.
3. W.H.O. employee, utilising the web UI, searches for and finds the relevant 
   capital city information.
4. The capital city data is given to the requesting party.

## EXTENSIONS

2. **capital city does not exist in the database**:
    i. W.H.O. employee asks requester to alter their request to a definition the
       database contains.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
