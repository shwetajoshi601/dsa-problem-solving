class CountPrimes {
    
    public int countPrimes(int n) {
        int count = 0;
        
        // Using Sieve of Eratosthenes technique
        // Step 1: Create a boolean array for every number upto n
        boolean[] primes = new boolean[n+1];
        
        // Step 1.a: initialise every number as true
        for(int i=0; i<primes.length; i++)
            primes[i] = true;
        
        // Step 2: for each number, iterate till it's square
        for(int p=2; p*p <= n; p++) {
            
            // if true, means this number is not yet processed
            if(primes[p]) {
                
                // mark all multiples from its square to n as not prime
                for(int j=p*p; j<=n; j+=p) {
                    primes[j] = false;
                }
            }
        }
   
        // Step 3: finally, the numbers marked as true are prime numbers
        for(int i=2; i<n; i++) {
            if(primes[i])
                count++;
        }
        
        return count;
    }
}