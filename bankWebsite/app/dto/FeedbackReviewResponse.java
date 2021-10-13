package dto;

import org.joda.time.DateTime;

public class FeedbackReviewResponse {
	
	private Integer userId;
	private String feedback;
	private String feedbackCreatedOn;
	private Integer statusCode;
	private String statusName;
	
	public Integer getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
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
	
	public String getFeedbackCreatedOn() {
		return feedbackCreatedOn;
	}
	
	public void setFeedbackCreatedOn(String feedbackCreatedOn) {
		this.feedbackCreatedOn = feedbackCreatedOn;
	}
}
