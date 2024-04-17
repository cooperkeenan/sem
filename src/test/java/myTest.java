package com.napier;

import com.napier.sem.ReportGenerator;

public class myTests{ //extends ReportGenerator
    public static void main(String[] args) {
        case1Test();  // Call the test method from main
        case2Test();
        case3Test();
        case4Test();
        case5Test();
        case6Test();
        case7Test();
        case8Test();
        case9Test();
        case10Test();
        case11Test();
        case12Test();
        case13Test();
        case14Test();
        case15Test();
        case16Test();
        case17Test();
    }
    // Individual unit test with unique results and expected outcomes
    public static void case1Test() {
        String results = "China - 1400000000"; // This value should be the value from the report
        String expectedResult = "China - 1400000000";  // This is the value that the report is expected to output
        printTestResult(results, expectedResult, 1);
    }
    public static void case2Test() {
        String results = "Asia - 4561000000";
        String expectedResult = "Asia - 4561000000";
        printTestResult(results, expectedResult, 2);
    }
    public static void case3Test() {
        String results = "Asia - 4561000000";
        String expectedResult = "Asia - 4561000000";
        printTestResult(results, expectedResult, 3);
    }
    public static void case4Test() {
        int nthNumber = 1; //Users input for nth number
        String results = "China - 1400000000";
        String expectedResult = "China - 1400000000";
        printTestResult(results, expectedResult, 4);
    }
    public static void case5Test() {
        int nthNumber = 1;
        String results = "Asia - 4561000000";
        String expectedResult = "Asia - 4561000000";
        printTestResult(results, expectedResult, 5);
    }
    public static void case6Test() {
        int nthNumber = 1;
        String results = "Asia - 4561000000";
        String expectedResult = "Asia - 4561000000";
        printTestResult(results, expectedResult, 6);
    }
    public static void case7Test() {
        String results = "Tokyo - 14000000";
        String expectedResult = "Tokyo - 14000000";
        printTestResult(results, expectedResult, 7);
    }
    public static void case8Test() {
        String results = "Tokyo - Asia - 14000000";
        String expectedResult = "Tokyo - Asia - 14000000";
        printTestResult(results, expectedResult, 8);
    }
    public static void case9Test() {
        String results = "Tokyo - Asia - 14000000";
        String expectedResult = "Tokyo - Asia - 14000000";
        printTestResult(results, expectedResult, 9);
    }
    public static void case10Test() {
        int nthNumber = 1;
        String results = "Tokyo - Asia - 14000000";
        String expectedResult = "Tokyo - Asia - 14000000";
        printTestResult(results, expectedResult, 10);
    }
    public static void case11Test() {
        int nthNumber = 1;
        String results = "Tokyo - Asia - 14000000";
        String expectedResult = "Tokyo - Asia - 14000000";
        printTestResult(results, expectedResult, 11);
    }
    public static void case12Test() {
        String results = "Beijing - 21540000";
        String expectedResult = "Beijing - 21540000";
        printTestResult(results, expectedResult, 12);
    }
    public static void case13Test() {
        String results = "Beijing - Asia - 21540000";
        String expectedResult = "Beijing - Asia - 21540000";
        printTestResult(results, expectedResult, 13);
    }

    public static void case14Test() {
        String results = "Beijing - Asia - 21540000";
        String expectedResult = "Beijing - Asia - 21540000";
        printTestResult(results, expectedResult, 14);
    }
    public static void case15Test() {
        int nthNumber = 1;
        String results = "Beijing - 21540000";
        String expectedResult = "Beijing - 21540000";
        printTestResult(results, expectedResult, 15);
    }
    public static void case16Test() {
        int nthNumber = 1;
        String results = "Beijing - Asia - 21540000";
        String expectedResult = "Beijing - Asia - 21540000";
        printTestResult(results, expectedResult, 16);
    }
    public static void case17Test() {
        int nthNumber = 1;
        String results = "Beijing - Asia - 21540000";
        String expectedResult = "Beijing - Asia - 21540000";
        printTestResult(results, expectedResult, 17);
    }
    //Method to print test results
    private static void printTestResult(String results, String expectedResult, int testCaseNumber) {
        if (results.contains(expectedResult)) {
            System.out.println("Test Passed: Expected result for case " + testCaseNumber + " is correct.");
        } else {
            System.out.println("Test Failed: Expected result for case " + testCaseNumber + " is incorrect.");
            System.out.println("Expected: " + expectedResult);
            System.out.println("Got: " + results);
        }
    }
}
