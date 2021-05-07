package userLoginSignIn.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import userLoginSignIn.dataAccess.abstracts.UserDao;
import userLoginSignIn.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	private List<User> users=new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý eklendi "+user.getFirstName()+" "+user.getLastName());
		this.users.add(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý güncellendi "+user.getFirstName());
		int index=users.indexOf(user);
		this.users.remove(index);
		this.users.add(user);
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý silindi "+user.getFirstName());
		int index=users.indexOf(user);
		this.users.remove(index);
		
	}

	@Override
	public User get(int id) {
		for(User user:this.users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}

	@Override
	public User getEmail(String email) {
		for(User user:this.users) {
			if(user.getEmail()==email)
				return user;
		}
		return null;
	}

}
