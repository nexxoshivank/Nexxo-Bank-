package dto;

public class ViewListResponse {
	
	private Integer userId;
	private String customerName;
	private String customerLastName;
	private String mobile;
	private String email;
	private String dob;
	private String aadhaarNumber;
	private String panNumber;
	private String accountStatus;
	private Integer statusCode;
	private String statusName;
	
	public String getCustomerLastName() {
		return customerLastName;
	}
	
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	
	public String getPanNumber() {
		return panNumber;
	}
	
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
	
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
