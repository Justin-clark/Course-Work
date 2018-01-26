// Queen.java
// class for queens

class Queen extends ChessPiece{
  // constructor
  public Queen(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a Queen is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    // checks for columns and rows
    if((col == c.col) || (row == c.row)) {
      return true;
    }
    // checks for diagonals
    if((Math.abs(col - c.col)) == (Math.abs(row - c.row))) {
      return true;
    }
    return false;
  }
  //can queen move to desired location
  public boolean canMove(int endCol, int endRow, LinkedList list) {
    //checks every quadrant until destination for diagonals
    if ((Math.abs(col - endCol)) == (Math.abs(row - endRow))) {
      //checks second quadrant
      if (col > endCol && row < endRow) {
        for (int i = col-1,j = row+1; i > endCol; i--,j++){
          if (list.valid(i,j)) {
            return false;
          }
        }
      }
      //checks first quadrant
      if (col < endCol && row < endRow) {
        for (int i = col+1,j = row+1; i < endCol; i++,j++){
          if (list.valid(i,j)) {
            return false;
          }
        }
      }
      //checks third quadrant
      if (col > endCol && row > endRow) {
        for (int i = col-1,j = row-1; i > endCol; i--,j--){
          if (list.valid(i,j)) {
            return false;
          }
        }
      }
      //checks fourth quadrant
      if (col < endCol && row > endRow) {
        for (int i = col+1,j = row-1; i < endCol; i++,j--){
          if (list.valid(i,j)) {
            return false;
          }
        }
      }
      return true;
    }
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
    //checks every row until destination
    if (col == endCol) {
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
