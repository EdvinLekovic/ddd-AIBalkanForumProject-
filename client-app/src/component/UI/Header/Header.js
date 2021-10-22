import React from 'react';
import {Link} from "react-router-dom";
import AuthenticationButton from "../AuthenticationButton";

class Header extends React.Component {


    constructor(props) {
        super(props);
    }

    // checkIfUserIsLogged = () => {
    //     let user = JSON.parse(localStorage.getItem("user"))
    //     if (user) {
    //         return (
    //             <form className="form-inline mt-2 mt-md-0 ml-3" onSubmit={this.logoutUser}>
    //                 <button className="btn btn-outline-info my-2 my-sm-0">Logout</button>
    //             </form>
    //         )
    //     } else {
    //         return (
    //             <form className="form-inline mt-2 mt-md-0 ml-3">
    //                 <Link className="btn btn-outline-info my-2 my-sm-0" to={"/login"}>Login</Link>
    //             </form>
    //         )
    //     }
    // }

    logoutUser = (e) => {
        e.preventDefault();
        localStorage.clear();
    }

    userInformation = () => {
        let userString = localStorage.getItem("user");
        if (userString) {
            let user = JSON.parse(userString);
            return (
                <ul className={"navbar-nav mr-auto"}>
                    <li className="nav-item active me-5">
                        <a className="nav-link float-end ">{user.username}</a>
                    </li>
                </ul>
            )
        }
    }

    render() {
        console.log("render here");
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark fixed-top">
                    <a className="navbar-brand" href="/">AIBalkanForumProject</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarCollapse"
                            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div className={"d-flex"}>
                            <ul className="navbar-nav mr-auto">
                                <li className="nav-item active">
                                    <Link className="nav-link" to={"/forum"}>Forum</Link>
                                </li>
                                <li className="nav-item active">
                                    <Link className="nav-link" to={"/jobs"}>Jobs</Link>
                                </li>
                            </ul>
                            <AuthenticationButton user={JSON.parse(localStorage.getItem("user"))}
                                                  logout={this.logoutUser}/>
                        </div>
                        
                        {this.userInformation()}
                    </div>
                </nav>
            </header>
        )
    }
}

export default Header;

