package services;

import dto.FeedbackReviewResponse;
import models.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackReviewService {
	
	public static List<FeedbackReviewResponse> renderFeedback() {
		
		List<FeedbackReviewResponse> feedbackReviewResponseList = new ArrayList<FeedbackReviewResponse>();
		List<Feedback> feedbackList = Feedback.find.query().findList();
		for (Feedback feedback : feedbackList) {
			FeedbackReviewResponse feedbackReviewResponse = new FeedbackReviewResponse();
			feedbackReviewResponse.setFeedback(feedback.getFeedback());
			feedbackReviewResponse.setFeedbackCreatedOn(feedback.getFeedbackCreatedOn().toString());
			feedbackReviewResponse.setUserId(feedback.getUserId());
			feedbackReviewResponse.setStatusCode(200);
			feedbackReviewResponse.setStatusName("Feedback Shown");
			feedbackReviewResponseList.add(feedbackReviewResponse);
		}
		return feedbackReviewResponseList;
	}
}
