package dao;

import models.Feedback;

public class FeedbackDao {
	
	public static void saveFeedback(Feedback feedback) {
		DbConnector.save(feedback);
	}
	
}
