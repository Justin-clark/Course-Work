//ChessBoard.java
//checks a linked list to see if a piece is attacking other pieces

import java.io.*;
import java.lang.*;
import java.util.Scanner;

class ChessBoard {
  public static void main(String[] args) throws IOException {
    // needs at least two arguments to run
    if (args.length < 2) {
      System.out.println("Usage: java –jar Chessboard.jar <input file> <output file>");
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
        String[] firstPiece = tokens[0].split("\\s");
        //creates the first piece
        int firstCol = Integer.parseInt(firstPiece[0]);
        int firstRow = Integer.parseInt(firstPiece[1]);
        //splits all the strings by whitespace
        String[] chessPieces = tokens[1].split("\\s");
        //loops through the array with i at the piece type
        for(int i = 0; i < chessPieces.length; i+=3){
          //creates col and row as i+1 and i+2
          col = Integer.parseInt(chessPieces[i+1]);
          row = Integer.parseInt(chessPieces[i+2]);
          //checks to see if there is a piece at the same col and row
          if (list.valid(col,row))  {
            out.println("Invalid");
            flag = false;
            break;
          }
          //denotes the color for each piece
          if (Character.isUpperCase(chessPieces[i].charAt(0))){
            color = "black";
          } else {
            color = "white";
          }

          String type = chessPieces[i].toLowerCase();
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
            default:
              System.out.println("You have an error, idiot");
              break;
            }
        }
        ChessPiece test = list.find(firstCol,firstRow);
        //Checks to see if first piece is in the list
        if (test == null) {
          flag = false;
          out.println("-");
        }
        //Checks to see if first piece is a queen
        if (test instanceof Queen && flag == true) {
          if (test.getColor() == "black") {
            out.print("Q ");
          } else {
            out.print("q ");
          }
        }
        //Checks to see if first piece is a king
        if (test instanceof King && flag == true) {
          if (test.getColor() == "black") {
            out.print("K ");
          } else {
            out.print("k ");
          }
        }
        //Checks to see if first piece is a rook
        if (test instanceof Rook && flag == true) {
          if (test.getColor() == "black") {
            out.print("R ");
          } else {
            out.print("r ");
          }
        }
        //Checks to see if first piece is a bishop
        if (test instanceof Bishop && flag == true) {
          if (test.getColor() == "black") {
            out.print("B ");
          } else {
            out.print("b ");
          }
        }
        //Checks to see if first piece is a knight
        if (test instanceof Knight && flag == true) {
          if (test.getColor() == "black") {
            out.print("N ");
          } else {
            out.print("n ");
          }
        }

        if (flag == true && list.traverse(test)) {
          out.println("y");
        } else if(flag == true && !list.traverse(test)) {
          out.println("n");
        }

      } // end of while loop
    in.close();
    out.close();
  }
}
