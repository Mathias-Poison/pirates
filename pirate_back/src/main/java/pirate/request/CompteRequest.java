package pirate.request;

import jakarta.validation.constraints.NotBlank;

public class CompteRequest {

	@NotBlank
	protected int age;
	@NotBlank
	protected String login;
	@NotBlank
	protected String password;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
