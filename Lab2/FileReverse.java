// Justin Clark
// judclark
// FileReverse.java
// Takes in a file as the first argument and copies its tokens reversed onto
// a new file, the second argument

import java.io.*;
import java.util.Scanner;

class FileReverse {
   public static void main(String[] args) throws IOException {
      // check number of command line arguments is at least 2
      if(args.length < 2){
         System.out.println("Usage: java –jar FileReverse.jar <input file> <output file>");
         System.exit(1);
      }
      // files
      Scanner in = new Scanner(new File(args[0]));
      PrintWriter out = new PrintWriter(new FileWriter(args[1]));
      // check for next line then print the reverse
      while(in.hasNextLine()){
        // trim leading and trailing spaces, then add one trailing space so
        // split works on blank lines
        String line = in.nextLine().trim() + " ";
        // split line around white space
        String[] token = line.split("\\s+");
        // picks out each token, executes stringReverse on it
        // then prints it
        for(int i = 0; i < token.length; i++){
          String reverse = stringReverse(token[i]);
          out.println(reverse);
        }
    }
      //close files
      in.close();
      out.close();
    }
    //reversing strings
    public static String stringReverse(String s) {
      String reverse = "";
      for(int i = s.length()-1; i >= 0; i--){
        char index = s.charAt(i);
        reverse += s.valueOf(index);
      }
      return reverse;
    }
}
