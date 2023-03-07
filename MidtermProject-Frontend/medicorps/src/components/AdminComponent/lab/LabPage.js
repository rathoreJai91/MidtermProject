import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

export default function LabPage() {

  const [tests, setTests] = useState([]);

  useEffect(() => {
    loadTests();
  }, []);

  const loadTests = async () => {
    const result = await axios.get("http://localhost:8192/medicorps/admin/testlist/view");
    setTests(result.data);
  }

  const deleteTest = async (id) => {
    await axios.delete(`http://localhost:8192/medicorps/admin/testlist/delete/${id}`);
    loadTests();
  }

  return (
    <div className='container'>
      <div>
        <h3 className='my-5' align="center">Available Tests</h3>
        <table className="table border shadow">
          <thead align="center">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Cost</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody align="center">
            {
              tests.map((test, index) => (
                <tr>
                  <th scope="row" key={index}>{index + 1}</th>
                  <td>{test.testName}</td>
                  <td>{test.testCost}</td>
                  <td>
                    <button className='btn btn-danger mx-2'
                      onClick={() => deleteTest(test.testListId)}
                    >Delete</button>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/lab/updatetest/${test.testListId}`}
                    >Update</Link>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
        <div align="center">
          <Link className='btn btn-primary mx-2 text-right'
            to={'/admin/lab/addtest'}
          >Add Test</Link>
        </div>
      </div>
    </div>
  )
}
