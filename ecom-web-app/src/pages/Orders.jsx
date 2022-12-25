import axios from "axios";
import React, { useEffect, useState } from "react";

const URL = "http://localhost:9999/order-service/api/orders";

const Orders = () => {
  const [orders, setOrders] = useState(null);
  const [sum, setSum] = useState(null);

  useEffect(() => {
    axios
      .get(`${URL}`)
      .then((response) => {
        setOrders(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="overflow-x-auto">
      <h1 className="capitalize text-2xl font-bold mb-4">Orders :</h1>
      <table className="table table-zebra w-full">
        <thead>
          <tr>
            <th></th>
            <th>Customer</th>
            <th>Products</th>
            <th>Total</th>
            <th>Status</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {orders?.map((order, index) => (
            <tr>
              <th>{order.id}</th>
              <td>{order.customer.name}</td>
              <td>
                {order.products.map((product, index) => (
                  <p>
                    {index + 1}. {product.name}
                  </p>
                ))}
              </td>
              <td>
                {order.products?.reduce(function (acc, obj) {
                  return parseFloat(acc + obj.price).toFixed(2);
                }, 0)}
              </td>
              <td
                className={
                  order.orderStatus === "CANCELED"
                    ? "text-rose-500"
                    : "text-amber-500"
                }
              >
                {order.orderStatus}
              </td>
              <td>{order.createdAt}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Orders;
