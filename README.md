# Programming Task - Andres Silva

The purpose of this application is to sort and group ranges of a given list of Accession Numbers. It can be executed by command line or through a web service.

## Technology Stack

 * Java 1.8
 * Gradle 
 * Spring Boot

## Project Structure

* **common:** Library that contains the classes to process (sort and group) a list of Accession numbers
* **accession-number-terminal:** Console project
* **accession-number-web:** Web project 	 

## Generating .jar files

### Console Project (accession-number-terminal)

* Go to the root of the project and execute
```
gradle build :accession-number-terminal:shadowJar
```
* This will generate a .jar file in the following path `..\accession-number-terminal\build\libs\accession-number-terminal.-1.0-FULL.jar`

### Web Project (accession-number-web)

* Go to the root of the project and execute
```
gradle build
```
* This will generate a .jar file in the following path `..\accession-number-web\build\libs\accession-number-web-1.0-FULL.jar`


## Running and Testing

An output folder with the generated .jar files was created in order to make the running and testing simpler.

### Console Project (accession-number-terminal)

* Go to `..\AFSILVA\output`
* Execute the .jar file 
```
java -jar accession-number-terminal-1.0-FULL.jar A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1
```
* It will return the processed accession number list

### Web Project (accession-number-web)

* Go to `..\AFSILVA\output`
* Execute 
```
java -jar accession-number-web-1.0-FULL.jar
```
* Go to a web browser
* Execute 
``` 
http://localhost:8080/accession_number?accNumStr=A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1
```
* It will return the processed accession number list
