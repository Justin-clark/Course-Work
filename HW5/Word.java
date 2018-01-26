import java.io.*;
import java.lang.*;
import java.util.*;

class Word implements Comparable<Word>{
  private String key;
  private int value;

  public Word(String word,int frequency) {
    key = word;
    value = frequency;
  }

  public String getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  public int compareTo(Word word) {
    if (this.value == word.value) { //frequency is the same
      return key.compareTo(word.key); //sort lexicographically if frequencies are equal
    } else if (this.value > word.value) { //frequency is greater than sort first
      return -1;
    } else { //frequency is less than sort after
      return 1;
    }
  }

}
