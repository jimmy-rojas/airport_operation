# Java Airport Operations

## General ##
> Submission 2 (take home assignment): Write a Java project to handle operations of an airport. For simplicity, assume that all input data is available as JSON, CSV XML files and output data should also be written to a JSON, XML or CSV file. This is an open-ended question to see how you will approach the problem from engineering and implementation perspectives.Provide the code with clear instructions on how to run it, and a document explaining your design. The code should at least be able to parse sample data (you have created) from an input file and write some data to an output file.

## Compilation and Testing ###
To compile run:
- execute the command: 

``` mvn clean compile test ```

See in console the test results

### Goal ###
To execute look for the artifact in the target folder
- execute the command: 

``` mvn -Dtest=AirportOperationServiceTest#saveOperationsByType test ```

See the 'data-output.json' file

### Full Documentation ###
In order to understand better this sample project, please refer to 
[GDoc](https://docs.google.com/document/d/1xvu8CAHH7zBDQ1zVMrsmTqsYjUjv-BB3fKzudNEICBI/edit?usp=sharing)

### Execution ###
This project just contains a core functionality and this is covered in its unit-tests

To execute look for the artifact in the target folder
- execute the command: 

``` java -jar AirportOperation-1.0-SNAPSHOT.jar ```

**Note:** This command is going to start the jar artifact, but, no interaction was implemented yet.