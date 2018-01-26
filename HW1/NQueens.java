// Justin Clark
// judclark
// NQueens.java
// prints out the column and rows in ascending order of queens that cannot
// attack each other on a chessboard, if this is not possible, print no solution

import java.io.*;
import java.lang.*;
import java.util.Scanner;

class NQueens {
  // global array of queens that get stored with the initial indexes
  public static Queens[] q;
  // sorted array of queens with columns in ascending order
  public static Queens[] qFinal;

  public static void main(String[] args) throws IOException {
    // needs at least two arguments to run
    if (args.length < 2) {
      System.out.println("Usage: java –jar NQueens.jar <input file> <output file>");
      System.exit(1);
    }
    // input file as first argument and output file as second argument
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new FileWriter(args[1]));

    // copied token code
    // looked at parseInt info online
    while (in.hasNextLine()) {
      String line = in.nextLine();
      String[] tokens = line.split("\\s+");
      int[] numbers = new int[tokens.length];
      for(int i = 0; i < tokens.length; i++){
        numbers[i] = Integer.parseInt(tokens[i]);
      }

      // n = size
      // qRow = first queen row
      int n = numbers[0];
      // qCol = first queen col
      int qCol = numbers[1];
      // qRow = first queen row
      int qRow = numbers[2];

      q = new Queens[n];
      qFinal = new Queens[n];
      // initializes all indexes in the array with 0,0 so they are not null
      for(int i =0; i < q.length; i++) {
        q[i] = new Queens(0,0);
      }
      // first index is the first column and row given through input file
      q[0] = new Queens(qCol,qRow);

      // calls nQueens to see if all queens can be placed
      if (nQueens(n-1,1)) {
        //sorts finished queens
        sortedQueen(q);
        // prints column and row of finished array if true
        for(int i = 0; i < q.length; i ++) {
          String test = qFinal[i].getCol() + " " + qFinal[i].getRow() + " ";
          out.print(test);
        }
        out.println();
      } else {
        // prints no solution if nQueens is false
        out.println("No solution");
      }

    }

    in.close();
    out.close();
  }

  // recursive method for placing queens and backtracking
  public static boolean nQueens(int n, int index) {
    //base case
    if (n == 0) {
      return true;
    }
    // loops through board
    for(int i = 1; i < q.length+1; i++){
      for(int j = 1; j < q.length+1; j++){
        // checks to see if a queen at col,row can be added at the index
        if(addQueen(index,i,j)) {
          // if true, call nQueens recursion
          if(nQueens(n-1, index+1)) {
            // if true, queens have been placed so you can return true
            return true;
          }
        }
      }
    }
    // outside of nested for-loop so it has checked the whole board to put a
    //queen and has failed, move queen
    return false;
  }

  // adds queens to array of queens
  public static boolean addQueen(int index, int c, int r) {
    // makes a queen at the index
    q[index] = new Queens(c,r);
    // checks to see if the queen is attack previous queens
    for(int i = index; i > -1; i--){
      for(int j = i-1; j > -1; j--){
        //if attacking then wipe the queen and return false
        if(q[i].isAttacking(q[j])){
          q[i] = new Queens(0,0);
          return false;
        }
      }
    }
    // if not attacking, return true
    return true;
  }

  // method to sort the queens in ascending order
  public static void sortedQueen(Queens[] q) {
    for (int i = 0; i < q.length; i ++){
      int index = q[i].getCol();
      qFinal[index-1] = q[i];

    }
  }

}
