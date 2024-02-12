Use Case: Generate Top N Populated Countries Report in a Continent
Goal in Context:
The goal of this use case is to generate a report listing the top N populated countries in a specific continent, where N is provided by the user.

Scope:

In: SQL Database, User Input for N.
Out: Report containing country information.
Level:

Organisation (black-box): Focus on generating a specific report within the broader system.
Preconditions:

The system has access to the SQL database.
The user has a valid login to access the reporting functionality.
The continent is specified for which the report should be generated.
The user provides a valid integer value N for the number of countries to include in the report.
Success End Condition:
A report is generated and displayed, listing the top N populated countries in the specified continent, including relevant information for each country.

Failed End Condition:

The system encounters an error accessing the database.
The user input for the continent is invalid or not provided.
The user input for N is not a valid positive integer.
No countries are found in the specified continent.
Primary Actor:
System User (with reporting privileges)

Trigger:
The user initiates the request to generate a report for the top N populated countries in a continent.

Main Success Scenario:

The user logs into the system with reporting privileges.
The user navigates to the reporting section and selects the option to generate a report for top N populated countries in a continent.
The system prompts the user to enter the continent for which the report should be generated.
The user enters a valid continent name.
The system prompts the user to enter the value of N (number of countries).
The user enters a valid positive integer N.
The system retrieves data from the SQL database, listing the top N populated countries in the specified continent.
The system generates a report containing relevant information for each country (as specified in the Country Report).
Extensions:

Invalid Continent: If the user enters an invalid or non-existent continent, the system informs the user and prompts for a valid continent.
Invalid N Value: If the user enters an invalid or non-positive integer for N, the system informs the user and prompts for a valid N.
Conditions of Satisfaction:

The report includes the correct and relevant information for the top N populated countries in the specified continent.
The report is presented in a clear and readable format.
The system handles invalid inputs gracefully, providing meaningful error messages to the user.

Use Case 2: Generate Population Report for a Continent
Goal in Context:
The goal of this use case is to generate a comprehensive population report for a specific continent.

Scope:

In: SQL Database.
Out: Population report for the specified continent.
Level:

Organisation (black-box): Focus on generating a specific report within the broader system.
Preconditions:

The system has access to the SQL database.
The user has a valid login to access the reporting functionality.
The continent is specified for which the population report should be generated.
Success End Condition:
A population report is generated and displayed, providing information about the continent's total population, population in cities, and population not living in cities.

Failed End Condition:

The system encounters an error accessing the database.
The user input for the continent is invalid or not provided.
No data is found for the specified continent.
Primary Actor:
System User (with reporting privileges)

Trigger:
The user initiates the request to generate a population report for a continent.

Main Success Scenario:

The user logs into the system with reporting privileges.
The user navigates to the reporting section and selects the option to generate a population report for a continent.
The system prompts the user to enter the continent for which the report should be generated.
The user enters a valid continent name.
The system retrieves data from the SQL database, calculating the total population, population in cities, and population not living in cities for the specified continent.
The system generates and displays a comprehensive population report for the specified continent.
Extensions:

Invalid Continent: If the user enters an invalid or non-existent continent, the system informs the user and prompts for a valid continent.
Conditions of Satisfaction:

The population report includes accurate and relevant information for the specified continent.
The report is presented in a clear and readable format.
The system handles invalid inputs gracefully, providing meaningful error messages to the user.
These use cases cover specific functionalities outlined in the coursework, providing a detailed understanding of user interactions and system behavior.