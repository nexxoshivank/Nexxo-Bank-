package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "transaction_type")
public class TransactionType {
	
	@Column(name = "trans_type")
	private String transType;
	
	@Id
	@Column(name = "trans_id")
	private Integer transId;
	
	public String getTransType() {
		return transType;
	}
	
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	public Integer getTransId() {
		return transId;
	}
	
	public void setTransId(Integer transId) {
		this.transId = transId;
	}
	
	public enum transactionTypeEnum {
		
		DEBIT(2), CREDIT(1);
		private Integer tID;
		
		public Integer gettID() {
			return this.tID;
		}
		
		transactionTypeEnum(Integer tID) {
			this.tID = tID;
		}
	}
	
	public static TransactionType getInstance(Integer tID) {
		TransactionType transactionType = new TransactionType();
		transactionType.setTransId(tID);
		return transactionType;
	}
	
	public static final Finder<Integer, TransactionType> find = new Finder<>(TransactionType.class);
}
