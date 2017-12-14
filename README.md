# TransactionSummary
Application that generates a CSV file with transaction summary for a given input.

Steps to run the project:

1. Place the input.txt, InputDescriptor.txt, log4j.properties files in a folder.
2. Run the given jar file with the below command:

java -cp <folder in which config files are copied>/* -jar TransactionSummary.jar
3. The Output.csv file and the TransactionLog.log file will be created in the same folder where the jar is run from.

The source code is available in: 
https://github.com/tejamunnangi/TransactionSummary/tree/master/TransactionSummary

To setup the code, just do a git pull from the above repository and build using mvn install.

Diagnosing defects:
If in case a record is misrepresented in the input.txt file, check the logs with the string: "Error occured while processing the transaction for the record with client info: "
That will have the client and product info to identify which record has an issue.
The remaining records will get processed fine.

To do tasks:

1. Exception handling to propagate to the main method.
2. More logs.
3. More test cases with different scenarios.
4. Configuration properties file to mention which input and input descriptor files to use.
5. Mapping file to map between input descriptor fields and input fields.
