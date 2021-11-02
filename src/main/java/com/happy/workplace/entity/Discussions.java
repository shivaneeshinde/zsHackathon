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
@Table(name="Discussions")
public class Discussions {

	@Id
	@Column(name = "discussions_id")
	private int discussions_id;

	//@Column(name = "activity_id")
	//private int activity_id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_id", referencedColumnName = "activities_scheduled_id")
	private Activities_Scheduled activity;

	@Column(name = "feedback")
	private String feedback;

	@Column(name = "upvotes")
	private int upvotes;

	@Column(name = "downvotes")
	private int downvotes;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date creation_date;
	
	@Column(name = "last_update_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date last_update_date;

	public Discussions() {
		// TODO Auto-generated constructor stub
	}

	public Discussions(int discussions_id, Activities_Scheduled activity, String feedback, int upvotes, int downvotes,
			Date creation_date, Date last_update_date) {
		super();
		this.discussions_id = discussions_id;
		this.activity = activity;
		this.feedback = feedback;
		this.upvotes = upvotes;
		this.downvotes = downvotes;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getDiscussions_id() {
		return discussions_id;
	}

	public void setDiscussions_id(int discussions_id) {
		this.discussions_id = discussions_id;
	}

	public Activities_Scheduled getActivity() {
		return activity;
	}

	public void setActivity(Activities_Scheduled activity) {
		this.activity = activity;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public int getDownvotes() {
		return downvotes;
	}

	public void setDownvotes(int downvotes) {
		this.downvotes = downvotes;
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
		return "Discussions [discussions_id=" + discussions_id + ", activity=" + activity + ", feedback=" + feedback
				+ ", upvotes=" + upvotes + ", downvotes=" + downvotes + ", creation_date=" + creation_date
				+ ", last_update_date=" + last_update_date + "]";
	}
	
	

	/*
	public Discussions(int discussions_id, int activity_id, String feedback, int upvotes, int downvotes,
			Date creation_date, Date last_update_date) {
		super();
		this.discussions_id = discussions_id;
		this.activity_id = activity_id;
		this.feedback = feedback;
		this.upvotes = upvotes;
		this.downvotes = downvotes;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getDiscussions_id() {
		return discussions_id;
	}

	public void setDiscussions_id(int discussions_id) {
		this.discussions_id = discussions_id;
	}

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public int getDownvotes() {
		return downvotes;
	}

	public void setDownvotes(int downvotes) {
		this.downvotes = downvotes;
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
		return "Discussions [discussions_id=" + discussions_id + ", activity_id=" + activity_id + ", feedback="
				+ feedback + ", upvotes=" + upvotes + ", downvotes=" + downvotes + ", creation_date=" + creation_date
				+ ", last_update_date=" + last_update_date + "]";
	}
	*/
	

}
