import React from "react";
import {Link} from "react-router-dom";

export const QuestionInfo = (props) => {

    console.log(props.question)
    return (
        <div className="d-flex pt-5 mt-5">
            <div className="d-flex">
                <div className="ms-5">
                    <Link className="btn btn-primary" to={"/forum"}> &lt; Back</Link>
                </div>
            </div>
            <div className="d-flex flex-column w-75 m-auto">
                <div className="d-flex shadow-lg p-3 mb-5 bg-body rounded w-100">
                    <div className="d-flex">
                        <img src={"/favicon.ico"} className="image"/>
                    </div>
                    <div className="d-flex flex-column ps-3 pe-3 w-100">
                        <div className="border-bottom">
                            <h4>{props.question.title}</h4>
                        </div>
                        <div>
                            <p>{props.question.description}</p>
                        </div>
                        <div className={"small text-secondary"}>
                            Date created: {props.question.dateCreated}
                        </div>
                    </div>
                    {props?.showQuestionDeleteButton(props?.question)}
                </div>

                {props?.question?.answerList?.map(answer => {
                    return (
                        <div className="d-flex shadow-lg p-3 mb-5 bg-body rounded-pill w-50">
                            <div className="d-flex" key={answer.id.id}>
                                <img src={"/favicon.ico"} className="image"/>
                            </div>
                            <div className="d-flex flex-column ps-3 pe-3 w-100">
                                <div>
                                    <p>{answer.description}</p>
                                </div>
                                <div className={"small text-secondary"}>
                                    Date created: {answer.dateCreated}
                                </div>
                            </div>
                            {props?.showAnswerDeleteButton(props?.question,answer)}
                        </div>
                    )
                })}
                
                {props.showReplyButton(props?.question)}
            </div>

        </div>
    )
}