import React from 'react';
import {Link} from 'react-router-dom';
import {useHistory} from 'react-router-dom';

const Login = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        username: "",
        password: ""
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

        props.onLogin(username, password);
        history.push("/books");
    }

    return (
        <div>
            <form onSubmit={onFormSubmit}>
                <div className="mb-3 w-25">
                    <label htmlFor="username" className="form-label">Username</label>
                    <input type="text"
                           className="form-control"
                           id="username"
                           name="username"
                           required
                           onChange={handleChange}/>
                </div>
                <div className="mb-3 w-25">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password"
                           className="form-control"
                           id="password"
                           name="password"
                           required
                           onChange={handleChange}/>
                </div>

                <button type="submit" className="btn btn-success mb-3 w-25">Submit</button>

            </form>

            <Link className={"btn btn-warning w-25"} to={"/register"}>Register</Link>

        </div>
    )
}


export default Login;