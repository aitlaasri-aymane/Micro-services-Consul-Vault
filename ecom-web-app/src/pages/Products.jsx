import axios from "axios";
import React, { useEffect, useState } from "react";

const URL = "http://localhost:9999/inventory-service/products";

const Products = () => {
  const [products, setProducts] = useState(null);

  useEffect(() => {
    axios
      .get(`${URL}`)
      .then((response) => {
        console.log(response.data._embedded.products);
        setProducts(response.data._embedded.products);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="overflow-x-auto">
      <h1 className="capitalize text-2xl font-bold my-4">Products :</h1>
      <table className="table table-zebra w-full">
        <thead>
          <tr>
            <th></th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
          </tr>
        </thead>
        <tbody>
          {products?.map((product, index) => (
            <tr>
              <th>{product.id}</th>
              <td>{product.name}</td>
              <td>{product.price}</td>
              <td>{product.quantity}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Products;
