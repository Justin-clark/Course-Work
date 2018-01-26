// Bishop.java
// class for bishops

class Bishop extends ChessPiece{
  // constructor
  public Bishop(String color, int c, int r) {
    this.color = color;
    this.col = c;
    this.row = r;
  }
  // checks to see if a Bishop is attacking a Chesspiece
  public boolean isAttacking(ChessPiece c) {
    //checks for diagonals
    if((Math.abs(col - c.col)) == (Math.abs(row - c.row))) {
      return true;
    }
    return false;
  }
  //can bishop move to desired location
  public boolean canMove(int endCol, int endRow, LinkedList list) {
    //checks every quadrant until destination
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
    return false;
  }
}
