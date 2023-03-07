import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewDepartment() {

  const [dept , setDept] = useState({
    deptName:"",
    noOfEmps:""
  },[])

  const {id} = useParams();

  useEffect(() => {
    loadDept();
  },[]);

  const loadDept = async ()=>{
    const result = await axios.get(`http://localhost:8192/medicorps/admin/department/viewbyid/${id}`)
    setDept(result.data);
  }

  return (
    <div className="container">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h3 className="text-center m-4">Full Department Details</h3>

            <div className='card'>
                <div className='card-header'>
                    Details of Department id :  {dept.deptId}
                    <ul className='list-group list-group-flush'>
                        <li className='list-group-item'>
                            <b>Department Name :</b>
                            {dept.deptName}
                        </li>
                        <li className='list-group-item'>
                            <b>No. of Employees :</b>
                            {dept.noOfEmps}
                        </li>
                    </ul>
                </div>
            </div>
            <Link className='btn btn-primary my-2' to={"/admin/department"}>Back</Link>
        </div>
    </div>      
  )
}
