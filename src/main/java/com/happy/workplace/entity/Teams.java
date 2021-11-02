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
@Table(name="Teams")
public class Teams {

	@Id
	@Column(name = "teams_id")
	private int teams_id;

	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private Users users;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date creation_date;
	
	@Column(name = "last_update_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date last_update_date;

	public Teams() {
		// TODO Auto-generated constructor stub
	}

	public Teams(int teams_id, String name, Users users, Date creation_date, Date last_update_date) {
		this.teams_id = teams_id;
		this.name = name;
		this.users = users;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getTeams_id() {
		return teams_id;
	}

	public void setTeams_id(int teams_id) {
		this.teams_id = teams_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Teams [teams_id=" + teams_id + ", name=" + name + ", users=" + users + ", creation_date="
				+ creation_date + ", last_update_date=" + last_update_date + "]";
	}
	
}
