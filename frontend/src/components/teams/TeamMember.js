import React from "react";
import axios from "axios";

class TeamMember extends React.Component {
  state = {
    teamMembers: [],
    addMember: false,
    addMemberId: null,
    addMemberName: null,
    users: [],
  };

  async componentDidMount() {
    const membersResponse = await axios.get(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/teamMembers"
    );
    this.setState({
      teamMembers: membersResponse.data.filter(
        (member) => member.teamId === this.props.teamId
      ),
    });

    const usersResponse = await axios.get(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/users"
    );
    this.setState({ users: usersResponse.data });
  }

  onDeleteMember = async (memberId) => {
    const deleteResponse = await axios.delete(
      `https://608d1c869f42b20017c3e804.mockapi.io/api/teamMembers/${memberId}`
    );
    if (deleteResponse.status === 200) {
      const memberResponse = await axios.get(
        "https://608d1c869f42b20017c3e804.mockapi.io/api/teamMembers"
      );
      this.setState({
        teamMembers: memberResponse.data.filter(
          (member) => member.teamId === this.props.teamId
        ),
      });
    }
  };

  onFormSubmit = async (e) => {
    e.preventDefault();
    const response = await axios.post(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/teamMembers",
      {
        teamId: this.props.teamId,
        userId: this.state.addMemberId,
        userName: this.state.addMemberName,
      }
    );
    if (response.status === 201) {
      this.setState({
        addMember: false,
        addMemberId: null,
        addMemberName: null,
      });
      const members = await axios.get(
        "https://608d1c869f42b20017c3e804.mockapi.io/api/teamMembers"
      );
      this.setState({
        teamMembers: members.data.filter(
          (member) => member.teamId === this.props.teamId
        ),
      });
    }
  };

  render() {
    const membersData = this.state.teamMembers.map((member) => {
      return (
        <div className="ui segment">
          <div className="content" key={member.userId}>
            {member.userName}
            <i
              className="delete icon"
              style={{
                float: "right",
                width: "20px",
                height: "20px",
                cursor: "pointer",
              }}
              value={member.id}
              onClick={() => this.onDeleteMember(member.id)}
            />
          </div>
        </div>
      );
    });

    const usersData = this.state.users.map((user) => {
      return (
        <option key={user.id} value={user.id}>
          {user.name}
        </option>
      );
    });

    return (
      <div className="ui segment">
        {this.state.addMember ? (
          <form className="input-group">
            <select
              className="form-control"
              name="addMemberId"
              style={{ width: "120px", marginRight: "10px" }}
              onChange={(e) => {
                let index = e.nativeEvent.target.selectedIndex;
                let label = e.nativeEvent.target[index].text;
                this.setState({
                  addMemberId: e.target.value,
                  addMemberName: label,
                });
              }}
            >
              <option value="0">--</option>
              {usersData}
            </select>
            <span className="input-group-btn">
              <button
                className="ui icon green button"
                onClick={(e) => {
                  this.onFormSubmit(e);
                }}
              >
                <i className="check icon"></i>
              </button>
            </span>
          </form>
        ) : (
          <button
            className="ui blue button"
            onClick={() => {
              this.setState({ addMember: true });
            }}
          >
            <i className="user plus icon" />
            Add User
          </button>
        )}
        <div style={{ marginTop: "10px" }}>{membersData}</div>
      </div>
    );
  }
}

export default TeamMember;
