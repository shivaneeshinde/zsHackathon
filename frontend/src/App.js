import React from "react";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import Home from "./components/Home";
import UserList from "./components/UserList";
import TeamList from "./components/teams/TeamList";
import Meeting from "./components/Meeting";
import Login from "./components/Login";
import DiscussionList from "./components/DiscussionList";

import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function App() {
  const userName = JSON.parse(sessionStorage.getItem("name"));
  const tokenString = sessionStorage.getItem("token");
  const token = JSON.parse(tokenString);

  if (!token) {
    return <Login />;
  }

  return (
    <div
      style={{ marginLeft: "300px", marginTop: "50px", marginRight: "50px" }}
    >
      <Router>
        <div>
          <div
            className="ui sidebar inverted left visible vertical menu"
            style={{ width: "200px", textAlign: "center", paddingTop: "30px" }}
          >
            <img
              className="ui tiny avatar image"
              src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png"
              style={{ marginBottom: "20px" }}
              alt="Profile"
            />
            <div
              className="ui inverted"
              style={{ color: "white", fontWeight: "bold" }}
            >
              Welcome!
              <p>{userName}</p>
            </div>
            <Link
              to="/home"
              className="ui inverted button"
              style={{ width: "150px", marginTop: "10px" }}
            >
              <i className="home icon" />
              Home
            </Link>
            <Link
              to="/users"
              className="ui inverted button"
              style={{ width: "150px", marginTop: "10px" }}
            >
              <i className="user icon" />
              Users
            </Link>
            <Link
              to="/teams"
              className="ui inverted button"
              style={{ width: "150px", marginTop: "10px" }}
            >
              <i className="users icon" />
              Teams
            </Link>
            <Link
              to="/discussions"
              className="ui inverted button"
              style={{ width: "150px", marginTop: "10px" }}
            >
              <i className="users icon" />
              Discussions
            </Link>
            <Link
              to="/meetings"
              className="ui inverted button"
              style={{ width: "150px", marginTop: "10px" }}
            >
              <i className="users icon" />
              Meetings
            </Link>
            <Link
              className="ui inverted button"
              onClick={() => {
                sessionStorage.clear();
                window.location.pathname = "/";
              }}
              style={{ width: "150px", marginTop: "10px", float: "bottom" }}
            >
              <i className="sign-out icon" />
              Logout
            </Link>
          </div>
          <Switch>
            <Route path="/home">
              <Home />
            </Route>
            <Route path="/users">
              <UserList />
            </Route>
            <Route path="/teams">
              <TeamList />
            </Route>
            <Route path="/discussions">
              <DiscussionList />
            </Route>
            <Route path="/meetings">
              <Meeting />
            </Route>
          </Switch>
        </div>
      </Router>
      <ToastContainer />
    </div>
  );
}

export default App;
