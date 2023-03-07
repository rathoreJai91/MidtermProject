import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

export default function UpdateTest() {

    let navigate = useNavigate();

    const { id } = useParams();

    const [test, setTest] = useState({
        testName: "",
        testCost: ""
    });

    const { testName, testCost } = test;

    const onInputChange = (e) => {
        setTest({ ...test, [e.target.name]: e.target.value })
    };

    useEffect(() => {
        loadTest();
    }, []);

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put(`http://localhost:8192/medicorps/admin/testlist/update/${id}`, test);
        navigate("/admin/lab");
    }

    const loadTest = async () => {
        const result = await axios.get(`http://localhost:8192/medicorps/admin/testlist/viewbyid/${id}`);
        setTest(result.data);
    }


    return (
        <div className="container mt-5">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-4 shadow">
                <h3 className="text-center m-4">Update Test</h3>
                <form onSubmit={(e) => onSubmit(e)}>
                    <div className="mb-3">
                        <label htmlFor="Name" className="form-label">Name</label>
                        <input type={"text"} className="form-control"
                            placeholder="Enter test name" name="testName" value={testName}
                            onChange={(e) => onInputChange(e)} />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Cost" className="form-label">Charges</label>
                        <input type={"number"} className="form-control"
                            placeholder="Enter Test Cost" name="testCost" value={testCost}
                            onChange={(e) => onInputChange(e)} />
                    </div>
                    <button type='submit' className='btn btn-outline-primary'>Submit</button>
                    <Link className='btn btn-outline-danger mx-2' to={"/admin/lab"}>Cancel</Link>
                </form>
            </div>
        </div>
    )
}
