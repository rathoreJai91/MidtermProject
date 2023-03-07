import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

export default function StaffPage() {
  
  const [staffs, setStaff] = useState([]);

  useEffect(() => {
    loadStaff();
  }, []);

  const loadStaff = async () => {
    const result = await axios.get("http://localhost:8192/medicorps/admin/staff/viewall");
    setStaff(result.data);
  }

  const deleteStaff = async (id) => {
    await axios.delete(`http://localhost:8192/medicorps/admin/staff/delete/${id}`)
    loadStaff();
  }

  return (
    <div className='container'>
      <div>
        <h3 className='my-5' align="center">Staff List</h3>
        <table className="table border shadow">
          <thead align="center">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Role</th>
              <th scope="col">Department</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody align="center">
            {
              staffs.map((staff, index) => (
                <tr>
                  <th scope="row" key={index}>{index + 1}</th>
                  <td>{staff.staffName}</td>
                  <td>{staff.staffRole}</td>
                  <td>{staff.deptName}</td>
                  <td>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/staff/view/${staff.staffId}`}
                    >View</Link>
                    <button className='btn btn-danger mx-2'
                      onClick={() => deleteStaff(staff.staffId)}
                    >Delete</button>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/staff/update/${staff.staffId}`}
                    >Update</Link>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
        <div align="center">
          <Link className='btn btn-primary mx-2 text-right'
            to={'/admin/staff/add'}
          >Add Staff</Link>
        </div>
      </div>
    </div>
  )
}
