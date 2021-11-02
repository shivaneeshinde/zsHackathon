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
@Table(name="Discussions_comments")
public class Discussions_Comments {

	@Id
	@Column(name = "discussions_comments_id")
	private int discussions_comments_id;

	//@Column(name = "discussions_id")
	//private int discussions_id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discussions_id", referencedColumnName = "discussions_id")
	private Discussions discussions;

	@Column(name = "comment")
	private String comment;

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

	public Discussions_Comments() {
		// TODO Auto-generated constructor stub
	}

	public Discussions_Comments(int discussions_comments_id, Discussions discussions, String comment, int upvotes,
			int downvotes, Date creation_date, Date last_update_date) {
		super();
		this.discussions_comments_id = discussions_comments_id;
		this.discussions = discussions;
		this.comment = comment;
		this.upvotes = upvotes;
		this.downvotes = downvotes;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getDiscussions_comments_id() {
		return discussions_comments_id;
	}

	public void setDiscussions_comments_id(int discussions_comments_id) {
		this.discussions_comments_id = discussions_comments_id;
	}

	public Discussions getDiscussions() {
		return discussions;
	}

	public void setDiscussions(Discussions discussions) {
		this.discussions = discussions;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "Discussions_Comments [discussions_comments_id=" + discussions_comments_id + ", discussions="
				+ discussions + ", comment=" + comment + ", upvotes=" + upvotes + ", downvotes=" + downvotes
				+ ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + "]";
	}
	
	

	/*
	public Discussions_Comments(int discussions_comments_id, int discussions_id, String comment, int upvotes,
			int downvotes, Date creation_date, Date last_update_date) {
		super();
		this.discussions_comments_id = discussions_comments_id;
		this.discussions_id = discussions_id;
		this.comment = comment;
		this.upvotes = upvotes;
		this.downvotes = downvotes;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getDiscussions_comments_id() {
		return discussions_comments_id;
	}

	public void setDiscussions_comments_id(int discussions_comments_id) {
		this.discussions_comments_id = discussions_comments_id;
	}

	public int getDiscussions_id() {
		return discussions_id;
	}

	public void setDiscussions_id(int discussions_id) {
		this.discussions_id = discussions_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "Discussions_Comments [discussions_comments_id=" + discussions_comments_id + ", discussions_id="
				+ discussions_id + ", comment=" + comment + ", upvotes=" + upvotes + ", downvotes=" + downvotes
				+ ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + "]";
	}
	*/
	
	
}
