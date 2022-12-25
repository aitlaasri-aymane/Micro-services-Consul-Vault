import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div className="navbar bg-primary text-primary-content">
      <div className="flex-1 px-2 lg:flex-none">
        <a className="text-lg font-bold">Store</a>
      </div>
      <div className="flex justify-center flex-1 px-2">
        <div className="flex items-stretch">
          <Link className="btn btn-ghost rounded-btn" to="/">
            Home
          </Link>
          <div className="dropdown dropdown-end dropdown-content">
            <label tabIndex={0} className="btn btn-ghost rounded-btn">
              Customers
              <svg
                className="fill-current rotate-90"
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
              >
                <path d="M8.59,16.58L13.17,12L8.59,7.41L10,6L16,12L10,18L8.59,16.58Z" />
              </svg>
            </label>
            <ul
              tabIndex={0}
              className="menu dropdown-content p-2 shadow bg-primary text-primary-content rounded-box w-52 mt-4"
            >
              <li>
                <Link to="/customers">View customers</Link>
              </li>
              <li>
                <Link to="/addcustomer">Add new customer</Link>
              </li>
            </ul>
          </div>
          <div className="dropdown dropdown-end dropdown-content">
            <label tabIndex={0} className="btn btn-ghost rounded-btn">
              Products
              <svg
                className="fill-current rotate-90"
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
              >
                <path d="M8.59,16.58L13.17,12L8.59,7.41L10,6L16,12L10,18L8.59,16.58Z" />
              </svg>
            </label>
            <ul
              tabIndex={0}
              className="menu dropdown-content p-2 shadow bg-primary text-primary-content rounded-box w-52 mt-4"
            >
              <li>
                <Link to="/products">View products</Link>
              </li>
              <li>
                <Link to="/">Add new product</Link>
              </li>
            </ul>
          </div>
          <div className="dropdown dropdown-end dropdown-content">
            <label tabIndex={0} className="btn btn-ghost rounded-btn">
              Orders
              <svg
                className="fill-current rotate-90"
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
              >
                <path d="M8.59,16.58L13.17,12L8.59,7.41L10,6L16,12L10,18L8.59,16.58Z" />
              </svg>
            </label>
            <ul
              tabIndex={0}
              className="menu dropdown-content p-2 shadow bg-primary text-primary-content rounded-box w-52 mt-4"
            >
              <li>
                <Link to="/orders">View orders</Link>
              </li>
              <li>
                <Link to="/">Add new order</Link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Navbar;
