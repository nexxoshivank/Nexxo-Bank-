package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "roles")
public class Roles {
	
	@Id
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "role_status")
	private String roleStatus;
	
	public String getRoleStatus() {
		return roleStatus;
	}
	
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public enum roleTypeEnum {
		CUSTOMER(2), ADMIN(1);
		private Integer roleId;
		
		public Integer getRoleId() {
			return roleId;
		}
		
		roleTypeEnum(Integer id) {
			this.roleId = id;
		}
		
	}
	
	public static Roles getInstance(Integer id) {
		Roles roles = new Roles();
		roles.setRoleId(id);
		return roles;
	}
	
	public static final Finder<Integer, Roles> find = new Finder<>(Roles.class);
}
