import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddDepartment() {

    let navigate = useNavigate();

    const [dept , setDept] = useState({
        deptName:""
    })

    const {deptName} = dept;

    const onInputChange=(e)=>{
        setDept({ ...dept, deptName: e.target.value });
    };

    const onSubmit = async (e)=>{
        e.preventDefault();
        await axios.post("http://localhost:8192/medicorps/admin/department/add",dept)
        navigate("/admin/department");
    }

    return (
        <div className="container">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h3 className="text-center m-4">Add Department</h3>
                <form onSubmit={(e) => onSubmit(e)}>
                    <div className="mb-3">
                        <label htmlFor="Name" className="form-label">
                            Department Name
                        </label>
                        <input type={"text"} required className="form-control"
                            placeholder="Enter Department name" name="name" value={deptName}
                            onChange={(e) => onInputChange(e)} />
                    </div>
                    <button type='submit' className='btn btn-outline-primary'>Submit</button>
                    <Link className='btn btn-outline-danger mx-2' to={"/admin/department"}>Cancel</Link>
                </form>
            </div>
        </div>
    )
}
