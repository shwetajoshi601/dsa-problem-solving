import java.util.*;

public class RecursionPermutationByChangingCase {
    
    static void findPermutations(String input, String output) {
        // for each character there are two choices -> either consider it in the same case or change the case
        // assume that the input is lowercase always
        if(input.length() == 0) {
            System.out.print("\"" + output + "\" ");
            return;
        }
        
        // we generate two outputs based on these choices
        String out1 = output;
        String out2 = output;
        
        out1+=input.charAt(0);
        out2+=Character.toUpperCase(input.charAt(0));
        
        // now we need to make the input smaller
        // for this, remove the character already added in the input (first char)
        input = input.substring(1);
        
        // now recursively generate outputs based on the new input string and current two outputs
        findPermutations(input, out1);
        findPermutations(input, out2);
    }
  
    public static void main(String args[]) {
       String input = "abc";
       String output = "";
       System.out.println("Input String: " + input);
       System.out.println();
       findPermutations(input, output);
    }
}
