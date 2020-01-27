import java.util.*;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        
      StringBuilder sb = new StringBuilder();
        
      // split the string into words
      String[] words = sentence.split("\\s");
        
        // for each word in dictionary
        for(String dictWord: dict) {
            
            // check each word in the string
            for(int i=0; i<words.length; i++) {
                String word = words[i];
                
                // if the word begins with the word in dict and the dict form is smaller
                if(word.startsWith(dictWord) && dictWord.length() < word.length())
                    words[i] = dictWord;
            }
        }
       
        // construct the modified string from words
        for(int i=0; i<words.length;i++) {
            sb.append(words[i]);
            if(i!=words.length-1)
                sb.append(" ");
        }
        
        return sb.toString();
    }
}