import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';

export default function UpdateDoctor() {

  let navigate = useNavigate();

  const { id } = useParams();

  const [doc, setDoc] = useState({
    docName: "",
    docEmail: "",
    speciality: "",
    experience: "",
    designation: "",
    fees: "",
    timings: "",
    docSalary: ""
  });

  const { docName, docEmail, speciality, experience, designation, fees, timings, docSalary } = doc;

  const onInputChange = (e) => {
    setDoc({ ...doc, [e.target.name]: e.target.value })
  };

  useEffect(() => {
    loadDoc();
  }, []);

  const onSubmit = async(e)=> {
    e.preventDefault();
    await axios.put(`http://localhost:8192/medicorps/admin/doctor/update/${id}`, doc)
    navigate("/admin/doctor");
  };

  const loadDoc = async()=> {
    const result = await axios.get(`http://localhost:8192/medicorps/admin/doctor/viewbyid/${id}`);
    setDoc(result.data);
  }

  return (
    <div>
      <div className="container mt-5">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-4 shadow">
          <h3 className="text-center m-4">Edit Doctor</h3>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">Name</label>
              <input type={"text"} className="form-control"
                placeholder="Enter your name" name="docName" value={docName}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                E-mail</label>
              <input type={"email"} className="form-control" placeholder="Enter e-mail address"
                name="docEmail" value={docEmail}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Speciality" className="form-label">
                Speciality</label>
              <input type={"text"} className="form-control"
                placeholder="Enter Doctor's Speciality" name="speciality" value={speciality}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Designation" className="form-label">
                Designation</label>
              <input type={"text"} className="form-control"
                placeholder="Enter designation" name="designation" value={designation}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Experience" className="form-label">
                Experience</label>
              <input type={"number"} className="form-control"
                placeholder="Enter years of experience" name="experience" value={experience}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Fees" className="form-label">
                Charges</label>
              <input type={"number"} className="form-control"
                placeholder="Enter doctor fees" name="fees" value={fees}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Timings" className="form-label">
                Timings</label>
              <input type={"text"} className="form-control"
                placeholder="Enter timings" name="timings" value={timings}
                onChange={(e) => onInputChange(e)} />
            </div>
            <div className="mb-3">
              <label htmlFor="Salary" className="form-label">
                Salary</label>
              <input type={"number"} className="form-control"
                placeholder="Enter Salary" name="docSalary" value={docSalary}
                onChange={(e) => onInputChange(e)} />
            </div>
            <button type='submit' className='btn btn-outline-primary'>Submit</button>
            <Link className='btn btn-outline-danger mx-2' to={"/admin/doctor"}>Cancel</Link>
          </form>
        </div>
      </div>
    </div>
  )
}
