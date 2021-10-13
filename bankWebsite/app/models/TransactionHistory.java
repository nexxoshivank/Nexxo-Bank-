package models;

import io.ebean.Finder;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity(name = "transaction_history")
public class TransactionHistory {
	
	@ManyToOne
	@JoinColumn(name = "user_id_transaction_table", referencedColumnName = "user_id")
	private UserDetails userId;
	
	@Id
	@Column(name = "transaction_id")
	private Integer transactionId;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "date_time")
	private DateTime dateTime;
	
	@Column(name = "ifsc")
	private String ifsc;
	
	@Column(name = "merchant_account_number")
	private Integer merchant;
	
	@ManyToOne
	@JoinColumn(name = "t_id", referencedColumnName = "trans_id")
	private TransactionType transactionType;
	
	public Integer getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public UserDetails getUserId() {
		return userId;
	}
	
	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}
	
	public String getIfsc() {
		return ifsc;
	}
	
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	public DateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public Integer getMerchant() {
		return merchant;
	}
	
	public void setMerchant(Integer merchant) {
		this.merchant = merchant;
	}
	
	public static final Finder<Integer, TransactionHistory> find = new Finder<>(TransactionHistory.class);
}
