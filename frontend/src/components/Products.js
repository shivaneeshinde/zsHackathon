import React from "react";
import axios from "axios";
import { toast } from "react-toastify";

class Products extends React.Component {
  state = { property: "", imageUrl: "", details: "", price: "" };

  async componentDidMount() {
    if (this.props.editUser) {
      const response = await axios.get(
        `https://zshackathon.herokuapp.com/addProduct/${this.props.editUser}`
      );
      this.setState({
        productName: this.state.productName,
        imageUrl: this.state.imageUrl,
        details: this.state.details,
        price: this.state.price,
      });
    }
  }

  onFormChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  onFormSubmit = async (e) => {
    e.preventDefault();
    if (this.props.editUser) {
      const response = await axios.put(
        `https://zshackathon.herokuapp.com/addProduct/${this.props.editUser}`,
        {
          productName: this.state.productName,
          imageUrl: this.state.imageUrl,
          details: this.state.details,
          price: this.state.price,
        }
      );
      if (response.status === 200) {
        this.props.closeUserModal(true);
        this.setState({ productName: "", imageUrl: "", details: "", price: "" });
        toast.success("Product updated successfully", {
          position: toast.POSITION.TOP_CENTER,
        });
      }
    } else {
      const response = await axios.post(
        "https://zshackathon.herokuapp.com/addProduct",
        {
          productName: this.state.productName,
          imageUrl: this.state.imageUrl,
          details: this.state.details,
          price: this.state.price,
        }
      );
      if (response.status === 201) {
        this.props.closeUserModal(true);
        this.setState({ name: "", email: "", mobile: "", role: "Employee" });
        toast.success("Product added successfully", {
          position: toast.POSITION.TOP_CENTER,
        });
      }
    }
  };

  render() {
    if (!this.props.showModal) {
      return null;
    }
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
              <label>Product Name</label>
              <input
                type="text"
                name="Product Name"
                placeholder="Enter Product Name"
                onChange={(e) => this.onFormChange(e)}
                value={this.state.name}
              />
            </div>
            <div className="field">
              <label>Price</label>
              <input
                type="text"
                name="Price"
                placeholder="Enter Product Price"
                onChange={(e) => this.onFormChange(e)}
                value={this.state.price}
              />
            </div>
            <div className="field">
              <label>Product Image URL</label>
              <input
                type="text"
                name="url"
                placeholder="Enter Product Image URL"
                onChange={(e) => this.onFormChange(e)}
                value={this.state.url}
              />
            </div>
            <div className="field">
              <label>Product Detail</label>
              <input
                type="text"
                name="detail"
                placeholder="Enter Product Detail"
                onChange={(e) => this.onFormChange(e)}
                value={this.state.detail}
              />
            </div>
            <div style={{ textAlign: "center" }}>
              <button
                className="ui secondary button"
                onClick={(e) => this.onFormSubmit(e)}
                style={{ marginRight: "25px" }}
              >
                {this.props.editUser ? "Update" : "Create"}
              </button>
              <button
                className="ui button"
                onClick={() => this.props.closeUserModal()}
              >
                Cancel
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}

export default Products;
