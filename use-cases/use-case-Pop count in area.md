# USE CASE: 1 Obtain population numbers for a specific continent, region, country, district or city

## CHARACTERISTIC INFORMATION

### Goal in Context


As an employee of the World Health Organisation, I want to produce a report on the population <br>
of a continent/region/country/district/city so that I can supply governments with guidance on 
vaccine distribution, and the needs of the given area. 

### Scope

??

### Level

Primary task.

### Preconditions

We know the area that is being searched, and it is in the database.

### Success End Condition

A report on the total population of the given area is produced

### Failed End Condition

No report is produced

### Primary Actor

W.H.O. Employee

### Trigger

A request is made by W.H.O. manager/coordinator or government for population
totals in a specific area or region.

## MAIN SUCCESS SCENARIO

1. Request is made for population information.
2. W.H.O. employee captures area name(continent, region, country etc.)
3. W.H.O. employee, utilising th web UI, searches for and finds the relevant 
   population information.
4. The population data is given to the requesting party.

## EXTENSIONS

2. **area does not exist in the database**:
    i. W.H.O. employee asks requester to alter their request to a definition the
       database contains.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
