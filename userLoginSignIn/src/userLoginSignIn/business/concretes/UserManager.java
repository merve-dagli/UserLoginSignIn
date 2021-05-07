package userLoginSignIn.business.concretes;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import userLoginSignIn.business.abstracts.UserService;
import userLoginSignIn.dataAccess.abstracts.UserDao;
import userLoginSignIn.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		if(validUser(user)) {
			if(confirmation()) {
				userDao.add(user);
			}
			else {
				System.out.println("Onaylama iþlemi baþarýsýz");
			}
		}
		
	}

	

	

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User get(int id) {
		userDao.get(id);
		return null;
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
	private boolean validUser(User user) {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(user.getEmail());
		boolean valid =true;
		
		if(!match.matches()) {
			System.out.println("Geçersiz email");
			valid= false;
			
		}
		if(userDao.getAll()!=null) {
			for (User tempUser : userDao.getAll()) {
				if(tempUser.getEmail()==user.getEmail()) {
					System.out.println("Kullanýlan email.");
					valid= false;
				}
			}
		}
		if(user.getFirstName().length()<2) {
			System.out.println("Geçersiz karakter sayýsý");
			valid= false;
		}
		if(user.getLastName().length()<2) {
			System.out.println("Geçersiz karakter sayýsý.");
			valid= false;
		}
		if(user.getPassword().length()<6) {
			System.out.println("Geçersiz karakter sayýsý");
			valid= false;
		}

		
		return valid;
	}
	
	
	private boolean confirmation() {
		boolean result = false;
		 
		String text;
		System.out.println("Mail adresinizi onaylayýnýz onaylama için ONAY yazýnýz:");
		Scanner scanInput = new Scanner(System.in);
		text= scanInput.nextLine().toUpperCase();
		scanInput.close();           
		   
		if(text.equals("ONAY")) {
			result = true;
		}
		
		return result;
	}

}
