import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewDoctor() {

  const [doc, setDoc] = useState({
    docName: "",
    docEmail: "",
    speciality: "",
    experience: "",
    designation: "",
    fees: "",
    timings: "",
    docSalary: "",
    dateOfJoining:"",
    deptName:""
  }, []);

  const { id } = useParams();

  useEffect(() => {
    loadDoc();
  })

  const loadDoc = async () => {
    const result = await axios.get(`http://localhost:8192/medicorps/admin/doctor/viewbyid/${id}`)
    setDoc(result.data);
  }


  return (
    <div className="container">
      <div className="col-md-4 offset-md-4 border rounded p-4 mt-4 shadow" align='center'>
        <h3 className="text-center m-4" >Doctor Details</h3>

        <div className='card'>
          <div className='card-header'>
            Details of Doctor id : {doc.docId}
            <ul className='list-group list-group-flush' >
              <li className='list-group-item'>
                <b>Department :</b>
                {doc.deptName}
              </li>
              <li className='list-group-item'>
                <b>Name :</b>
                {doc.docName}
              </li>
              <li className='list-group-item'>
                <b>E-mail :</b>
                {doc.docEmail}
              </li>
              <li className='list-group-item'>
                <b>Designation :</b>
                {doc.designation}
              </li>
              <li className='list-group-item'>
                <b>Speciality :</b>
                {doc.speciality}
              </li>
              <li className='list-group-item'>
                <b>Fees :</b>
                {doc.fees}
              </li>
              <li className='list-group-item'>
                <b>Experience :</b>
                {doc.experience}
              </li>
              <li className='list-group-item'>
                <b>Timings :</b>
                {doc.timings}
              </li>
              <li className='list-group-item'>
                <b>Salary :</b>
                {doc.docSalary}
              </li>
              <li className='list-group-item'>
                <b>Joining Date :</b>
                {doc.dateOfJoining}
              </li>
            </ul>
          </div>
        </div>
        <Link className='btn btn-primary my-2' to={"/admin/doctor"}>Back</Link>
      </div>
    </div>
  )
}
