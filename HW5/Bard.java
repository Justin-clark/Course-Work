import java.io.*;
import java.lang.*;
import java.util.*;

class Bard {

  public static void main(String[] args) throws IOException {
    // needs at least two arguments to run
    if (args.length < 2) {
      System.out.println("Usage: java –jar Bard.jar <input file> <output file>");
      System.exit(1);
    }
    // input file as first argument and output file as second argument
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new FileWriter(args[1]));
    Scanner shakespeare = new Scanner(new File("shakespeare.txt"));
    Hashtable<String,Integer> hashtable = new Hashtable<String,Integer>();

    while (shakespeare.hasNextLine()) {
      //tokenize and remove punctuation from each line
      String line = shakespeare.nextLine().trim() + "";
      line = line.replace("?"," ");
      line = line.replace(",","");
      line = line.replace("."," ");
      line = line.replace("!"," ");
      line = line.replace(":"," ");
      line = line.replace(";"," ");
      line = line.replace("["," ");
      line = line.replace("]"," ");
      line = line.toLowerCase();
      String[] tokens = line.split("\\s+");

      //creates hashtable of shakespeare words
      for (int i = 0; i < tokens.length; i++) {
        //if youve seen the key before increment frequency
        if(hashtable.containsKey(tokens[i])) {
          int frequency = hashtable.get(tokens[i]);
          frequency++;
          hashtable.put(tokens[i],frequency);
        } else {
          hashtable.put(tokens[i],1);
        }
      }
    }
    //make an iterator that goes over the keys in the hashtable
    Set<String> keys = hashtable.keySet();
    Iterator<String> itr = keys.iterator();
    int max = 1;
    String str;
    //find the biggest word
    while (itr.hasNext()) {
      //finding the longest word length
      str = itr.next();
      if (str.length() > max) {
        max = str.length();
      }
    }

    //store the hashtable values in an arraylist of arraylist
    ArrayList<Word>[] list = new ArrayList[max+1];
    for (int i = 1; i <= max; i++) {
      list[i] = new ArrayList<Word>();
      //restart cycle for the iterator
      itr = keys.iterator();
      while(itr.hasNext()) {
        str = itr.next();
        if(str.length() == i) {
          list[i].add(new Word(str,hashtable.get(str)));
        }
      }
    }

    // sorts arraylist
    for (int i = 1; i <= max; i++) {
      Collections.sort(list[i]);
    }

    while(in.hasNextLine()) {
      String line = in.nextLine();
      //store inputs
      String[] tokens = line.trim().split("\\s+");
      //parse inputs
      int len = Integer.parseInt(tokens[0]);
      int rank = Integer.parseInt(tokens[1]);
      //print out keys if they are there
      if (len > list.length-1 || list[len].size() <= rank) {
        out.println("-");
      } else{
        out.println(list[len].get(rank).getKey());
      }
    }

    in.close();
    out.close();
    shakespeare.close();
  }
}
