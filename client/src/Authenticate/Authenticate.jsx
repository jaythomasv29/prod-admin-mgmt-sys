import axios from 'axios';
import React, { useState } from 'react'
import "./Authenticate.css"

const defaultLoginDetails = {
  email: "",
  password: ""
}

const defaultRegisterDetails = {
  fullname: "",
  email: "",
  password: "",
  confirmPassword: "",
  telephone: "",
  gender: ""
}
function Authenticate() {
  const [loginDetails, setLoginDetails] = useState(defaultLoginDetails);
  const [registerDetails, setRegisterDetails] = useState(defaultRegisterDetails);
  console.log(loginDetails);
  console.log(registerDetails);
  const handleLoginInputChange = (e) => {
    const { name, value } = e.target;
    setLoginDetails({
      ...loginDetails,
      [name]: value
    });
  }

  const handleRegisterInputChange = (e) => {
    const { name, value } = e.target;

    setRegisterDetails({
      ...registerDetails,
      [name]: value
    });
  }

  const handleLogin = async () => {

  }

  const handleRegisterForm = async (e) => {
    e.preventDefault();
    const { fullname, email, password, confirmPassword, telephone, gender } = registerDetails;
    if (password != confirmPassword || gender == "") return;

    
    console.log("triggered", registerDetails)
    try {
      const response = await fetch("/accounts/auth/register", {
        method: "POST",
        body: JSON.stringify({fullname, email, password, telephone, gender}),
        headers: {
          'Content-Type':'application/json'
        }
      })
      const data = await response.json();
      console.log(data)
      // const response = await axios.post("/accounts/auth/register", { fullname, email, password, telephone, gender });
      // const data = await response.json();
      // console.log(data);
    } catch (err) {
      console.log(err);
    }

  }
  return (
    <>
      <nav className="navbar bg-light">
        <div className="container-fluid">
          <span className="navbar-brand mb-0 h1">Deal Orgin</span>
        </div>
      </nav>
      <div className="text-center form-container">
        <h2>Welcome To Deal Orgin</h2>
        <span>Let's get you setup to hunt for the latest deals!</span>
        <div className="dual-form-container">

          <form className="form-signin" onSubmit={handleLogin}>
            {/* <img className="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> */}
            <h2 className="h3 mb-3 font-weight-normal">Have an Account? Please sign in</h2>
            <label htmlFor="loginEmail" className="mb-1">Email address</label>
            <input onChange={handleLoginInputChange} name="email" type="email" id="loginEmail" className="form-control mb-1" placeholder="Email address" required autoFocus />
            <label name="password" htmlFor="loginPassword" className="mb-1">Password</label>
            <input type="password" onChange={handleLoginInputChange} name="password" id="loginPassword" className="form-control mb-4" placeholder="Password" required />

            <button className="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

          </form>
          <form className="form-signin" onSubmit={handleRegisterForm}>
            {/* <img className="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> */}
            <h1 className="h3 mb-3 font-weight-normal">Hi, are you new?<br />Please register</h1>

            <label htmlFor="inputFullName" className="mb-1">Name</label>
            <input onChange={handleRegisterInputChange} type="text" id="inputFullName" name="fullname" className="form-control mb-1" placeholder="Full name e.g Johnny Appleseed" required />

            <label htmlFor="inputEmail" className="">Email address</label>
            <input onChange={handleRegisterInputChange} type="email" id="inputEmail" name="email" className="form-control mb-1" placeholder="Email address" required />

            <label htmlFor="inputPassword" className="mb-1">Password</label>
            <input onChange={handleRegisterInputChange} type="password" id="inputPassword" name="password" className="form-control mb-1" placeholder="Password" required />

            <label htmlFor="inputConfirmPassword" className="mb-1">Confirm Password</label>
            <input onChange={handleRegisterInputChange} type="password" id="inputConfirmPassword" name="confirmPassword" className="form-control mb-1" placeholder="Confirm Password" required />


            <label htmlFor="inputTelephone" className="mb-1">Telephone</label>
            <div className="input-group input-group-sm">

              <input onChange={handleRegisterInputChange} type="tel" id="inputTelephone" name="telephone" className="form-control mb-1" placeholder="Telephone" required />
            </div>

            <label htmlFor="inputGender" className="mb-1">Gender</label>

            <select onChange={handleRegisterInputChange} className="form-select mb-4" name="gender" id="inputGender">
              <option value="">Select Gender</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="female">Other</option>
            </select>
            <button className="btn btn-lg btn-info btn-block text-white" type="submit">Register</button>

          </form>
        </div>
      </div>
    </>
  )
}

export default Authenticate