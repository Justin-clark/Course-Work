// Rook.java
// class for rooks

class Rook extends ChessPiece {
  // constructor
  public Rook(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a Rook is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    // checks for columns and rows
    if((col == c.col) || (row == c.row)) {
      return true;
    }
    return false;
  }
  //can rook move to desired location
  public boolean canMove(int endCol, int endRow, LinkedList list) {
    //checks every col until destination
    if (row == endRow) {
      if (col < endCol) {
        for (int i = col+1; i < endCol; i++){
          if (list.valid(i,row)) {
            return false;
          }
        }
      }
      if (col > endCol) {
        for (int i = col-1; i > endCol; i--){
          if (list.valid(i,row)) {
            return false;
          }
        }
      }
      return true;
    }
    if (col == endCol) {
      //checks every row until destination
      if(row < endRow) {
        for (int i = row+1; i < endRow; i++) {
          if (list.valid(col,i)) {
            return false;
          }
        }
      }
      if (row > endRow) {
        for (int i = row-1; i > endRow; i--) {
          if (list.valid(col,i)) {
            return false;
          }
        }
      }
      return true;
    }

    return false;
  }

}
