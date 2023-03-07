import React from 'react'
import { Link } from 'react-router-dom';
import logo from '../../logo.png'

export default function AdminNavbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary bg-dark navbar-dark fixed-top" >
        <div className="container-fluid">
          <Link className="navbar-brand" to={"/"}>
            <img src={logo} alt="Medicorps" width="50" height="35" />
            MediCorp's
          </Link>
          <div>
            <Link className='btn btn-outline-warning mx-2' to={'/admin/department'} >Department</Link>
            <Link className='btn btn-outline-danger mx-2' to={'/admin/doctor'}>Doctors</Link>
            <Link className='btn btn-outline-warning mx-2' to={'/admin/receptionist'}>Receptionists</Link>
            <Link className='btn btn-outline-danger mx-2' to={'/admin/lab'} >Lab</Link>
            <Link className='btn btn-outline-warning mx-2' to={'/admin/staff'} >Staff</Link>
            <Link className="btn btn-outline-danger mx-2">Logout</Link>
          </div>

        </div>
      </nav>
    </div>
  )
}
