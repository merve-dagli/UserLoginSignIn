package userLoginSignIn.core;

import userLoginSignIn.jGoogleService.GoogleServiceManager;

public class GoogleAuthManagerAdapter implements AuthServiceAdapter{

	@Override
	public void signIn(String email) {
		GoogleServiceManager googleServiceManager =new GoogleServiceManager();
		if(googleServiceManager.GoogleService(email)) {
			System.out.println("Google hesab� ile giri� yap�ld�");
			
		}
		else {
			System.out.println("��lem ba�ar�s�z");
		}
		
	}

}
