import axios from "axios";
import React, { useState } from "react";

const URL = "http://localhost:9999/customer-service/customers";

const AddCustomer = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    const customer = { name, email };
    axios
      .post(URL, customer)
      .then((response) => {
        console.log(response);
        alert("Customer added successfully");
        window.location.href = "/customers";
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div className="flex justify-center py-5">
      <form class="w-full max-w-sm" onSubmit={handleSubmit}>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label
              class="block text-base-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
              for="inline-full-name"
            >
              Name
            </label>
          </div>
          <div class="md:w-2/3">
            <input
              class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
              id="name"
              type="text"
              placeholder="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label
              class="block text-base-500 font-bold md:text-right mb-1 md:mb-0 pr-4"
              for="email"
            >
              email
            </label>
          </div>
          <div class="md:w-2/3">
            <input
              class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
              id="email"
              type="email"
              placeholder="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
        </div>
        <div class="md:flex md:justify-end">
          <div class="w-5/6">
            <button
              class="shadow bg-purple-500 hover:bg-purple-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded w-full"
              type="submit"
            >
              Add customer
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default AddCustomer;
