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
@Table(name="Activities_Scheduled")
public class Activities_Scheduled {

	@Id
	@Column(name = "activities_scheduled_id")
	private int activities_scheduled_id;

	//@Column(name = "teams_id")
	//private int teams_id;

	@Column(name = "event_start_time")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date event_start_time;
	
	@Column(name = "event_end_time")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date event_end_time;

	//@Column(name = "event_type")
	//private int event_type;

	@Column(name = "meeting_link")
	private String meeting_link;

	//@Column(name = "last_updated_by")
	//private int last_updated_by;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teams_id", referencedColumnName = "teams_id")
	private Teams teams;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_type", referencedColumnName = "event_type_id")
	private Event_Type event;

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

	public Activities_Scheduled() {
		// TODO Auto-generated constructor stub
	}

	public Activities_Scheduled(int activities_scheduled_id, Date event_start_time, Date event_end_time,
			String meeting_link, Teams teams, Event_Type event, Users users, Date creation_date,
			Date last_update_date) {
		super();
		this.activities_scheduled_id = activities_scheduled_id;
		this.event_start_time = event_start_time;
		this.event_end_time = event_end_time;
		this.meeting_link = meeting_link;
		this.teams = teams;
		this.event = event;
		this.users = users;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getActivities_scheduled_id() {
		return activities_scheduled_id;
	}

	public void setActivities_scheduled_id(int activities_scheduled_id) {
		this.activities_scheduled_id = activities_scheduled_id;
	}

	public Date getEvent_start_time() {
		return event_start_time;
	}

	public void setEvent_start_time(Date event_start_time) {
		this.event_start_time = event_start_time;
	}

	public Date getEvent_end_time() {
		return event_end_time;
	}

	public void setEvent_end_time(Date event_end_time) {
		this.event_end_time = event_end_time;
	}

	public String getMeeting_link() {
		return meeting_link;
	}

	public void setMeeting_link(String meeting_link) {
		this.meeting_link = meeting_link;
	}

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	public Event_Type getEvent() {
		return event;
	}

	public void setEvent(Event_Type event) {
		this.event = event;
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
		return "Activities_Scheduled [activities_scheduled_id=" + activities_scheduled_id + ", event_start_time="
				+ event_start_time + ", event_end_time=" + event_end_time + ", meeting_link=" + meeting_link
				+ ", teams=" + teams + ", event=" + event + ", users=" + users + ", creation_date=" + creation_date
				+ ", last_update_date=" + last_update_date + "]";
	}
	
	

	/*
	public Activities_Scheduled(int activities_scheduled_id, int teams_id, Date event_start_time, Date event_end_time,
			int event_type, String meeting_link, int last_updated_by, Date creation_date, Date last_update_date) {
		super();
		this.activities_scheduled_id = activities_scheduled_id;
		this.teams_id = teams_id;
		this.event_start_time = event_start_time;
		this.event_end_time = event_end_time;
		this.event_type = event_type;
		this.meeting_link = meeting_link;
		this.last_updated_by = last_updated_by;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getActivities_scheduled_id() {
		return activities_scheduled_id;
	}

	public void setActivities_scheduled_id(int activities_scheduled_id) {
		this.activities_scheduled_id = activities_scheduled_id;
	}

	public int getTeams_id() {
		return teams_id;
	}

	public void setTeams_id(int teams_id) {
		this.teams_id = teams_id;
	}

	public Date getEvent_start_time() {
		return event_start_time;
	}

	public void setEvent_start_time(Date event_start_time) {
		this.event_start_time = event_start_time;
	}

	public Date getEvent_end_time() {
		return event_end_time;
	}

	public void setEvent_end_time(Date event_end_time) {
		this.event_end_time = event_end_time;
	}

	public int getEvent_type() {
		return event_type;
	}

	public void setEvent_type(int event_type) {
		this.event_type = event_type;
	}

	public String getMeeting_link() {
		return meeting_link;
	}

	public void setMeeting_link(String meeting_link) {
		this.meeting_link = meeting_link;
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
		return "Activities_Scheduled [activities_scheduled_id=" + activities_scheduled_id + ", teams_id=" + teams_id
				+ ", event_start_time=" + event_start_time + ", event_end_time=" + event_end_time + ", event_type="
				+ event_type + ", meeting_link=" + meeting_link + ", last_updated_by=" + last_updated_by
				+ ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + "]";
	}
	*/
	
	
}
