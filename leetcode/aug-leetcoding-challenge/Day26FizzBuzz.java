class Day26FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        
        if(n == 0) return result;
        
        for(int num=1; num <= n; num++) {
            // check if it is a multiple of 3 and 5
            if(num % 3 == 0 && num % 5 == 0)
                result.add("FizzBuzz");
            // multiple of 3
            else if(num % 3 == 0)
                result.add("Fizz");
            // multiple of 5
            else if(num % 5 ==0)
                result.add("Buzz");
            else
            // other numbers
                result.add(Integer.toString(num));
        }
        
        return result;
    }
}