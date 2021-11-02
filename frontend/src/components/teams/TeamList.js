import React from "react";
import axios from "axios";

import Team from "./Team";
import Loader from "../Loader";

class TeamList extends React.Component {
  state = { teams: [], showTeamModal: false, editTeam: null };

  async componentDidMount() {
    const response = await axios.get(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/teams"
    );
    this.setState({ teams: response.data.reverse() });
  }

  openTeamModel = async (teamId = null) => {
    if (teamId) {
      this.setState({ editTeam: teamId });
    }
    this.setState({ showTeamModal: true });
  };

  closeTeamModal = async (refresh = null) => {
    if (refresh) {
      const response = await axios.get(
        "https://608d1c869f42b20017c3e804.mockapi.io/api/teams"
      );
      this.setState({ teams: response.data.reverse() });
    }
    this.setState({ showTeamModal: false, editTeam: null });
  };

  render() {
    console.log("Team list render");
    const teamsData = this.state.teams.length ? (
      this.state.teams.map((team) => {
        return (
          <tr key={team.id}>
            <td
              style={{ width: "400px" }}
              onClick={() => this.openTeamModel(team.id)}
            >
              <div className="ui segment" style={{ cursor: "pointer" }}>
                <h4 className="ui image header">
                  <div className="content">
                    {team.name}
                    <div className="sub header">{team.description}</div>
                  </div>
                </h4>
              </div>
            </td>
            <td style={{ verticalAlign: "middle" }}>
              <div className="ui label">{team.owner}</div>
            </td>
          </tr>
        );
      })
    ) : (
      <Loader text="Fetching Teams" topMargin="200" />
    );
    return (
      <div>
        <button
          className="ui blue button"
          onClick={(e) => this.openTeamModel()}
        >
          <i className="users icon" />+ Add Team
        </button>
        <div className="dimmable" style={{ marginTop: "20px" }}>
          <table className="ui table" style={{ width: "520px" }}>
            <thead>
              <tr>
                <th style={{ paddingLeft: "60px" }}>Teams</th>
                <th style={{ paddingLeft: "10px" }}>Members</th>
              </tr>
            </thead>
            <tbody>{teamsData}</tbody>
          </table>
        </div>
        {this.state.showTeamModal ? (
          <Team
            showModal={this.state.showTeamModal}
            closeTeamModal={this.closeTeamModal}
            editTeam={this.state.editTeam}
          />
        ) : null}
      </div>
    );
  }
}

export default TeamList;
