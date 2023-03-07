import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddTest() {

  let navigate = useNavigate();

  const [test, setTest] = useState({
    testName: "",
    testCost: ""
  });

  const { testName, testCost } = test;

  const onInputChange = (e) => {
    setTest({ ...test, [e.target.name]: e.target.value })
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8192/medicorps/admin/testlist/add", test);
    navigate("/admin/lab");
  }

  return (
    <div className="container mt-5">
      <div className="col-md-6 offset-md-3 border rounded p-4 mt-4 shadow">
        <h3 className="text-center m-4">Add Test</h3>
        <form onSubmit={(e) => onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">Name</label>
            <input type={"text"} className="form-control"
              placeholder="Enter test name" name="testName" value={testName}
              onChange={(e) => onInputChange(e)} />
          </div>
          <div className="mb-3">
            <label htmlFor="Cost" className="form-label">Charges</label>
            <input type={"number"} className="form-control"
              placeholder="Enter Test Cost" name="testCost" value={testCost}
              onChange={(e) => onInputChange(e)} />
          </div>
          <button type='submit' className='btn btn-outline-primary'>Submit</button>
          <Link className='btn btn-outline-danger mx-2' to={"/admin/lab"}>Cancel</Link>
        </form>
      </div>
    </div>
  )
}
