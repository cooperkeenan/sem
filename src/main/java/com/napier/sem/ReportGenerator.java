package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class ReportGenerator {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/world?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the World Population Report Generator!");
        displayAvailableReports();

        int reportType = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        AreaSelection areaSelection; // Declare areaSelection

        int n;
        switch (reportType) {

            case 1:
                //1. Population of world/continent/region from largest to smallest
                areaSelection = selectArea(3);
                generatePopulationReport(areaSelection, "country", null, false);
                break;

            case 2:

                areaSelection = selectArea(3);
                //2. Top N populated countries in world/continent/region from largest to smallest
                System.out.print("Enter the number N for the top N populated countries: ");
                n = scanner.nextInt();
                scanner.nextLine();
                generatePopulationReport(areaSelection, "country", n, false);
                break;

            case 3:
                //3. Cities in world/continent/region/country/district from largest to smallest
                areaSelection = selectArea(5);
                generatePopulationReport(areaSelection, "city", null, false);
                break;

            case 4:
                //4. Top N cities in world/continent/region/country/district
                areaSelection = selectArea(5);
                System.out.print("Enter the number N for the top N populated cities: ");
                n = scanner.nextInt();
                scanner.nextLine();
                generatePopulationReport(areaSelection, "city", n, false);
                break;

            case 5:
                //5. Capital cities in world/continent/region largest to smallest
                areaSelection = selectArea(3);
                generatePopulationReport(areaSelection, "city", null, true);
                break;

            case 6:
                //6. Top N capital cities in world/continent/region
                areaSelection = selectArea(3);
                System.out.print("Enter the number N for the top N populated capital cities: ");
                n = scanner.nextInt();
                scanner.nextLine();
                generatePopulationReport(areaSelection, "city", n, true);
                break;

            case 7:
                // 7. Population of world/continent/country/region/district/city
                areaSelection = selectArea(6);
                generatePopulationReport(areaSelection, "general", null, false);
                break;

            case 8:
                generateLanguageReport();
                break;


            default:
                System.out.println("Invalid report type selected.");
        }

        scanner.close();
    }

    private static void displayAvailableReports() {
        System.out.println(" ");
        System.out.println("1. Population of world/continent/region from largest to smallest");
        System.out.println("2. Top N populated countries in world/continent/region from largest to smallest ");
        System.out.println("3. Cities in world/continent/region/country/district from largest to smallest ");
        System.out.println("4. Top N cities in world/contentment/region/country/district ");
        System.out.println("5. Capital cities in world/continent/region largest to smallest ");
        System.out.println("6. Top N capital cities in world/continent/region \n");
        System.out.println("7. Population of world/continent/country/region/district/city ");
        System.out.println("8. Number of people who speak Chinese, English, Hindi, Spanish, Arabic\n");


        System.out.print("Please select a report to generate: ");

    }

    private static AreaSelection selectArea(int loop) {
        String[] areaArr = {"World", "Continent", "Region", "Country", "District", "City"};

        // Display options up to the specified limit
        System.out.println(" ");
        for (int i = 0; i < loop; i++) {
            System.out.println((i + 1) + ". " + areaArr[i]);
        }

        System.out.print("Select an Area: ");

        // Capture user choice
        int choice = scanner.nextInt();
        scanner.nextLine();


        // Validate user choice and return an AreaSelection
        if (choice >= 1 && choice <= loop) {
            String selectedAreaType = areaArr[choice - 1]; // Adjusting for 0-index
            String selectedAreaName;

            // Prompt for additional input if necessary
            if (!"World".equals(selectedAreaType)) {
                System.out.println("\nEnter the name of the " + selectedAreaType.toLowerCase() + ": ");
                selectedAreaName = scanner.nextLine();

            } else {
                selectedAreaName = "the World";
            }

            return new AreaSelection(selectedAreaType, selectedAreaName);
        } else {
            System.out.println("Invalid choice. Please select a valid number.");
            return selectArea(loop); // Recursively call selectArea until a valid choice is made
        }
    }



    private static void generatePopulationReport(AreaSelection areaSelection, String entityType, Integer limit, boolean isCapital) {
        String query = "";
        boolean requiresName = true;

        if (isCapital)
        {
            query = " SELECT city.Name, city.Population AS Country, city.Population FROM city JOIN country ON city.ID = country.Capital";
        }
        else if (entityType.equals("country"))
        {
            query = "SELECT Name, Population FROM country ";
        }

        else if (entityType.equals("city"))
        {
            query = "SELECT city.Name, country.Name as Country, city.Population FROM city JOIN country ON city.CountryCode = country.Code";

        }
        else if (entityType.equals("general"))
        {
            query = "SELECT city.Name, SUM(city.Population) AS TotalPopulation FROM city";
            requiresName = false;
        }

        // Apply filter based on the selected area
        if (!"World".equals(areaSelection.areaType)) {
            switch (areaSelection.areaType) {

                case "Continent":
                    query += " WHERE country.Continent = ?";
                    break;

                case "Region":
                    query += " WHERE country.Region = ?";
                    break;

                case "Country":
                    query += " WHERE country.Name = ?";
                    break;

                case "District":
                    query += " AND city.District = ?";
                    break;

                case "City":
                    query += " WHERE city.Name = ?";
                    break;

                default:
                    System.out.println("Invalid area type specified.");
                    return;
            }
        }

        if(!entityType.equals("general"))
        {
            query += " ORDER BY Population DESC";
        }

        if (limit != null) {
            query += " LIMIT " + limit;
        }

        // Execute the query
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            if (!"World".equals(areaSelection.areaType) && query.contains("?")) {
                statement.setString(1, areaSelection.areaName);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!requiresName) {
                    if (resultSet.next())
                    {
                        long totalPopulation = resultSet.getLong("TotalPopulation");
                        System.out.println("Total Population: " + totalPopulation);
                    }
                    else
                    {
                        System.out.println("No data found for the specified area.");
                    }
                } else {
                    while (resultSet.next()) {
                        String name = resultSet.getString("Name");
                        int population = resultSet.getInt("Population");
                        System.out.println(name + " - " + population);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while generating the population report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void generateLanguageReport() {
        String query = """
    SELECT
        Language,
        SUM(country.Population * (countrylanguage.Percentage / 100)) AS Number_of_Speakers,
        (SUM(country.Population * (countrylanguage.Percentage / 100)) / (SELECT SUM(Population) FROM country) * 100) AS Percentage_of_World_Population
    FROM
        country
    JOIN
        countrylanguage ON country.Code = countrylanguage.CountryCode
    WHERE
        Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')
    GROUP BY
        Language
    ORDER BY
        Number_of_Speakers DESC;
    """;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/world?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "password");
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Language Report:");
            while (resultSet.next()) {
                String language = resultSet.getString("Language");
                long speakers = resultSet.getLong("Number_of_Speakers");
                double percentage = resultSet.getDouble("Percentage_of_World_Population");
                System.out.printf("%s: %d speakers, %.2f%% of world population\n", language, speakers, percentage);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while generating the language report: " + e.getMessage());
            e.printStackTrace();
        }
    }




    static class AreaSelection {
        String areaType;
        String areaName;

        AreaSelection(String areaType, String areaName) {
            this.areaType = areaType;
            this.areaName = areaName;
        }
    }
}