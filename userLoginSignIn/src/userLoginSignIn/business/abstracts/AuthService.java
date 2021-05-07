package userLoginSignIn.business.abstracts;

public interface AuthService {
	void signIn(String email);
	void login(String email,String password);
	
}
