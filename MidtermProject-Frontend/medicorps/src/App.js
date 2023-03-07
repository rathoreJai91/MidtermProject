import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AdminNavbar from './components/AdminComponent/AdminNavbar';
import AdminHomepage from './components/AdminComponent/AdminHomepage';
import DepartmentPage from './components/AdminComponent/department/DepartmentPage';
import ViewDepartment from './components/AdminComponent/department/ViewDepartment';
import AddDepartment from './components/AdminComponent/department/AddDepartment';
import DoctorPage from './components/AdminComponent/doctor/DoctorPage';
import ViewDoctor from './components/AdminComponent/doctor/ViewDoctor';
import AddDoctor from './components/AdminComponent/doctor/AddDoctor';
import UpdateDoctor from './components/AdminComponent/doctor/UpdateDoctor';
import ReceptionistPage from './components/AdminComponent/receptionist/ReceptionistPage';
import ViewReceptionist from './components/AdminComponent/receptionist/ViewReceptionist';
import AddReceptionist from './components/AdminComponent/receptionist/AddReceptionist';
import UpdateReceptionist from './components/AdminComponent/receptionist/UpdateReceptionist';
import StaffPage from './components/AdminComponent/staff/StaffPage';
import ViewStaff from './components/AdminComponent/staff/ViewStaff';
import AddStaff from './components/AdminComponent/staff/AddStaff';
import UpdateStaff from './components/AdminComponent/staff/UpdateStaff';
import LabPage from './components/AdminComponent/lab/LabPage';
import AddTest from './components/AdminComponent/lab/AddTest';
import UpdateTest from './components/AdminComponent/lab/UpdateTest';

function App() {
  return (
    <div className="App">
      <Router>
        <AdminNavbar />
        <Routes> 
          {/*department*/}
          <Route exact path='/' element={<AdminHomepage/>} />
          <Route exact path='/admin/department' element={<DepartmentPage />} />
          <Route exact path='/admin/viewdepartment/:id' element={<ViewDepartment />} />
          <Route exact path='/admin/adddepartment' element={<AddDepartment />} />
         {/*Doctor*/}
          <Route exact path='/admin/doctor' element={<DoctorPage />} />
          <Route exact path='/admin/doctor/view/:id' element={<ViewDoctor />} />
          <Route exact path='/admin/doctor/add' element={<AddDoctor />} />
          <Route exact path='/admin/doctor/update/:id' element={<UpdateDoctor />} />
         {/*Receptionist*/}
          <Route exact path='/admin/receptionist' element={<ReceptionistPage />} />
          <Route exact path='/admin/receptionist/view/:id' element={<ViewReceptionist />} />
          <Route exact path='/admin/receptionist/add' element={<AddReceptionist />} />
          <Route exact path='/admin/receptionist/update/:id' element={<UpdateReceptionist />} />
         {/*Staff*/}
          <Route exact path='/admin/staff' element={<StaffPage />} />
          <Route exact path='/admin/staff/view/:id' element={<ViewStaff />} />
          <Route exact path='/admin/staff/add' element={<AddStaff />} />
          <Route exact path='/admin/staff/update/:id' element={<UpdateStaff />} />
         {/*Lab*/}
          <Route exact path='/admin/lab' element={<LabPage />} />
          <Route exact path='/admin/lab/addtest' element={<AddTest />} />
          <Route exact path='/admin/lab/updatetest/:id' element={<UpdateTest />} />
        </Routes>
      </Router>

    </div>
  );
}

export default App;
