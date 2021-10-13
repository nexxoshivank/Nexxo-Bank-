package services;

import dao.TransactionHistoryDao;
import dto.SendMoneyRequest;
import dto.SendMoneyResponse;
import models.TransactionHistory;
import models.TransactionType;
import models.UserDetails;
import org.joda.time.DateTime;

import java.util.regex.Pattern;

public class SendMoneyService {
	
	public static SendMoneyResponse saveSendingMoneyDetails(SendMoneyRequest sendMoneyRequest) {
		
		SendMoneyResponse sendMoneyResponse = new SendMoneyResponse();
		
		try {
			boolean b = Pattern.matches("[0-9]{8}", sendMoneyRequest.getMerchantAccountNumber());
			boolean b1 = Pattern.matches("[A-Z]{3}[0-9]{3}[A-Z]{3}", sendMoneyRequest.getIfsc());
			boolean b2 = Pattern.matches("[0-9]*", sendMoneyRequest.getAmount().toString());
			
			if (b==false){
				sendMoneyResponse.setStatusName("Merchant account Number pattern Does not matches");
				return sendMoneyResponse;
			}
			if (b1==false){
				sendMoneyResponse.setStatusName("IFSC pattern does not matches");
				return sendMoneyResponse;
			}
			if (b2==false){
				sendMoneyResponse.setStatusName("Please enter valid amount");
				return sendMoneyResponse;
			}
				UserDetails userDetails = UserDetails.find.byId(sendMoneyRequest.getUserId());
				TransactionHistory transactionHistory = new TransactionHistory();
				transactionHistory.setUserId(userDetails);
				transactionHistory.setAmount(sendMoneyRequest.getAmount());
				transactionHistory.setIfsc(sendMoneyRequest.getIfsc());
				transactionHistory.setDateTime(new DateTime());
				transactionHistory.setMerchant(Integer.valueOf(sendMoneyRequest.getMerchantAccountNumber()));
				transactionHistory.setTransactionType(TransactionType.getInstance(TransactionType.transactionTypeEnum.DEBIT.gettID()));
				
				TransactionHistoryDao.saveSendMoneyDetails(transactionHistory);
				
				sendMoneyResponse.setStatusCode(200);
				sendMoneyResponse.setStatusName("Money Sent Successfully");
				
			
		} catch (Exception exception) {
			
			sendMoneyResponse.setStatusCode(500);
			sendMoneyResponse.setStatusName("There is some error sending money" + exception);
			return sendMoneyResponse;
		}
		
		return sendMoneyResponse;
	}
	
}
