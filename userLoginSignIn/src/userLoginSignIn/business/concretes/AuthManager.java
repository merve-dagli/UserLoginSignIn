package userLoginSignIn.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import userLoginSignIn.business.abstracts.AuthService;
import userLoginSignIn.core.AuthServiceAdapter;
import userLoginSignIn.dataAccess.abstracts.UserDao;
import userLoginSignIn.entities.concretes.User;

public class AuthManager implements AuthService {
	private UserDao userDao;
	private AuthServiceAdapter authServiceAdapter ;
	

	public AuthManager(UserDao userDao, AuthServiceAdapter authServiceAdapter) {
		super();
		this.userDao = userDao;
		this.authServiceAdapter = authServiceAdapter;
	}

	@Override
	public void signIn(String email) {
		String regex="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(email);
		if(match.matches()) {
			this.authServiceAdapter.signIn(email);
		}
		else {
			System.out.println("Eksik veya yanlýþ giriþ yaptýnýz");
		}
		
	}

	@Override
	public void login(String email, String password) {
		User tempUser=userDao.getEmail(email);
		if(tempUser!=null) {
			System.out.println(tempUser.getFirstName()+" ");
			if(tempUser.getPassword()==password) {
				System.out.println("Giriþ baþarýlý");
			}
			else {
				System.out.println("Giriþ baþarýsýz");
			}
			
		}else {
			System.out.println("Kullanýcý bulunamadý");
		}
		
	}

}
