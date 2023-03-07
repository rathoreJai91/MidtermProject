import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewStaff() {

  const [staff , setStaff] = useState({
    staffName:"",
    staffEmail:"",
    staffRole:"",
    staffTiming:"",
    staffSalary:"",
    dateOfJoining:"",
    deptName:""
  },[])

  const {id} = useParams();

  useEffect(()=>{
    loadStaff();
  })

  const  loadStaff = async ()=>{
    const result =await axios.get(`http://localhost:8192/medicorps/admin/staff/viewbyid/${id}`)
    setStaff(result.data);
  }

  return (
    <div className="container">
      <div className="col-md-4 offset-md-4 border rounded p-4 mt-4 shadow" align='center'>
        <h3 className="text-center m-4" >Staff Details</h3>

        <div className='card'>
          <div className='card-header'>
            Details of Staff id : {staff.staffId}
            <ul className='list-group list-group-flush' >
              <li className='list-group-item'>
                <b>Department :</b>
                {staff.deptName}
              </li>
              <li className='list-group-item'>
                <b>Name :</b>
                {staff.staffName}
              </li>
              <li className='list-group-item'>
                <b>E-mail :</b>
                {staff.staffEmail}
              </li>
              <li className='list-group-item'>
                <b>Role :</b>
                {staff.staffRole}
              </li>
              <li className='list-group-item'>
                <b>Timings :</b>
                {staff.staffTiming}
              </li>
              <li className='list-group-item'>
                <b>Salary :</b>
                {staff.staffSalary}
              </li>
              <li className='list-group-item'>
                <b>Joining Date :</b>
                {staff.dateOfJoining}
              </li>
            </ul>
          </div>
        </div>
        <Link className='btn btn-primary my-2' to={"/admin/staff"}>Back</Link>
      </div>
    </div>
  )
}
