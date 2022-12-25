import React from "react";
import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <div className="container my-5 mx-auto">
      <Outlet />
    </div>
  );
};

export default Layout;
