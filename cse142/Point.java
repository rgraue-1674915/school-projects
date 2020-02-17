public class point {
   private int x;
   private int y;
   
   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public void setX(int newX) {
      x = newX;
   }
   
   public void setY(int newY) {
      y = newY;
   }
   
   public double originDist () {
      return Math.sqrt(x * x + y * y);
   }
   
   public double pointDist (int newX, int newY) {
      return Math.sqrt(x * newX + y * newY);
   }
   
   public void translate (int xChange, int yChange) {
      x += xChange;
      y += yChange;
      System.out.println();
      System.out.printf("new point at (%d,%d)\n",x,y);
      System.out.println();
   }
   
}