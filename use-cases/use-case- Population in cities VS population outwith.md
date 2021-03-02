# USE CASE: 6 Obtain a report on the people living in cities versus the people not living in cities a continent, region or country 

## CHARACTERISTIC INFORMATION

### Goal in Context


As an employee of the World Health Organisation, I want to produce a report on the population<br>
of people, people living in cities, and people not living in cities in each 
continent/region/country, so that I can help inform and assist governments or the W.H.O. in the distribution and
allocation of healthcare resources.
### Scope

Population queries.

### Level

Primary task.

### Preconditions

We know the area that is being searched, and it is in the database.

### Success End Condition

A report on the distribution of population between cities and not cities in the given area is produced

### Failed End Condition

No report is produced

### Primary Actor

W.H.O. Employee

### Trigger

A request is made by W.H.O. manager/coordinator or government for population
distribution between cities and outside cities in a specific area.

## MAIN SUCCESS SCENARIO

1. Request is made for population information.
2. W.H.O. employee captures area name(continent, region, country etc.)
3. W.H.O. employee, utilising th web UI, searches for and finds the relevant 
   population information.
4. The population report is given to the requesting party.

## EXTENSIONS

2. **area does not exist in the database**:
   <br> i. W.H.O. employee asks requester to alter their request to a definition the
       database contains.
 3. **Request is for cities in a district**
    <br> i. That is not in the requirements. Inform the requester that this is not a function 
    of the system and ask them to re-define their parameters.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
