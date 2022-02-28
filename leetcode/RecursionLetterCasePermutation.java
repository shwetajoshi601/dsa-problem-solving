import java.util.*;

class RecursionLetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<String>();
        
        String output = "";
        getPermutations(s, output, result);
        
        return result;
    }
    
    void getPermutations(String input, String output, List<String> result) {
        if(input.length() == 0) {
            result.add(output);
            return;
        }
        
        // remove the current character to make input smaller for next calls
        char curr = input.charAt(0);
        input = input.substring(1);
        
        // if a digit is found
        // only one possible choice -> append as it is
        if(Character.isDigit(curr)) {
            output+=curr;
            getPermutations(input, output, result);
        } else {
        // for chars, two possible choices, as it is and change the case (one lowercase one uppercase)
            String out1 = output;
            String out2 = output;
            
            out1+=Character.toLowerCase(curr);
            out2+=Character.toUpperCase(curr);
            
            // recursively call with the two choices
            getPermutations(input, out1, result);
            getPermutations(input, out2, result);
        }
    }
}