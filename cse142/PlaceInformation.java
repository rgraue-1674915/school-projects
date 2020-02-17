// Ryan Graue
// 11/27/18
// CSE 142
// TA: Ivy Yu
// assignment #8 part C
// 
// this class store information about a place on earth. With it being filled
// with its name, address, relevant tags, and latitue and longitude.
public class PlaceInformation {

      private String name;
      private String address;
      private String tag;
      private double latitude;
      private double longitude;
   // constructs a place information object with a given 
   // name, address, tags, latitude, and longitude
   public PlaceInformation (String name, String address, String tag,
                            double latitude, double longitude) {
      this.name = name;
      this.address = address;
      this.tag = tag;
      this.latitude = latitude;
      this.longitude = longitude;   
   }
   
   // returns the name of the place information object
   public String getName () {
      return name;
   }
   
   // returns the address of the place information object
   public String getAddress () {
      return address;
   }
   
   // returns the tags of the place information object
   public String getTag () {
      return tag;
   }  
   
   // retuns the formatted string of the place information objects's latitude and longitude
   public String toString () {
      return getName() + " (" + getLocation().toString() + ")";
   }
   
   // returns a geolocation object for the place information object given
   // its latitude and longitude
   public GeoLocation getLocation () {
      GeoLocation location = new GeoLocation(latitude, longitude);
      return location;
   }
   
   // returns the distcance the place information object is
   // from a GeoLocation object
   //
   // @param spot    Geolocation object that the distance is being measured to.
   public double distanceFrom (GeoLocation spot) {
      return getLocation().distanceFrom(spot);
   }
}