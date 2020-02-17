import java.math.BigInteger;

public class Fibber {
   private final BigInteger ONE = new BigInteger("1");
   private int n;
   
   public Fibber(int n) {
      this.n = n;
   }
   public BigInteger fib() {
      return fib(new BigInteger(Integer.toString(n)), new BigInteger("0"), new BigInteger("1"));
   }
   
   private BigInteger fib(BigInteger n, BigInteger a, BigInteger b) {
      if (n.equals(ONE)) {
         return b;
      } else {
         return fib(n.subtract(ONE), b, a.add(b));
      }
   }
}