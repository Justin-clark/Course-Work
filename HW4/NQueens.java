// Justin Clark
// judclark
// NQueens.java
// prints out the column and rows in ascending order of queens that cannot
// attack each other on a chessboard, if this is not possible, print no solution

import java.io.*;
import java.lang.*;
import java.util.*;

class NQueens {

  public static void main(String[] args) throws IOException {
    // needs at least two arguments to run
    if (args.length < 2) {
      System.out.println("Usage: java –jar NQueens.jar <input file> <output file>");
      System.exit(1);
    }
    // input file as first argument and output file as second argument
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new FileWriter(args[1]));

    // pass in file and read it
    while (in.hasNextLine()) {
      //checker for invalid board
      boolean flag = true;
      String line = in.nextLine();
      //store inputs
      String[] tokens = line.split("\\s+");
      //store board size
      int boardSize = Integer.parseInt(tokens[0]);
      //make stack
      Stack<Queens> stack = new Stack<Queens>();
      //parse inputs into col and row
      for(int i = 1; i < tokens.length; i+=2){
        int qCol = Integer.parseInt(tokens[i]);
        int qRow = Integer.parseInt(tokens[i+1]);
        //pushs given inputs into the stack
        stack.push(new Queens(qCol,qRow));
      }
      //Test case for invalid inputs
      if (stack.size() != 1) {
        //checks to see if inputs are attacking
        if (isAttackingStack(stack)) {
          flag = false;
          out.println("No solution");
        }
      }

      //create an arraylist to store the free cols
      ArrayList<Integer> freeCol = new ArrayList<Integer>(boardSize);
      freeCol.add(0);
      for (int i = 1; i < boardSize+1; i++){
        freeCol.add(i);
      }

      //Makes the freeCol
      freeColumn(freeCol,stack);

      if(freeCol.size() == 1) {
        flag = false;
        printStack(out,stack);
      }

      //checks the board and sees if the pieces in the stack are attacking
      outerloop:
      while (flag) {
        for (int i = 1; i < freeCol.size();) { //free columns
          for(int j = 1; j < boardSize+1; j++) { //rows

            //base case success
            if(stack.size() == boardSize) {
              printStack(out,stack);
              break outerloop;
            }

            stack.push(new Queens(freeCol.get(i),j));

            //check to see if top of stack is attacking other pieces
            if (isAttackingStack(stack)) {
              //check to see if you are at the end of the board row-wise
              if(stack.peek().getRow() == boardSize){
                stack.pop();

                //check to see if the previous queen is at the end of the board
                if (stack.peek().getRow() == boardSize && stack.size() != 1) {
                  stack.pop();
                  //have to decrement twice to reach the column at the top of the stack
                  i -=2;
                  //set the row equal to the row of the queen at the top of the stack
                  j = stack.peek().getRow();
                  stack.pop();
                } else {
                  //only decrement once if the prev queen is not at the end of the board
                  i--;
                  j = stack.peek().getRow();
                  stack.pop();
                }

                //base case failure
                if(i <=0) {
                  flag = false;
                  out.println("No solution");
                  break outerloop;
                }

              } else {
                //if the pieces are attacking but are not at the end, just pop
                //and keep moving up columns
                stack.pop();
              }
            } else {
              // queen is not attacking stack, increment to the next free column and restart
              i++;
              break;
            }
          }
        }
      }
    }

    in.close();
    out.close();
  }

  //Check to see if the most recent queen is attacking prev queens
  public static boolean isAttackingStack(Stack<Queens> stack) {
    for(int i = stack.size()-2; i >= 0; i--) {
      if(stack.peek().isAttacking(stack.get(i))) {
        return true;
      }
    }
    return false;
  }

  //Print the stack
  public static void printStack(PrintWriter out,Stack<Queens> stack) {

    if (stack.isEmpty()) {
      System.out.println("Empty");
    } else {
      //compares the columns of the queens with the outer for loop
        for(int i = 1; i < stack.size()+1; i++) {
          for(int j = 0; j < stack.size(); j++) {
            if ((stack.get(j).getCol()) == i) {
              out.print(stack.get(j).getCol() + " " + stack.get(j).getRow() + " ");
            }
          }
        }
        out.println();
    }
  }

  //remove all columns that are already in stack
  public static void freeColumn(ArrayList<Integer> freeCol, Stack<Queens> stack) {
    for (int i = stack.size()-1; i >= 0; i--) {
      freeCol.remove(new Integer(stack.get(i).getCol()));
    }
  }

}
