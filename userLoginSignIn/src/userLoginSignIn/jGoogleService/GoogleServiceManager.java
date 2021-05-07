package userLoginSignIn.jGoogleService;

public class GoogleServiceManager {
  public boolean GoogleService(String mail) {
	  boolean auth=false;
	  String[] parts=mail.split("@");
	  String domain=parts[1];
	  
	  if(domain.equals("gmail.com")) {
		  auth=true;
	  }
	  return auth;
	  
  }
}
