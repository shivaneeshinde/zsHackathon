import React, { Component } from "react";
import axios from "axios";

class Login extends Component {
  state = { email: "", password: "", invalid: false };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleSubmit = async (event) => {
    event.preventDefault();
    const loginResponse = await axios.post(
      "https://happyworkplace.herokuapp.com/login",
      {
        emailId: this.state.email,
        password: this.state.password,
      }
    );
    if (loginResponse.status === 200) {
      sessionStorage.setItem(
        "token",
        JSON.stringify(loginResponse.data.user_id)
      );
      sessionStorage.setItem("email", JSON.stringify(loginResponse.data.email));
      sessionStorage.setItem("name", JSON.stringify(loginResponse.data.name));
      sessionStorage.setItem(
        "role",
        JSON.stringify(loginResponse.data.roles.role_id)
      );
      window.location.reload();
    } else {
      this.setState({ invalid: true });
    }
    // const loginResponse = await axios.get(
    //   "https://608d1c869f42b20017c3e804.mockapi.io/api/users/1"
    // );
    // if (loginResponse.status === 200) {
    //   sessionStorage.setItem("token", JSON.stringify(loginResponse.data.id));
    //   sessionStorage.setItem("email", JSON.stringify(loginResponse.data.email));
    //   sessionStorage.setItem("name", JSON.stringify(loginResponse.data.name));
    //   sessionStorage.setItem("role", JSON.stringify(loginResponse.data.role));
    //   window.location.pathname = "/home";
    // }
  };

  render() {
    return (
      <div
        className="ui middle aligned center aligned grid"
        style={{ margin: "auto", width: "400px", marginTop: "100px" }}
      >
        <div className="column">
          <h2 className="ui teal image header">
            <div className="content">Login to Workplace Portal</div>
          </h2>
          <form className="ui large form">
            <div className="ui stacked segment">
              <div className="field">
                <div className="ui left icon input">
                  <i className="user icon"></i>
                  <input
                    type="text"
                    name="email"
                    placeholder="Enter your email"
                    onChange={(e) => {
                      this.handleChange(e);
                    }}
                  />
                </div>
              </div>
              <div className="field">
                <div className="ui left icon input">
                  <i className="lock icon"></i>
                  <input
                    type="text"
                    name="password"
                    placeholder="Enter your password"
                    onChange={(e) => {
                      this.handleChange(e);
                    }}
                  />
                </div>
              </div>
              <div
                className="ui fluid large blue submit button"
                onClick={this.handleSubmit}
              >
                Login
              </div>
            </div>
          </form>
          {this.state.invalid ? <div>Invalid Username or password</div> : ""}
        </div>
      </div>
    );
  }
}

export default Login;
