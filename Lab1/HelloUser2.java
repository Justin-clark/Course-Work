//-----------------------------------------------------------------------------
// Justin Clark 
// judclark
// HelloUser2.java
// Prints "Hello <USER NAME>"
//-----------------------------------------------------------------------------
class HelloUser2{
   public static void main( String[] args ){
      String userName = System.getProperty("user.name");
     
      System.out.println("Hello "+userName);
   }
}
