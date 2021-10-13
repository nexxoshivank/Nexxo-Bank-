package models;


import io.ebean.Finder;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity(name = "feedback")
public class Feedback {
	
	@Id
	@Column(name = "feedback_id")
	private Integer feedbackId;
	
	@Column(name = "feedback")
	private String feedback;
	
	@Column(name = "created_on")
	private DateTime feedbackCreatedOn;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Integer userId;
	
	public Integer getFeedbackId() {
		return feedbackId;
	}
	
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
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
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public static final Finder<Integer, Feedback> find = new Finder<>(Feedback.class);
}
