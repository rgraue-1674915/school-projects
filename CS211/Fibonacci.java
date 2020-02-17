import java.math.BigInteger;
/* 
*  Ryan Graue 
*  CS 211
*  7/15/19
 */
public class Fibonacci {
	
	// fields, ONE is in any version of Java already
	// but BigInteger.TWO requires Java 9 or higher, so I make one here
	private final BigInteger TWO = new BigInteger("2");
	private final BigInteger ONE = new BigInteger("1");
	private int n; // the boring old 32-bit limited int
	
	// only one constructor needed
	public Fibonacci(int number) {
		n = number;
	}
   
   // getter method for n
   public int getN () {
      return n;
   }
	
	// Chapter 12, Exercise 2, code from page 128-9.
	public int fibForLoop() {
		int n1 = 1;
		int n2 = 1;
		for (int i = 3; i <= n; i++) {
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n2;
	}	
	
	// Chapter 12, same exercise
	// public accessor into recursive helper
	public int fibonacci() {
		return fibonacci(n, 0, 1, 1);
	}
	
	// private recursive helper given in text
	// Chapter 12, page 821
   //
   // @Param n          the number in the fibonacci series needed to be found
   // @Param prev       the previous number in the series
   // @Param current    The current number in the series
   // @Param round      the the number in the series that the process is on
    private int fibonacci(int n, int prev, int current, int round) {
        if (round == n) {
         return current;
        }
        round++;
        int hold = current;
        current = current+= prev;
        prev = hold;
        return fibonacci(n, prev, current, round);
        
    }

    // Exactly the same concept as above, but using BigInteger
    // This allows us to go up to any size integer
	public BigInteger bigFastFib() {
		return bigFastFib(new BigInteger(Integer.toString(n)), new BigInteger("0"),
                     new BigInteger("1"), new BigInteger("1"));
	}
	
	// recursive helper
   //
   // @Param n          the number in the fibonacci series needed to be found
   // @Param prev       the previous number in the series
   // @Param current    The current number in the series
   // @Param round      the the number in the series that the process is on// 
    private BigInteger bigFastFib(BigInteger n, BigInteger prev, BigInteger current, BigInteger round) {
        if (round.compareTo(n) >= 0) {
            return current;
        } else {
           round = round.add(ONE);
           BigInteger hold = current;
           current = current.add(prev);
           prev = hold;
           return bigFastFib(n, prev, current, round);
        }
    }	
	
   // returns th enth fibonacci number as a BigInteger
   public BigInteger bigFib() {
      return bigFib(new BigInteger(Integer.toString(n)));
   }
   
   // recursive helper
   //
   // @Param n    The number in the series needed to be found
   private BigInteger bigFib(BigInteger n) {
      if (n.equals(new BigInteger("0"))) {
         return new BigInteger("0");
      } else if (n.equals(new BigInteger("1"))) {
         return new BigInteger("1");
      } else {
         return bigFib(n.subtract(new BigInteger("1"))).add(bigFib(n.subtract(new BigInteger("2"))));
      }
   }

}
