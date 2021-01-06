/*
* The Main program handles the inputs and outputs of the binarySearch object.
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
  private static final int maxNumberOfValues = 250;
  private static final int maxGeneratedNumber = 100;
  private static int temp;

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
                + "✓ Numbers Shown Successfully ✓";
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
  public static String search(String searchedNumber, int position,
                              String foundPositions) {
    try {
      int searchedInt = Integer.parseInt(searchedNumber);
      if (position < maxNumberOfValues) {
        if (values.get(position) == searchedInt) {
          foundPositions += " " + (position + 1);
          return search(searchedNumber, position + 1, foundPositions);
        }

        return search(searchedNumber, position + 1, foundPositions);

      } else if (foundPositions.equals("")) {

        return ("X Numbers Could Not Be Found X");

      } else {
        return "✓ Numbers Found Successfully ✓\n Found at positions:\n" 
                + foundPositions;
      }
    } catch (Exception e) {
      return ("X Numbers Could Not Be Found X");
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
    int searchPosition = 0;

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
        System.out.println("What number would you like to search for?");
        String searchedNumber = scanSearch.nextLine();
        System.out.println(search(searchedNumber, searchPosition,
                                  foundPositions));
        System.out.println("");
      }

    } catch (Exception e) {
      System.out.println("AN ERROR HAS OCCURED");
    }
  }
}
