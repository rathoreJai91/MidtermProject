import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function DepartmentPage() {

  const [depts, setdept] = useState([]);

  useEffect(() => {
    loadDepts();
  }, []);

  const loadDepts = async () => {
    const result = await axios.get("http://localhost:8192/medicorps/admin/department/viewall");
    setdept(result.data);
  }

  const deleteDept = async (id) => {
    await axios.delete(`http://localhost:8192/medicorps/admin/department/delete/${id}`)
    loadDepts();
  }

  return (
    <div className='container my-4'>
      <div>
        <h3 className='my-5' align="center">Departments</h3>
        <table className="table border shadow">
          <thead align="center">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Department Name</th>
              <th scope="col">No. of Employess</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody align="center">
            {
              depts.map((dept, index) => (
                <tr>
                  <th scope="row" key={index}>{index + 1}</th>
                  <td>{dept.deptName}</td>
                  <td>{dept.noOfEmps}</td>
                  <td>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/viewdepartment/${dept.deptId}`}
                    >View</Link>
                    <button className='btn btn-danger mx-2'
                      onClick={() => deleteDept(dept.deptId)}
                    >Delete</button>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
        <div align="center">
          <Link className='btn btn-primary mx-2 text-right'
          to={"/admin/adddepartment"}
          >Add Department</Link>
        </div>

      </div>

    </div>
  )
}
