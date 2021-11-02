import React from "react";
import axios from "axios";
import { toast } from "react-toastify";

import Loader from "./Loader";

class DiscussionList extends React.Component {
  state = {
    discussions: [],
    disSub: "",
    disDesc: "",
    disAnon: true,
    showdis: false,
  };

  async componentDidMount() {
    const response = await axios.get(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/discussions"
    );
    this.setState({ discussions: response.data.reverse() });
  }

  onValueChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  onFormSubmit = async (e) => {
    const formResponse = await axios.post(
      "https://608d1c869f42b20017c3e804.mockapi.io/api/discussions",
      {
        subject: this.state.disSub,
        description: this.state.disDesc,
        userId: JSON.parse(sessionStorage.getItem("token")),
        userName: JSON.parse(sessionStorage.getItem("name")),
        anonymous: this.state.disAnon,
      }
    );
    if (formResponse.status === 201) {
      toast.success("Discussion created successfully", {
        position: toast.POSITION.TOP_CENTER,
      });
      const disResponse = await axios.get(
        "https://608d1c869f42b20017c3e804.mockapi.io/api/discussions"
      );
      this.setState({
        discussions: disResponse.data.reverse(),
        showdis: false,
        disSub: "",
        disDesc: "",
      });
    }
  };

  onVoteSubmit = async (e) => {
    let voteResponse;
    if (e.target.getAttribute("name") === "upvote") {
      voteResponse = await axios.put(
        `https://608d1c869f42b20017c3e804.mockapi.io/api/discussions/${e.target.getAttribute(
          "value"
        )}`,
        {
          upvote: parseInt(e.target.getAttribute("datavalue")) + 1,
        }
      );
    } else {
      voteResponse = await axios.put(
        `https://608d1c869f42b20017c3e804.mockapi.io/api/discussions/${e.target.getAttribute(
          "value"
        )}`,
        {
          downvote: parseInt(e.target.getAttribute("datavalue")) + 1,
        }
      );
    }
    if (voteResponse.status === 200) {
      const dresponse = await axios.get(
        "https://608d1c869f42b20017c3e804.mockapi.io/api/discussions"
      );
      this.setState({ discussions: dresponse.data.reverse() });
    }
  };

  render() {
    const discussionsData = this.state.discussions.length ? (
      this.state.discussions.map((discussion) => {
        return (
          <div className="ui card" style={{ width: "500px" }}>
            <div className="content">
              <b>{discussion.subject}</b>
              <p>{discussion.description}</p>
            </div>
            <div className="content">
              <i
                className="thumbs up icon"
                value={discussion.id}
                name="upvote"
                datavalue={discussion.upvote}
                onClick={(e) => {
                  this.onVoteSubmit(e);
                }}
                style={{ cursor: "pointer" }}
              ></i>
              {discussion.upvote}
              <i
                className="thumbs down icon"
                style={{ marginLeft: "20px", cursor: "pointer" }}
                name="downvote"
                datavalue={discussion.downvote}
                onClick={(e) => {
                  this.onVoteSubmit(e);
                }}
                value={discussion.id}
              ></i>
              {discussion.downvote}
            </div>
          </div>
        );
      })
    ) : (
      <Loader text="Fetching Discussions" topMargin="50" leftMargin="100" />
    );
    return (
      <div>
        {this.state.showdis ? (
          <div className="ui segment" style={{ width: "500px" }}>
            <form className="ui form">
              <div className="field">
                <input
                  type="text"
                  name="disSub"
                  onChange={(e) => {
                    this.onValueChange(e);
                  }}
                  value={this.state.disSub}
                  placeholder="Enter the subject of discussion"
                />
              </div>
              <div className="field">
                <textarea
                  rows="3"
                  name="disDesc"
                  onChange={(e) => {
                    this.onValueChange(e);
                  }}
                  value={this.state.disDesc}
                  placeholder="Describe here..."
                ></textarea>
              </div>
              <div>
                <div className="ui toggle checkbox">
                  <input
                    type="checkbox"
                    checked={this.state.disAnon}
                    onChange={(e) => {
                      this.setState({ disAnon: !this.state.disAnon });
                    }}
                  />
                  <label>Anonymous?</label>
                </div>
                <div style={{ float: "right" }}>
                  <i
                    className="large check green icon"
                    onClick={(e) => this.onFormSubmit(e)}
                    style={{ cursor: "pointer" }}
                  />

                  <i
                    className="large delete red icon"
                    onClick={() => this.setState({ showdis: false })}
                    style={{ cursor: "pointer" }}
                  />
                </div>
              </div>
            </form>
          </div>
        ) : (
          <button
            className="ui blue button"
            onClick={(e) => this.setState({ showdis: true })}
          >
            <i className="user plus icon" /> Add new Discussion
          </button>
        )}
        <div style={{ marginTop: "20px" }}>{discussionsData}</div>
      </div>
    );
  }
}

export default DiscussionList;
