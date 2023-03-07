import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

export default function ReceptionistPage() {
  
  const [receps, setRecep] = useState([]);
  
  useEffect(() => {
    loadReceps();
  }, []);

  const loadReceps = async () => {
    const result = await axios.get("http://localhost:8192/medicorps/admin/receptionist/viewall");
    setRecep(result.data);
  }

  const deleteRecep = async (id) => {
    await axios.delete(`http://localhost:8192/medicorps/admin/receptionist/delete/${id}`)
    loadReceps();
  }

  return (
    <div className='container'>
      <div>
        <h3 className='my-5' align="center">Receptionists</h3>
        <table className="table border shadow">
          <thead align="center">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Department</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody align="center">
            {
              receps.map((recep, index) => (
                <tr>
                  <th scope="row" key={index}>{index + 1}</th>
                  <td>{recep.receptionistName}</td>
                  <td>{recep.deptName}</td>
                  <td>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/receptionist/view/${recep.receptionistId}`}
                    >View</Link>
                    <button className='btn btn-danger mx-2'
                      onClick={() => deleteRecep(recep.receptionistId)}
                    >Delete</button>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/receptionist/update/${recep.receptionistId}`}
                    >Update</Link>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
        <div align="center">
          <Link className='btn btn-primary mx-2 text-right'
            to={'/admin/receptionist/add'}
          >Add Receptionists</Link>
        </div>
      </div>
    </div>
  )
}
