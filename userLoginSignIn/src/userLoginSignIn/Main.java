package userLoginSignIn;

import userLoginSignIn.business.concretes.AuthManager;
import userLoginSignIn.business.concretes.UserManager;
import userLoginSignIn.core.GoogleAuthManagerAdapter;
import userLoginSignIn.dataAccess.abstracts.UserDao;
import userLoginSignIn.dataAccess.concretes.InMemoryUserDao;
import userLoginSignIn.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserDao inMemoryUserDao = new InMemoryUserDao();		
		
		User user1=new User(1,"Merve","Daðlý","m@m","111111");
		User user2=new User(1,"Merve","Daðlý","m@gmail.com","111112");
		User user3=new User(1,"Merve","Daðlý","m@gmail.com","111112");
		
		UserManager userManager = new UserManager(inMemoryUserDao);
		userManager.add(user1);
		userManager.add(user2);
		userManager.add(user3);
		for (User tempUser : userManager.getAll()) {
			System.out.println(tempUser.getFirstName()+" "+tempUser.getLastName());
		}
		AuthManager google=new AuthManager(inMemoryUserDao,new GoogleAuthManagerAdapter());
		AuthManager standart=new AuthManager(inMemoryUserDao,new GoogleAuthManagerAdapter());
		System.out.println(" ");
		standart.login("m@m", "111111");
		google.login("m@gmail.com", "1111112");
		
		

	}

}
