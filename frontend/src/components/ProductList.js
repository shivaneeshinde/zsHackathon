import React, { Component } from 'react';
import axios from "axios"; 

import User from "./Products";
import Loader from "./Loader";

class ProductList extends React.Component {
  state = { users: [], showUserModal: false, editUser: null };

  async componentDidMount() {
    const response = await axios.get(
      "http://localhost:8080/productList"
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
        "http://localhost:8080/productList"
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
          <tr key={user.product_id}>
            <td
              style={{ width: "400px" }}
              onClick={() => this.openUserModel(user.product_id)}
            >
              <div className="ui segment" style={{ cursor: "pointer" }}>
                <h4 className="ui image header">
                  <img
                    src={user.image_url}
                    className="ui mini rounded image"
                    alt={user.image_url}
                  />
                  <div className="content">
                    {user.product_name}
                    <div className="sub header">{user.product_name}</div>
                  </div>
                </h4>
              </div>
            </td>
            <td style={{ verticalAlign: "middle" }}>
              <div className="ui label">{user.price}</div>
            </td>
          </tr>
        );
      })
    ) : (
      <Loader text="Fetching Products" topMargin="200" />
    );
    return (
      <div>
        <button
          className="ui blue button"
          onClick={(e) => this.openUserModel()}
        >
          <i className="user plus icon" /> Add Product
        </button>
        <div className="dimmable" style={{ marginTop: "20px" }}>
          <table className="ui table" style={{ width: "520px" }}>
            <thead>
              <tr>
                <th style={{ paddingLeft: "60px" }}>Product ID</th>
                <th style={{ paddingLeft: "60px" }}>Product Name</th>
                <th style={{ paddingLeft: "20px" }}>Product Details</th>
                <th style={{ paddingLeft: "60px" }}>Product Image</th>
                <th style={{ paddingLeft: "60px" }}>Product Price</th>
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

export default ProductList;
