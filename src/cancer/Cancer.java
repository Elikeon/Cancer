/*
 * Jared Craig
 * 6/11/2018
 * Makes cancer and deletes it
 */

package cancer;

public class Cancer {
 public static String grid[][];
  public static int blobSize;

  public static void main(String[] args) {
    int row, col;
    //Create 2D array size 12 x 12
    grid = new String[16][16];

    //Fill the array with blanks
    for (row = 0; row < 15; row++) {
      for (col = 0; col < 15; col++) {
        grid[row][col] = "+";
      }
    }
 for (int i = 0; i <4; i++) {
     
    int blobRow = (int) (Math.random() * 11 + 2);
    int blobCol = (int) (Math.random() * 11 + 2);
    floodFill(blobRow,blobCol);
    
 }
    //Fill 70 random elements in the array with an asterisk
    //Do no choose an element along the border
    //The border will always contain elements with spaces
    //(blank border)
 //   for (int i = 0; i < 70; i++) {
   //   row = (int) (Math.random() * 13 + 1);
   //   col = (int) (Math.random() * 13 + 1);
   //   grid[row][col] = "-";
   // }

    //Print out the current grid
    displayGrid();
for (row = 0; row < 15; row++) {
      for (col = 0; col < 15; col++) {
       if(grid[row][col].equals("-"))
          grid[row][col] = " ";
      }
    }
    //variable to determine the size of the blob
    blobSize = 0;

    //Pick one random element in the array that is not along the
    //border and remove the blob at that location
    //NOTE: if a blank is chosen, the blob size is 0
    //and nothing is removed
  
 
  
    System.out.println("The blob had " + blobSize +
      " items in it");
    System.out.println("The new grid is:");
    //Print out the new grid
    displayGrid();
  }

  public static void floodFill(int row, int col) {
    if (grid[row][col].equals("+")) {
     blobSize++;
      grid[row][col] = "-";
      grid[row+1][col+1]= "-";
     grid[row+1][col] = "-";
     grid[row+1][col-1] = "-";
     grid[row][col+1] = "-";
     grid[row-1][col+1] = "-";
     grid[row-1][col] = "-";
     grid[row-1][col-1] = "-";
     grid[row][col-1] = "-";
     
    }
  }

  public static void displayGrid() {
    String output = "";
    for (int row = 0; row <= 14; row++) {
     
      for (int col = 0; col <= 14; col++) {
        output += grid[row][col];
      }
      output += "\n";
    }
    System.out.println(output);
  }
}