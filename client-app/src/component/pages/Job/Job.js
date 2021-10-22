import React from "react";
import {Link} from "react-router-dom";

export const Job = (props) => {

    const showButtonAddJob = () => {
        let user = localStorage.getItem("user");
        if (user) {
            return (
                <div className="d-flex">
                    <div className="ms-5">
                        <Link className="btn btn-primary" to={"/addJob"}>Add new Job</Link>
                    </div>
                </div>
            )
        }
    }


    return (
        <div className="d-flex pt-5 mt-5">

            {showButtonAddJob()}
            <div className="d-flex flex-column w-75 m-auto">
                {/* List available jobs*/}
                {props.jobs.map(job => {
                    return (
                        <div className="d-flex shadow-lg p-3 mb-5 bg-body rounded w-75 m-auto">
                            <div className="d-flex">
                                <Link className={"text-dark text-decoration-none"}
                                      to={"/jobs"}>
                                    <img src={"/favicon.ico"} className="image"/>
                                </Link>
                            </div>
                            <div className="d-flex flex-column ps-3 pe-3 w-100">
                                <div className="border-bottom ">
                                    <div className={"small text-secondary"}>
                                        Published by: {job.company.companyName}
                                    </div>
                                    <Link className={"text-dark text-decoration-none"}
                                          to={"/jobs"}>
                                        <h4>{job.category.categoryName}</h4>
                                    </Link>
                                </div>
                                <div>
                                    <Link className={"text-dark text-decoration-none"}
                                          to={"/jobs"}>
                                        <p>{job.description}</p>
                                    </Link>

                                </div>
                                <div className={"small text-secondary"}>
                                    Date created: {job.dateCreated}
                                </div>
                                <div className={"small text-secondary"}>
                                    Location: {job.location.countryAndCity}
                                </div>
                            </div>
                            {props.showDeleteJobButton(job)}
                        </div>

                    )
                })}
            </div>
        </div>
    )


}