import React from 'react';
import {useHistory} from 'react-router-dom';

const Register = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        username: "",
        password: "",
        name: "",
        surname: "",
        role: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();

        const username = formData.username;
        const password = formData.password;
        const name = formData.name;
        const surname = formData.surname;
        const role = formData.role;

        if(role!=null && role!=="") {
            props.onRegister(username, password, name, surname, role);
            history.push("/login");
        }else{
            alert("Please select a role");
        }

    }

    return (
        <div className={"w-50"}>
            <form className="row g-3" onSubmit={onFormSubmit}>
                <div className="col-md-6 mb-3">
                    <label htmlFor="username" className="form-label">Username</label>
                    <input type="username"
                           className="form-control"
                           id="username"
                           name="username"
                           required
                           onChange={handleChange}/>
                </div>
                <div className="col-md-6 mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password"
                           className="form-control"
                           id="password"
                           name="password"
                           required
                           onChange={handleChange}/>
                </div>
                <div className="col-12 mb-3">
                    <label htmlFor="name" className="form-label">Name</label>
                    <input type="text"
                           className="form-control"
                           id="name"
                           placeholder="Enter your name"
                           name="name"
                           required
                           onChange={handleChange}/>
                </div>
                <div className="col-12 mb-3">
                    <label htmlFor="surname" className="form-label">Surname</label>
                    <input type="text"
                           className="form-control"
                           id="surname"
                           placeholder="Enter your surname"
                           name="surname"
                           required
                           onChange={handleChange}/>
                </div>

                <div className="col-md-4 mb-3">
                    <label htmlFor="role" className="form-label">Role</label><br/>
                    <select id="role" className="form-select" name="role" onChange={handleChange} required>
                        <option>Choose...</option>
                        <option value={"ROLE_USER"}>User</option>
                        <option value={"ROLE_LIBRARIAN"}>Librarian</option>
                    </select>
                </div>

                <div className="col-12">
                    <button type="submit" className="btn btn-success">Register</button>
                </div>
            </form>
        </div>
    );
};

export default Register;