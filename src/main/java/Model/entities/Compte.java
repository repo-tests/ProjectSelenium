package Model.entities;

public class Compte {
	private int id;
	private String login;
	private String password;
	
	public Compte( String login, String password) {
		super();
		
		this.login = login;
		this.password = password;
		
	}
	public Compte() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
