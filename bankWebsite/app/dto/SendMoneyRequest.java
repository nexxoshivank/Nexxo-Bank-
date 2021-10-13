package dto;


import java.util.Date;

public class SendMoneyRequest {
	
	private Integer userId;
	private String merchantAccountNumber;
	private String ifsc;
	private Integer amount;
	private Integer transactionType;
	private Date transactionTime;
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getMerchantAccountNumber() {
		return merchantAccountNumber;
	}
	
	public void setMerchantAccountNumber(String merchantAccountNumber) {
		this.merchantAccountNumber = merchantAccountNumber;
	}
	
	public String getIfsc() {
		return ifsc;
	}
	
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}
	
	public Date getTransactionTime() {
		return transactionTime;
	}
	
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
}
