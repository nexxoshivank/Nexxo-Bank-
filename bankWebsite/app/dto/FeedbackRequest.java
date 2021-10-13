package dto;

import org.joda.time.DateTime;

public class FeedbackRequest {
	private Integer userId;
	private String feedback;
	private DateTime feedbackCreatedOn;
	
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public DateTime getFeedbackCreatedOn() {
		return feedbackCreatedOn;
	}
	
	public void setFeedbackCreatedOn(DateTime feedbackCreatedOn) {
		this.feedbackCreatedOn = feedbackCreatedOn;
	}
}
