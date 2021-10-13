package models;

import io.ebean.Finder;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserDetails {
	
	@Column(name = "date_of_birth")
	private Date dob;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "aadhaar_number")
	private String aadhaarNumber;
	
	@Column(name = "pan_no")
	private String panNumber;
	
	@Column(name = "created_on")
	private DateTime createdOn;
	
	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "status_id")
	private Statuses statusId;
	
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Roles roleId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Id
	@Column(name = "user_id")
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public Roles getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}
	
	public Statuses getStatusId() {
		return statusId;
	}
	
	public void setStatusId(Statuses statusId) {
		this.statusId = statusId;
	}
	
	public DateTime getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public String getPanNumber() {
		return panNumber;
	}
	
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public static final Finder<Integer, UserDetails> find = new Finder<>(UserDetails.class);
	
}
