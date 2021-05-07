package userLoginSignIn.core;

import userLoginSignIn.jGoogleService.GoogleServiceManager;

public class GoogleAuthManagerAdapter implements AuthServiceAdapter{

	@Override
	public void signIn(String email) {
		GoogleServiceManager googleServiceManager =new GoogleServiceManager();
		if(googleServiceManager.GoogleService(email)) {
			System.out.println("Google hesabý ile giriþ yapýldý");
			
		}
		else {
			System.out.println("Ýþlem baþarýsýz");
		}
		
	}

}
