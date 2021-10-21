import React, {useState} from "react";
import "./Forum.css";
import AddQuestion from "./questions/AddQuestion";
import {Link} from "react-router-dom";
import {userRepository} from "../../../repository/userRepository";
import {User} from "./User";


const Forum = (props) => {

    const [user,setUser] = useState();

    //if you are logged show the Ask question button otherwise don't show it
    const showButtonAskQuestion = () => {
        let token = localStorage.getItem("token");
        if (token) {
            return (
                <div className="d-flex">
                    <div className="ms-5">
                        <Link className="btn btn-primary" to={"/addQuestion"}>Add new Question</Link>
                    </div>
                </div>
            )
        }
    }

    // const getUser = async (userId) => {
    //     let result;
    //     await userRepository.getUserById(userId).then(data => {
    //         result = data.data;
    //     });
    //     return await result;
    // }

    //Posted by: {JSON.parse(localStorage.getItem("user")).username}
    return (
        <div className="d-flex pt-5 mt-5">
            {showButtonAskQuestion()}
            {/* List of questions asked on forum */}
            <div className="d-flex flex-column w-75 m-auto">
                {props.questions.map(question => {
                    return (

                        <div className="d-flex shadow-lg p-3 mb-5 bg-body rounded w-75 m-auto" key={question.id.id}>
                            <div className="d-flex">
                                <img src={"/favicon.ico"} className="image"/>
                            </div>
                            <div className="d-flex flex-column ps-3 pe-3 w-100">
                                <div className="border-bottom">
                                    <h4>{question.title}</h4>
                                </div>
                                <div>
                                    <p>{question.description}</p>
                                </div>
                                <div className={"small text-secondary"}>
                                    Date created: {question.dateCreated}
                                </div>
                            </div>
                            <div className="d-flex flex-column justify-content-center">
                                <button className="btn btn-outline-danger"
                                        onClick={() => props.deleteQuestion(question.id.id)}>
                                    Delete
                                </button>
                            </div>
                        </div>
                    )
                })}

            </div>
        </div>
    )
}

export default Forum;