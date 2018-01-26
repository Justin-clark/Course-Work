// Justin Clark
// judclark
// Queens.java
// acts as a seperate class for all queens that has a constructor

class Queens {
  private int col;
  private int row;

  // constructor
  public Queens(int c, int r) {
    this.col = c;
    this.row = r;
  }
  // checks column, row, and diagonals to see if queens are attacking
  public boolean isAttacking(Queens q) {
    // checks for columns and rows
    if((col == q.col) || (row == q.row)) {
      return true;
    }
    // checks for diagonals
    if((Math.abs(col - q.col)) == (Math.abs(row - q.row))) {
      return true;
    }
    return false;
  }
  // returns the column of a certain queen
  public int getCol() {
    return col;
  }
  // returns the row of a certain queen
  public int getRow() {
    return row;
  }


}
