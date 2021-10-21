import React from "react";
import "./Home.css"
import {Link} from "react-router-dom";

const Home = () => {

    return (
        <div className="d-flex flex-column fs-5 font">
            <div className="d-flex text-light justify-content-end pt-3 title-background"
                 style={{backgroundImage: "url(/image/ai-background.jpeg)"}}>
                <div className="d-flex w-50 text-end me-4">
                    <h1 className="d-flex display-1 fw-bold m-auto">Welcome to AIBalkanForum</h1>
                </div>
            </div>
            <div className="d-flex flex-column question-block">
                <div className="d-flex bg-light shadow-lg bg-body rounded mt-5 w-75 m-auto question-info-block">
                    <div className="d-flex flex-column justify-content-center text-center w-50">
                        <div className={"w-75 m-auto"}>
                            <p>Do you have any problem with data science, machine learning or deep learning?<br/>
                            Or you wanna help someone by answering a question?</p>
                            <p>Don't hesitate to ask a question or answer some question on our forum page</p>
                            <Link className="btn btn-outline-info my-2 my-sm-0 w-25" to={"/forum"}>Forum</Link>
                        </div>
                    </div>
                    <div className="w-50">
                        <img src={"/image/ask-question.jpg"} title={""} className={"question-image rounded-end"}/>
                    </div>
                </div>

                <div className="d-flex bg-light shadow-lg bg-body rounded w-75 m-auto question-info-block">
                    <div className="w-50">
                        <img src={"/image/ai-jobs.jpeg"} title={""} className={"question-image rounded-start"}/>
                    </div>
                    <div className="d-flex flex-column justify-content-center text-center w-50">
                        <div className={"w-75 m-auto"}>
                            <p>Are you looking for a job in AI industry? <br/>
                                You are on the right site for this
                            </p>
                            <p>See our job opportunities on our job page</p>
                            <Link className="btn btn-outline-info my-2 my-sm-0 w-25" to={"/jobs"}>Jobs</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )


}

export default Home;