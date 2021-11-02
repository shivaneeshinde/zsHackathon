import React from "react";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import Home from "./components/Home";
import ProductList from "./components/ProductList";

import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function App() {
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
              <p>Buyer</p>
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
              to="/products"
              className="ui inverted button"
              style={{ width: "150px", marginTop: "10px" }}
            >
              <i className="user icon" />
              Products
            </Link>
          </div>
          <Switch>
            <Route path="/home">
              <Home />
            </Route>
            <Route path="/products">
              <ProductList />
            </Route>
          </Switch>
        </div>
      </Router>
      <ToastContainer />
    </div>
  );
}

export default App;
