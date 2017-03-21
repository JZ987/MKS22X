import java.util.*;

public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	words.add("");
	help(words, s, "", 0);
	//help2(words, s);
	Collections.sort(words);
	return words;
    }
  
    private static void help(ArrayList<String> words, String s, String newWord, int index){
	if(!words.contains(newWord)){
	    words.add(newWord);
	}
	if(index == s.length()){
	    return;
	}
	String temp = newWord + s.substring(index, index + 1);
	help(words, s, temp, index + 1);
	help(words, s, newWord, index + 1);
    }

    private static void help2(ArrayList<String> words, String s){
	for(int i = 0; i < s.length(); i++){
	    String current = s.substring(i, i+1);
	    int max = words.size();
	    for(int j = 0; j < max; j++){
		String word = words.get(j);
		word += current;
		words.add(word);
	    }
	}
    }

    public static void main(String[] args){
	System.out.println(combinations("hello"));
    }
}
