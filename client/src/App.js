import React from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./Home/Home";
import Accounts from "./Accounts/Accounts";
import Deals from "./Deals/Deals";
import Error from "./Error/Error";
import Main from "./Main/Main";
import Businesses from "./Businesses/Businesses";
import Authenticate from "./Authenticate/Authenticate";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}>
          <Route index element={<Main />}/>
          <Route path="/accounts" element={<Accounts />} />
          <Route path="/deals" element={<Deals />} />
          <Route path="/businesses" element={<Businesses />} />
        </Route>
          <Route path="/auth" element={<Authenticate />} />
          <Route path="*" element={<Error />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
