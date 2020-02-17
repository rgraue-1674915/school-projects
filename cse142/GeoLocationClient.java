// Ryan Graue
// 11/27/18
// CSE 142
// TA: Ivy Yu
// assignment #8 part B
// 
// this program makes use of the GeoLocation class and creates certain locations
// and outputs their location and distance from eachother
public class GeoLocationClient {
   public static void main (String[] args) {
      GeoLocation stash = new GeoLocation(34.988889,-106.614444);
      GeoLocation abq = new GeoLocation(34.989978, -106.614357);
      GeoLocation fbi = new GeoLocation(35.131281 , -106.61263);   
      location("the stash" , stash);
      location("ABQ studio" , abq);
      location("FBI building" , fbi);
      
      distances(stash, abq, fbi);
   }
   
   // prints a formatted version of the locations longitude and latitude
   //
   // @param name    The name of the location
   // @param place   The specific Geolocation object to be used
   public static void location (String name, GeoLocation place) {
      System.out.print(name + " is at ");
      System.out.println(place.toString());
   }
   
   // prints the distance from the stash location from both other locations
   //
   // @param stash      Geolocation object relevant to the stash object and location
   // @param abq        Geolocation object relevant to the abq object and location 
   // @param fbi        Geolocation object relevant to the fbi object and location
   public static void distances (GeoLocation stash, GeoLocation abq, GeoLocation fbi) {
      System.out.println("distance in miles between:");
      System.out.println("    stash/studio = " + stash.distanceFrom(abq));
      System.out.println("    stash/fbi    = " + stash.distanceFrom(fbi));
   }
}