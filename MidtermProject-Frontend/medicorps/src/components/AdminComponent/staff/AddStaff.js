import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function AddStaff() {

  let navigate = useNavigate();

  const [staff, setStaff] = useState({
    staffName: "",
    staffEmail: "",
    staffRole: "",
    staffTiming: "",
    staffSalary: "",
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

  const { staffName, staffEmail, staffRole, staffTiming, staffSalary } = staff;

  const onInputChange = (e) => {
    setStaff({ ...staff, [e.target.name]: e.target.value })
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post(`http://localhost:8192/medicorps/admin/staff/add/${selectedDeptId}`, staff)
    navigate("/admin/staff");
  }

  return (
    <div>
      <div className="container mt-5">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-4 shadow">
          <h3 className="text-center m-4">Add Staff</h3>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">Name</label>
              <input type={"text"} className="form-control"
                placeholder="Enter your name" name="staffName" value={staffName}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                E-mail</label>
              <input type={"email"} className="form-control" placeholder="Enter e-mail address"
                name="staffEmail" value={staffEmail}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Role" className="form-label">
                Role</label>
              <input type={"text"} className="form-control"
                placeholder="Enter Role" name="staffRole" value={staffRole}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Timings" className="form-label">
                Timings</label>
              <input type={"text"} className="form-control"
                placeholder="Enter timings" name="staffTiming" value={staffTiming}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Salary" className="form-label">
                Salary</label>
              <input type={"number"} className="form-control"
                placeholder="Enter Salary" name="staffSalary" value={staffSalary}
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
            <Link className='btn btn-outline-danger mx-2' to={"/admin/staff"}>Cancel</Link>
          </form>
        </div>
      </div>
    </div>
  )
}
