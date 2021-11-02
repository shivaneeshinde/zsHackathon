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
@Table(name="Team_Members")
public class Team_Members {

	@Id
	@Column(name = "team_members_id")
	private int team_members_id;

	/*@Column(name = "team_id")
	private int team_id;

	@Column(name = "owner_id")
	private int owner_id;*/
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "teams_id")
    private Teams teams;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users users;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_id")
	private Users users1;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date creation_date;
	
	@Column(name = "last_update_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date last_update_date;

	public Team_Members() {
		// TODO Auto-generated constructor stub
	}

	public Team_Members(int team_members_id, Teams teams, Users users, Users users1, Date creation_date,
			Date last_update_date) {
		super();
		this.team_members_id = team_members_id;
		this.teams = teams;
		this.users = users;
		this.users1 = users1;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getTeam_members_id() {
		return team_members_id;
	}

	public void setTeam_members_id(int team_members_id) {
		this.team_members_id = team_members_id;
	}

	public Teams getTeams() {
		return teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Users getUsers1() {
		return users1;
	}

	public void setUsers1(Users users1) {
		this.users1 = users1;
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
		return "Team_Members [team_members_id=" + team_members_id + ", teams=" + teams + ", users=" + users
				+ ", users1=" + users1 + ", creation_date=" + creation_date + ", last_update_date=" + last_update_date
				+ "]";
	}
	
	

	/*public Team_Members(int team_members_id, int team_id, int owner_id, Date creation_date, Date last_update_date) {
		super();
		this.team_members_id = team_members_id;
		this.team_id = team_id;
		this.owner_id = owner_id;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public int getTeam_members_id() {
		return team_members_id;
	}

	public void setTeam_members_id(int team_members_id) {
		this.team_members_id = team_members_id;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
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
		return "Team_Members [team_members_id=" + team_members_id + ", team_id=" + team_id + ", owner_id=" + owner_id
				+ ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + "]";
	}*/
	

}
