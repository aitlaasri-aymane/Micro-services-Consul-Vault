import axios from "axios";
import React, { useEffect, useState } from "react";

const URL = "http://localhost:9999/customer-service/customers";

const Customers = () => {
  const [customers, setCustomers] = useState(null);

  useEffect(() => {
    axios
      .get(`${URL}`)
      .then((response) => {
        setCustomers(response.data._embedded.customers);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="overflow-x-auto">
      <h1 className="capitalize text-2xl font-bold mb-4">Customers :</h1>
      <table className="table table-zebra w-full">
        <thead>
          <tr>
            <th></th>
            <th>Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {customers?.map((customer, index) => (
            <tr>
              <th>{customer.id}</th>
              <td>{customer.name}</td>
              <td>{customer.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Customers;
