import { Route, BrowserRouter, Routes } from "react-router-dom";
import Customers from "./pages/Customers";
import Layout from "./components/Layout";
import Navbar from "./components/Navbar";
import Orders from "./pages/Orders";
import Products from "./pages/Products";
import Home from "./pages/Home";
import AddCustomer from "./pages/AddCustomer";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="customers" element={<Customers />} />
          <Route path="products" element={<Products />} />
          <Route path="orders" element={<Orders />} />
          <Route path="addcustomer" element={<AddCustomer />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
