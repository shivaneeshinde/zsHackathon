import React from "react";
import axios from "axios";
import { toast } from "react-toastify";
import TeamMember from "./TeamMember";

class Team extends React.Component {
  state = {
    name: "",
    description: "",
    owner: 0,
    users: [],
  };

  async componentDidMount() {
    if (this.props.editTeam) {
      const response = await axios.get(
        `https://608d1c869f42b20017c3e804.mockapi.io/api/teams/${this.props.editTeam}`
      );
      this.setState({
        name: response.data.name,
        description: response.data.description,
        owner: response.data.owner,
      });
    }
    const response = await axios.get(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/users"
    );
    this.setState({ users: response.data });
  }

  onFormChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  onFormSubmit = async (e) => {
    e.preventDefault();
    if (this.props.editTeam) {
      const response = await axios.put(
        `https://608d1c869f42b20017c3e804.mockapi.io/api/teams/${this.props.editTeam}`,
        {
          name: this.state.name,
          description: this.state.description,
          owner: this.state.owner,
        }
      );
      if (response.status === 200) {
        this.props.closeTeamModal(true);
        this.setState({ name: "", description: "", owner: 0 });
        toast.success("Team updated successfully", {
          position: toast.POSITION.TOP_CENTER,
        });
      }
    } else {
      const response = await axios.post(
        "https://608d1c869f42b20017c3e804.mockapi.io/api/teams",
        {
          name: this.state.name,
          description: this.state.description,
          owner: this.state.owner,
        }
      );
      if (response.status === 201) {
        this.props.closeTeamModal(true);
        this.setState({ name: "", description: "", owner: 0 });
        toast.success("Team created successfully", {
          position: toast.POSITION.TOP_CENTER,
        });
      }
    }
  };

  render() {
    if (!this.props.showModal) {
      return null;
    }
    const usersData = this.state.users.map((user) => {
      return (
        <option key={user.id} value={user.id}>
          {user.name}
        </option>
      );
    });

    return (
      <div
        className="ui sidebar right vertical visible menu"
        style={{ width: "500px" }}
      >
        <div
          style={{
            paddingTop: "50px",
            paddingRight: "20px",
            paddingLeft: "20px",
          }}
        >
          <form className="ui form">
            <div className="field">
              <label>Name</label>
              <input
                type="text"
                name="name"
                placeholder="Enter Team Name"
                onChange={(e) => this.onFormChange(e)}
                value={this.state.name}
              />
            </div>
            <div className="field">
              <label>Description</label>
              <input
                type="text"
                name="description"
                placeholder="Enter Team Description"
                onChange={(e) => this.onFormChange(e)}
                value={this.state.description}
              />
            </div>
            <div className="field">
              <label>Team Owner</label>
              <select
                className="ui dropdown"
                value={this.state.owner}
                onChange={(e) => this.onFormChange(e)}
                name="owner"
              >
                <option value="0">--</option>
                {usersData}
              </select>
            </div>
            {this.props.editTeam ? (
              <TeamMember teamId={this.props.editTeam} />
            ) : null}
            <div style={{ textAlign: "center" }}>
              <button
                className="ui secondary button"
                onClick={(e) => this.onFormSubmit(e)}
                style={{ marginRight: "25px" }}
              >
                {this.props.editTeam ? "Update" : "Create"}
              </button>
              <button
                className="ui button"
                onClick={() => this.props.closeTeamModal()}
              >
                Close
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}

export default Team;
