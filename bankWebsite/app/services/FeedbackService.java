package services;

import dao.FeedbackDao;
import dto.FeedbackRequest;
import dto.FeedbackResponse;
import models.Feedback;
import org.joda.time.DateTime;

public class FeedbackService {
	
	public static FeedbackResponse customerFeedback(FeedbackRequest feedbackRequest) {
		
		FeedbackResponse feedbackResponse = new FeedbackResponse();
		try {
			
			Feedback feedback = new Feedback();
			
			feedback.setUserId(feedbackRequest.getUserId());
			feedback.setFeedback(feedbackRequest.getFeedback());
			feedback.setFeedbackCreatedOn(new DateTime());
			FeedbackDao.saveFeedback(feedback);
			feedbackResponse.setStatusCode(200);
			feedbackResponse.setStatusName("feedback is saved, will look after it. Thank you");
		} catch (Exception exception) {
			
			feedbackResponse.setStatusCode(500);
			feedbackResponse.setStatusName("internal server error" + exception);
			return feedbackResponse;
		}
		return feedbackResponse;
	}
}
