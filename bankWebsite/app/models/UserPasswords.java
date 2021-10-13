package models;

import io.ebean.Finder;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity(name = "user_passwords")

public class UserPasswords {
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "user_id")
	private UserDetails userId;
	
	@Column(name = "pass")
	private String pass;
	
	@Column(name = "created_on")
	private DateTime dateTime;
	
	
	public UserDetails getUserId() {
		return userId;
	}
	
	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public DateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public static final Finder<Integer, UserPasswords> find = new Finder<>(UserPasswords.class);
}
