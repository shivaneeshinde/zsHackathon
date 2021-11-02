import React from "react";
import axios from "axios";

import User from "./User";
import Loader from "./Loader";

class UserList extends React.Component {
  state = { users: [], showUserModal: false, editUser: null };

  async componentDidMount() {
    const response = await axios.get(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/users"
    );
    this.setState({ users: response.data.reverse() });
  }

  openUserModel = async (userId = null) => {
    if (userId) {
      this.setState({ editUser: userId });
    }
    this.setState({ showUserModal: true });
  };

  closeUserModal = async (refresh = null) => {
    if (refresh) {
      const response = await axios.get(
        "https://608d1c869f42b20017c3e804.mockapi.io/api/users"
      );
      this.setState({ users: response.data.reverse() });
    }
    this.setState({ showUserModal: false, editUser: null });
  };

  render() {
    console.log("User list render");
    const usersData = this.state.users.length ? (
      this.state.users.map((user) => {
        return (
          <tr key={user.id}>
            <td
              style={{ width: "400px" }}
              onClick={() => this.openUserModel(user.id)}
            >
              <div className="ui segment" style={{ cursor: "pointer" }}>
                <h4 className="ui image header">
                  <img
                    src={user.avatar}
                    className="ui mini rounded image"
                    alt={user.name}
                  />
                  <div className="content">
                    {user.name}
                    <div className="sub header">{user.email}</div>
                  </div>
                </h4>
              </div>
            </td>
            <td style={{ verticalAlign: "middle" }}>
              <div className="ui label">{user.role}</div>
            </td>
          </tr>
        );
      })
    ) : (
      <Loader text="Fetching Users" topMargin="200" />
    );
    return (
      <div>
        <button
          className="ui blue button"
          onClick={(e) => this.openUserModel()}
        >
          <i className="user plus icon" /> Add User
        </button>
        <div className="dimmable" style={{ marginTop: "20px" }}>
          <table className="ui table" style={{ width: "520px" }}>
            <thead>
              <tr>
                <th style={{ paddingLeft: "60px" }}>Employee</th>
                <th style={{ paddingLeft: "20px" }}>Role</th>
              </tr>
            </thead>
            <tbody>{usersData}</tbody>
          </table>
        </div>
        {this.state.showUserModal ? (
          <User
            showModal={this.state.showUserModal}
            closeUserModal={this.closeUserModal}
            editUser={this.state.editUser}
          />
        ) : null}
      </div>
    );
  }
}

export default UserList;
