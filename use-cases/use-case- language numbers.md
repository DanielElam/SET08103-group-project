# USE CASE: 6 Obtain a report on the number of people who speak certain languages, and the percentage of the world's population that includes.

## CHARACTERISTIC INFORMATION

### Goal in Context


As an employee of the World Health Organisation, I want to produce a report on the number
of people who speak Chinese, English, Hindi, Spanish, and Arabic, from greatest number to 
smallest, including percentage of the world population, so that I can help inform and
assist governments or the W.H.O. in the allocation of suitable healthcare personnel or translators

### Scope

Language query.

### Level

Primary task.

### Preconditions

None

### Success End Condition

A report detailing the numbers of people who speak each language and what percentage of the world's population that is, is created

### Failed End Condition

No report is produced

### Primary Actor

W.H.O. Employee

### Trigger

A request is made by W.H.O. manager/coordinator or government for information on how many
people speak either Chinese, English, Hindi, Spanish, or Arabic.

## MAIN SUCCESS SCENARIO

1. Request is made for spoken languages information.
2. W.H.O. employee captures specific languages/s(Chinese, English, Hindi, Spanish, or Arabic, or all)
3. W.H.O. employee, utilising th web UI, searches for and finds the relevant 
   language information.
4. The report is given to the requesting party.

## EXTENSIONS

2. **language does not exist in the database**:
   <br>i. W.H.O. employee asks requester to alter their request to a definition the
       database contains.
2. **Request is for too many languages**
   <br>i. W.H.O. employee informs requester the languages they can find data for.
2.**The request is for people who don't speak the dominant language in an area**
   <br>i. W.H.O. employee informs requester that they can only produce reports on the number
   of people who do speak a language.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
