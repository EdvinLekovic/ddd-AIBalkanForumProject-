import React, {useState} from "react";
import "./Forum.css";
import {Link} from "react-router-dom";



const Forum = (props) => {

    //if you are logged show the Ask question button otherwise don't show it
    const showButtonAskQuestion = () => {
        let user = localStorage.getItem("user");
        if (user) {
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
                        <div className="d-flex shadow-lg p-3 mb-5 bg-body rounded w-75 m-auto"
                             key={question.id.id}>
                            <div className="d-flex">
                                <Link className={"text-dark text-decoration-none"}
                                      onClick={() => props.getQuestion(question.id.id)}
                                      to={`/questionInfo/${question.id.id}`}>
                                <img src={"/favicon.ico"} className="image"/>
                                </Link>
                            </div>
                            <div className="d-flex flex-column ps-3 pe-3 w-100">
                                <div className="border-bottom ">
                                    <Link className={"text-dark text-decoration-none"}
                                          onClick={() => props.getQuestion(question.id.id)}
                                          to={`/questionInfo/${question.id.id}`}>
                                        <h4>{question.title}</h4>
                                    </Link>
                                </div>
                                <div>
                                    <Link className={"text-dark text-decoration-none"}
                                          onClick={() => props.getQuestion(question.id.id)}
                                          to={`/questionInfo/${question.id.id}`}>
                                        <p>{question.description}</p>
                                    </Link>

                                </div>
                                <div className={"small text-secondary"}>
                                    Date created: {question.dateCreated}
                                </div>
                            </div>
                            {props.showQuestionDeleteButton(question)}
                        </div>
                    )
                })}

            </div>
        </div>
    )
}

export default Forum;