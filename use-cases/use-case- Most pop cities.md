# USE CASE: 2 Obtain a report on the most populated cities in a continent, region, country or district

## CHARACTERISTIC INFORMATION

### Goal in Context


As an employee of the World Health Organisation, I want to produce a report on the top N
populated cities in a continent/region/country/district where N is provided by the user,
so that I can help inform and assist governments or the W.H.O. in the distribution and
allocation of healthcare resources. 

### Scope

??

### Level

Primary task.

### Preconditions

We know the area that is being searched, and it is in the database.

### Success End Condition

A report on the population's of cities in the given area is produced

### Failed End Condition

No report is produced

### Primary Actor

W.H.O. Employee

### Trigger

A request is made by W.H.O. manager/coordinator or government for population
distribution between cities in a specific area.

## MAIN SUCCESS SCENARIO

1. Request is made for population information.
2. W.H.O. employee captures area name(continent, region, country etc.)
3. W.H.O. employee, utilising th web UI, searches for and finds the relevant 
   population information.
4. The population report is given to the requesting party.

## EXTENSIONS

2. **area does not exist in the database**:
    i. W.H.O. employee asks requester to alter their request to a definition the
       database contains.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
