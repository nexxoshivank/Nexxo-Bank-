package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "statuses")
public class Statuses {
	
	@Id
	@Column(name = "status_id")
	private Integer statusId;
	
	@Column(name = "status_name")
	private String statusName;
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public enum statusEnum {
		ACTIVE(1), INACTIVE(2);
		private int id;
		
		public int getId() {
			return this.id;
		}
		
		statusEnum(Integer id) {
			this.id = id;
		}
	}
	
	public static Statuses getInstanceof(Integer id) {
		
		Statuses statuses = new Statuses();
		statuses.setStatusId(id);
		return statuses;
	}
	
	public Integer getStatusId() {
		return statusId;
	}
	
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	public static final Finder<Integer, Statuses> find = new Finder<>(Statuses.class);
}
