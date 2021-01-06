/*
* The Main program is a recreation of the binarySearch program.
*
* @author  Ben Whitten
* @version 1.0
* @since   2021-1-6 
*/

import java.util.ArrayList;  // Import the ArrayList class
import java.util.Scanner;  // Import the Scanner class

///////////////////////////////////////////////////////////////////////////////

public class Main {

  // variables for later.
  private static int maxNumberOfValues = 250;
  private static final int maxGeneratedNumber = 100;
  private static int temp;
  private static int low = 0;

  private static ArrayList<Integer> values = new ArrayList<Integer>();

  /////////////////////////////////////////////////////////////////////////////
  /**
   * Generate function generates the list of numbers.
   */
  public static String generate(int currentNumberOfValues) {
    
    try {
      // Generating the list.
      int randomNumber = (int) (Math.random() * maxGeneratedNumber + 1);
      values.add(randomNumber);

      // Returning the arraylist if it's full.
      if (currentNumberOfValues == maxNumberOfValues) {

        return ("✓ Numbers Were Created Successfully ✓");

      // Sending it back through if it's not full.
      } else {

        return generate(currentNumberOfValues + 1);
        
      }
    // Catching errors.
    } catch (Exception e) {

      return ("X Numbers Were Not Created Successfully X");

    }
  }
    
  /////////////////////////////////////////////////////////////////////////////
  /**
   * Sort function sorts the list of numbers.
   */
  public static String sort(int position, int position2) {
    
    try {
  
      // Sorting the numbers.
      for (position = 0; position < maxNumberOfValues; position++) {
        for (position2 = (position + 1); position2 < maxNumberOfValues;
             position2++) {
          if (values.get(position) > values.get(position2)) {
            temp = values.get(position);
            values.set(position, values.get(position2));
            values.set(position2, temp);
          }
        }
      }
      
      // Returning a message to the user to say that the numbers were sorted.
      return ("✓ Numbers Sorted Successfully ✓");

    } catch (Exception e) {
      // Returning a message to say that an error occured.
      return ("X Numbers Were Not Sorted Successfully X");
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  /**
   * Add function adds a number to the list of numbers.
   */
  public static String add(String addNumber) {
    try {
      int addedInt = Integer.parseInt(addNumber);
      values.add(addedInt);
      maxNumberOfValues += 1;

      // Returning a message to the user to say that the numbers were sorted.
      return ("✓ Numbers Added Successfully ✓");

    } catch (Exception e) {
      return ("X Number Was Not Added Successfully X");
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  /**
   * Show function shows the list of numbers.
   */
  public static String show(String numbersAsString, int position) {
    try {
      if (position < maxNumberOfValues) {
        numbersAsString += " ";
        numbersAsString += values.get(position);
        
        if ((position + 1) % 10 == 0) {
          numbersAsString += "\n";
        }

        return show(numbersAsString, position + 1);

      } else {
        return "Current List Values:\n" + numbersAsString
                + "\n✓ Numbers Shown Successfully ✓";
      }

    } catch (Exception e) {
      // Returning a message to say that an error occured.
      return ("X Numbers Could Not Be Shown X");
    }
  }
  
  /////////////////////////////////////////////////////////////////////////////
  
  /**
   * This function handles the input and output of the program.
   */
  public static int search(String searchedNumber,
                              int low, int high, int timeThrough) {

    int searchedInt = Integer.parseInt(searchedNumber);

    int middle = (low + high) / 2;
        
    if (high < low) {
      return -1;
    }
    
    if (timeThrough >= maxNumberOfValues) {
      return -1;
    }

    if (searchedInt == values.get(middle)) {
      return middle + 1;
    } else if (searchedInt < values.get(middle)) {
      return search(searchedNumber, low, middle - 1, timeThrough + 1);
    } else {
      return search(searchedNumber, middle + 1, high, timeThrough + 1);
    }
  }

  /////////////////////////////////////////////////////////////////////////////

  /**
   * This function handles the input and output of the program.
   */
  public static void main(String[] args) {

    // Creating a scanner.
    Scanner scanSearch = new Scanner(System.in);

    String numbersAsString = "";
    String foundPositions = "";
    int currentNumberOfValues = 0;
    int sortPosition1 = 0;
    int sortPosition2 = 1;
    int showPosition1 = 0;

    try {
      // Generating the numbers.
      System.out.println(generate(currentNumberOfValues));
      System.out.println("");

      // Sorting the numbers.
      System.out.println(sort(sortPosition1, sortPosition2));
      System.out.println("");

      // Showing the numbers
      System.out.println(show(numbersAsString, showPosition1));
      System.out.println("");
      
      while (true) {
        System.out.println("What would you like to do? [search] [add]");
        String option = scanSearch.nextLine();
        
        if (option.equals("search")) {
          System.out.println("");
          System.out.println("What number would you like to search for?");
          String searchedNumber = scanSearch.nextLine();
          int timeThrough = 0;
          System.out.println("Found at position: " + search(searchedNumber,
                                                            low,
                                                            maxNumberOfValues,
                                                            timeThrough));
          System.out.println("");

        } else if (option.equals("add")) {
          System.out.println("");
          System.out.println("What number would you like to add to the list?");
          String addNumber = scanSearch.nextLine();
          System.out.println("");
          System.out.println(add(addNumber));
          System.out.println("");
          // Sorting the numbers.
          sortPosition1 = 0;
          sortPosition2 = 1;
          System.out.println(sort(sortPosition1, sortPosition2));
          System.out.println("");
          // Showing the numbers.
          numbersAsString = "";
          showPosition1 = 0;
          System.out.println(show(numbersAsString, showPosition1));
          System.out.println("");

        } else {
          System.out.println("ERROR: INVALID INPUT");
        }
      }

    } catch (Exception e) {
      System.out.println("");
      System.out.println("AN ERROR HAS OCCURED");
    }
  }
}
