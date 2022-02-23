public class RecursionAllSubsetsOfString {
    
    static void findSubsets(String input, String output) {
        // for each character there are two choices -> either consider it or don't consider it
        if(input.length() == 0) {
            System.out.print("\"" + output + "\" ");
            return;
        }
        
        // we generate two outputs based on these choices
        String out1 = output;
        String out2 = output;
        // keep out1 the same as previous output (not considering the new char)
        // generate out2 by considering the char
        out2+=input.charAt(0);
        // now we need to make the input smaller
        // for this, remove the character already added in the input (first char)
        input = input.substring(1);
        
        // now recursively generate outputs based on the new input string and current two outputs
        findSubsets(input, out1);
        findSubsets(input, out2);
    }
  
    public static void main(String args[]) {
       String input = "ab";
       String output = "";
       System.out.println("Input String: " + input);
       System.out.println();
       findSubsets(input, output);
    }
}