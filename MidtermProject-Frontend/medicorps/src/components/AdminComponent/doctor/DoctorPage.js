import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

export default function DoctorPage() {

  const [docs, setDoc] = useState([]);

  useEffect(() => {
    loadDocs();
  }, []);

  const loadDocs = async () => {
    const result = await axios.get("http://localhost:8192/medicorps/admin/doctor/viewall");
    setDoc(result.data);
  }

  const deleteDoc = async (id) => {
    await axios.delete(`http://localhost:8192/medicorps/admin/doctor/delete/${id}`)
    loadDocs();
  }

  return (
    <div className='container'>
      <div>
        <h3 className='my-5' align="center">Doctors</h3>
        <table className="table border shadow">
          <thead align="center">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Speciality</th>
              <th scope="col">Department</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody align="center">
            {
              docs.map((doc, index) => (
                <tr>
                  <th scope="row" key={index}>{index + 1}</th>
                  <td>{doc.docName}</td>
                  <td>{doc.speciality}</td>
                  <td>{doc.deptName}</td>
                  <td>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/doctor/view/${doc.docId}`}
                    >View</Link>
                    <button className='btn btn-danger mx-2'
                      onClick={() => deleteDoc(doc.docId)}
                    >Delete</button>
                    <Link className='btn btn-primary mx-2'
                      to={`/admin/doctor/update/${doc.docId}`}
                    >Update</Link>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
        <div align="center">
          <Link className='btn btn-primary mx-2 text-right'
            to={'/admin/doctor/add'}
          >Add Doctor</Link>
        </div>
      </div>
    </div>
  )
}
