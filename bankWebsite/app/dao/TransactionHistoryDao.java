package dao;

import models.TransactionHistory;

public class TransactionHistoryDao {
	
	public static void saveSendMoneyDetails(TransactionHistory transactionHistory) {
		DbConnector.save(transactionHistory);
	}
}
