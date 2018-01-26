// Pawn.java
// class for pawns

class Pawn extends ChessPiece {
  // constructor
  public Pawn(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  //checks to see if a Pawn is attacking a ChessPiece
  public boolean isAttacking(ChessPiece c) {
    //makes sure piece can only attack upward
    if (color == "white") {
      // checks for diagonals one spot away upward
      if((Math.abs(col - c.col)) == 1 && (c.row == row + 1)) {
        return true;
      }
    }
    //makes sure piece can only attack upward
    if (color == "black") {
      // checks for diagonals one spot away downward
      if((Math.abs(col - c.col)) == 1 && (c.row == row - 1)) {
        return true;
      }
    }
    return false;
  }
  //can the pawn move to desired location
  public boolean canMove(int endCol, int endRow, LinkedList list) {

    //if pawn is white
    if (color == "white") {
      //pawn can move diagonally if its capturing a piece
      if ((Math.abs(col - endCol) == 1 && endRow == row + 1) && list.valid(endCol,endRow)) {
        return true;
      }
      //special case that pawn is at start
      if (row == 2) {
        if (endCol == col && endRow == row+1 && !list.valid(endCol,endRow)
        || endCol == col && endRow == row+2 && !list.valid(endCol,endRow-1) && !list.valid(endCol,endRow)) {
          return true;
        }
      } else {
        if (endCol == col && endRow == row+1 && !list.valid(endCol,endRow)) {
          return true;
        }
      }
    }
    //if pawn is black
    if (color == "black") {
      //pawn can move diagonally if its capturing a piece
      if ((Math.abs(col - endCol) == 1 && endRow == row - 1) && list.valid(endCol,endRow)) {
        return true;
      }
      //special case that pawn is at start
      if (row == 7) {
        if (endCol == col && endRow == row-1 && !list.valid(endCol,endRow)
        || endCol == col && endRow == row-2 && !list.valid(endCol,endRow+1) && !list.valid(endCol,endRow)) {
          return true;
        }
      } else {
        if (endCol == col && endRow == row-1 && !list.valid(endCol,endRow)) {
          return true;
        }

      }
    }
    return false;
  }

}
