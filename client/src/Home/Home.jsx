import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import "./Home.css";

const Home = () => {
  return (
    <>
      <nav className="navbar sticky-top flex-md-nowrap p-0">
        {/* Change spans to button later */}
        <span className="navbar-brand col-sm-3 col-md-2 mr-0">Deal Orgin</span>
   
        <ul className="navbar-nav px-3">
          <li className="nav-item text-nowrap">
            <span className="nav-link">Sign out</span>
          </li>
        </ul>
      </nav>

      <div className="container-fluid">
        <div className="row">
          <nav className="col-md-2 d-none d-md-block bg-light sidebar">
            <div className="sidebar-sticky">
              <ul className="nav flex-column">
                <li className="nav-item">
                  <span className="nav-link active">
                    <Link to="/">Home</Link>
                  </span>
                </li>
                <li className="nav-item">
                  <span className="nav-link">
                    <span data-feather="file"></span>
                    <Link to="/accounts">Accounts</Link>
                  </span>
                </li>
                <li className="nav-item">
                  <span className="nav-link">
                    <span data-feather="shopping-cart"></span>
                    <Link to="/deals">Deals</Link>
                  </span>
                </li>
                <li className="nav-item">
                  <span className="nav-link">
                    <span data-feather="users"></span>
                    <Link to="/businesses">Businesses</Link>
                  </span>
                </li>   
              </ul>

              <h6 className="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                <span>Configuration</span>
              </h6>
              <ul className="nav flex-column mb-2">
              <li className="nav-item">
                  <span className="nav-link">
                    <span data-feather="bar-chart-2"></span>
                    Settings
                  </span>
                </li>
              </ul>
            </div>
          </nav>
        </div>
        <main role="main" className="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div className="outlet">
          <Outlet/>

          </div>
        </main>
      </div>
    </>
  )
}

export default Home