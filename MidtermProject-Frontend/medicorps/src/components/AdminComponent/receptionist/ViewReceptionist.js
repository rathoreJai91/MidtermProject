import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';

export default function ViewReceptionist() {

  const [recep , setRecep] = useState({
    receptionistName:"",
    receptionistEmail:"",
    receptionistSalary:"",
    receptionistTimings:"",
    dateOfJoining:"",
    deptName:""
  },[]);

  const {id} = useParams();

  useEffect( ()=> {
    loadReceps();
  })

  const loadReceps = async() =>{
    const result = await axios.get(`http://localhost:8192/medicorps/admin/receptionist/viewbyid/${id}`)
    setRecep(result.data)
  }

  return (
    <div className="container">
      <div className="col-md-4 offset-md-4 border rounded p-4 mt-4 shadow" align='center'>
        <h3 className="text-center m-4" >Receptionist Details</h3>

        <div className='card'>
          <div className='card-header'>
            Details of Receptionist id : {recep.receptionistId}
            <ul className='list-group list-group-flush' >
              <li className='list-group-item'>
                <b>Department :</b>
                {recep.deptName}
              </li>
              <li className='list-group-item'>
                <b>Name :</b>
                {recep.receptionistName}
              </li>
              <li className='list-group-item'>
                <b>E-mail :</b>
                {recep.receptionistEmail}
              </li>
              <li className='list-group-item'>
                <b>Salary :</b>
                {recep.receptionistSalary}
              </li>
              <li className='list-group-item'>
                <b>Shift Timings :</b>
                {recep.receptionistTimings}
              </li>
              <li className='list-group-item'>
                <b>Joining Date :</b>
                {recep.dateOfJoining}
              </li>
            </ul>
          </div>
        </div>
        <Link className='btn btn-primary my-2' to={"/admin/receptionist"}>Back</Link>
      </div>
    </div>
  )
}
