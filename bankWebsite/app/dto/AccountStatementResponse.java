package dto;

import org.joda.time.DateTime;

import java.util.Date;

public class AccountStatementResponse {
	
	private Integer transId;
	private Integer merchant;
	private String date;
	private Integer amount;
	private String transactionType;
	private String statusName;
	private Integer statusCode;
	
	public Integer getTransId() {
		return transId;
	}
	
	public void setTransId(Integer transId) {
		this.transId = transId;
	}
	
	public Integer getMerchant() {
		return merchant;
	}
	
	public void setMerchant(Integer merchant) {
		this.merchant = merchant;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
