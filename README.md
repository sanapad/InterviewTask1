# InterviewTask1
## Description
This is the test task for the vacancy of Java developer (October 2022) consisting of 2 parts.
The tasks are not so much a formal barrier as an opportunity to show yourself and earn extra points.

## Requirements for completed tasks:
  - Version of Java any of the three: 8, 11, 17
  - Send the project code in any form: zip archive, link to Github, Bitbucket, etc.
  - The application should not require prior manual execution of SQL scripts to work, tables should be automatically created when the application is started.
  - Once the project is built, the application should be ready to run with a single command

The task should take no more than 3-5 hours to complete.
No more than 3 days are suggested for the fulfillment of the terms of reference.

## Task 1 of 2 (took 3,5 hours)
There is a root folder. This folder can contain text files, as well as other folders. Other folders can also contain text files and folders (the level of nesting can be any).
Find all text files, sort them by name and merge the contents into a single text file.

## Using
launch:
```bash
java -jar ./Task1.jar
```
output:
```bash
File result.txt has been created/updated in the root folder
```
check the result:
```bash
cat result.txt
```
output:
```bash
1 2 3 4 5 6 7 8 9 10
```
