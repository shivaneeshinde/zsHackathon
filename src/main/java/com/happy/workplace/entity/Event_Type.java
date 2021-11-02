package com.happy.workplace.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Event_type")
public class Event_Type {

	@Id
	@Column(name = "event_type_id")
	private int event_type_id;

	@Column(name = "event_name")
	private String event_name;

	//@Column(name = "last_updated_by")
	//private int last_updated_by;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_id")
	private Users users;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date creation_date;
	
	@Column(name = "last_update_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date last_update_date;

	public Event_Type() {
		// TODO Auto-generated constructor stub
	}

	public Event_Type(int event_type_id, String event_name, Users users, Date creation_date, Date last_update_date) {
		super();
		this.event_type_id = event_type_id;
		this.event_name = event_name;
		this.users = users;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getEvent_type_id() {
		return event_type_id;
	}

	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	@Override
	public String toString() {
		return "Event_Type [event_type_id=" + event_type_id + ", event_name=" + event_name + ", users=" + users
				+ ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + "]";
	}
	
	

	/*public Event_Type(int event_type_id, String event_name, int last_updated_by, Date creation_date,
			Date last_update_date) {
		super();
		this.event_type_id = event_type_id;
		this.event_name = event_name;
		this.last_updated_by = last_updated_by;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getEvent_type_id() {
		return event_type_id;
	}

	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	@Override
	public String toString() {
		return "Event_Type [event_type_id=" + event_type_id + ", event_name=" + event_name + ", last_updated_by="
				+ last_updated_by + ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + "]";
	}
	*/

}
