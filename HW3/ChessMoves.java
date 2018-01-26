//ChessMoves.java
//checks a linked list to see if a piece is attacking other pieces

import java.io.*;
import java.lang.*;
import java.util.Scanner;

class ChessMoves {
  public static void main(String[] args) throws IOException {
    // needs at least two arguments to run
    if (args.length < 2) {
      System.out.println("Usage: java –jar ChessMoves.jar <input file> <output file>");
      System.exit(1);
    }
    // input file as first argument and output file as second argument
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new FileWriter(args[1]));

      while (in.hasNextLine()) {
        LinkedList list = new LinkedList();
        int col;
        int row;
        String color;
        boolean flag = true;
        //creates two string arrays of the input
        String line = in.nextLine().trim() + "";
        String[] tokens = line.split(": ");
        //first array of chesspieces
        String[] board = tokens[0].split("\\s");
        //second array of moves
        String[] moves = tokens[1].split("\\s");
        //loops through the array with i at the piece type
        for(int i = 0; i < board.length; i+=3){
          //creates col and row as i+1 and i+2
          col = Integer.parseInt(board[i+1]);
          row = Integer.parseInt(board[i+2]);

          //denotes the color for each piece
          if (Character.isUpperCase(board[i].charAt(0))){
            color = "black";
          } else {
            color = "white";
          }

          String type = board[i].toLowerCase();
          //switch cases for inserting pieces into linked list
          switch(type){
            case "b":
              list.insert(new Bishop(color,col,row));
              break;
            case "r":
              list.insert(new Rook(color,col,row));
              break;
            case "q":
              list.insert(new Queen(color,col,row));
              break;
            case "n":
              list.insert(new Knight(color,col,row));
              break;
            case "k":
              list.insert(new King(color,col,row));
              break;
            case "p":
              list.insert(new Pawn(color,col,row));
              break;
            default:
              System.out.println("You have an error, idiot");
              break;
            }
        }
        String colorChecker = "white";
        for(int i = 0; i < moves.length; i+=4) {

          int firstCol = Integer.parseInt(moves[i]);
          int firstRow = Integer.parseInt(moves[i+1]);
          int endCol = Integer.parseInt(moves[i+2]);
          int endRow = Integer.parseInt(moves[i+3]);


          ChessPiece test = list.find(firstCol,firstRow);
          ChessPiece destination = list.find(endCol,endRow);
          //Checks to see if there is a piece at the first move
          if (test == null || test.getColor() != colorChecker) {
            flag = false;
            out.println(firstCol + " " + firstRow + " " +
             endCol + " " + endRow + " " + "illegal");
             break;
          }
          //if there is not a piece at destination, update board
          if (destination == null) {
            //if the piece cannot move return illegal
            if(test.canMove(endCol,endRow,list) == false) {
              flag = false;
              out.println(firstCol + " " + firstRow + " " +
               endCol + " " + endRow + " " + "illegal");
              break;
            }
            //update board
            list.update(test,endCol,endRow);

          } else if (destination != null) {
            //if the piece cannot move return illegal
            if(test.canMove(endCol,endRow,list) == false || destination.getColor() == colorChecker) {
              flag = false;
              out.println(firstCol + " " + firstRow + " " +
               endCol + " " + endRow + " " + "illegal");
              break;
            }
            // if there is a piece at destination, delete it, then update board
            list.delete(destination);
            list.update(test,endCol,endRow);

          }
          // king check
          if (list.attackingKing(list.findKing(colorChecker).getCol(),
          list.findKing(colorChecker).getRow(), colorChecker, list)) {
            flag = false;
            out.println(firstCol + " " + firstRow + " " +
             endCol + " " + endRow + " " + "illegal");
            break;
          }
          //alternate colors
          if(colorChecker == "white") {
            colorChecker = "black";
          } else if (colorChecker == "black"){
            colorChecker = "white";
          }

        } //end of for loop
        //print legal
        if (flag == true) {
          out.println("legal");
        }
      } // end of while loop
    in.close();
    out.close();
  }
}
