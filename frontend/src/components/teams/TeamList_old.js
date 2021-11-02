import React from "react";
import axios from "axios";

class TeamList extends React.Component {
  state = { teams: [] };

  async componentDidMount() {
    const response = await axios.get(
      "https://607ea8b302a23c0017e8bd3c.mockapi.io/api/Teams"
    );
    this.setState({ teams: response.data });
  }

  render() {
    const teamsData = this.state.teams.map((team) => {
      return (
        <div className="four wide column">
          <div className="ui card" key={team.id}>
            <div className="content">
              <div className="header">{team.name}</div>
            </div>
            <div className="description" style={{ marginLeft: "10px" }}>
              {team.description}
            </div>
            <div className="extra content">Members:{team.owner}</div>
          </div>
        </div>
      );
    });
    return <div className="ui grid container">{teamsData}</div>;
  }
}

export default TeamList;
