import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function AddReceptionist() {

  let navigate = useNavigate();

  const [recep, setRecep] = useState({
    receptionistName: "",
    receptionistEmail: "",
    receptionistSalary: "",
    receptionistTimings: ""
  })

  const [department, setDepartment] = useState([]);
  const [selectedDeptId, setSelectedDeptId] = useState('');

  useEffect(() => {
    loadDept();
  }, [])

  const loadDept = async () => {
    const result = await axios.get("http://localhost:8192/medicorps/admin/department/viewall");
    setDepartment(result.data);
  }

  const { receptionistName, receptionistEmail, receptionistSalary, receptionistTimings } = recep;

  const onInputChange = (e) => {
    setRecep({ ...recep, [e.target.name]: e.target.value })
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post(`http://localhost:8192/medicorps/admin/receptionist/add/${selectedDeptId}`, recep);
    navigate("/admin/receptionist");
  }

  return (
    <div>
      <div className="container mt-5">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-4 shadow">
          <h3 className="text-center m-4">Add Receptionist</h3>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">Name</label>
              <input type={"text"} className="form-control"
                placeholder="Enter your name" name="receptionistName" value={receptionistName}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                E-mail</label>
              <input type={"email"} className="form-control" placeholder="Enter e-mail address"
                name="receptionistEmail" value={receptionistEmail}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Salary" className="form-label">
                Salary</label>
              <input type={"number"} className="form-control" placeholder="Enter Salary"
                name="receptionistSalary" value={receptionistSalary}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Timings" className="form-label">
                Timings</label>
              <input type={"text"} className="form-control" placeholder="Enter Shift Timings"
                name="receptionistTimings" value={receptionistTimings}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="department" className="form-label">
                Department
              </label>
              <select
                className="form-control"
                name="department"
                value={selectedDeptId}
                onChange={(e) => setSelectedDeptId(e.target.value)}
              >
                <option value="">Select department</option>
                {department.map((dept) => (
                  <option key={dept.deptId} value={dept.deptId}>
                    {dept.deptName}
                  </option>
                ))}
              </select>
            </div>
            <button type='submit' className='btn btn-outline-primary'>Submit</button>
            <Link className='btn btn-outline-danger mx-2' to={"/admin/receptionist"}>Cancel</Link>
          </form>
        </div>
      </div>
    </div>
  )
}
