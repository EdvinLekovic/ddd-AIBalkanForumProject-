import React from "react";
import {Link, useHistory} from "react-router-dom";
import * as constants from "constants";

const AddQuestion = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        title: "",
        description: "",
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = async (e) => {
        e.preventDefault();
        const title = formData.title;
        const description = formData.description;
        const user = JSON.parse(localStorage.getItem("user"));
        console.log("here");
        props.addQuestion(title, description, user.id.id);
        history.push("/forum");
    }


    return (


        <form className={"mt-5"} onSubmit={onFormSubmit}>
            <div className={"pt-5"} id="exampleModal" tabIndex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="exampleModalLabel">Ask question</h5>
                            <Link type="button" className="btn-close" data-bs-dismiss="modal"
                                  aria-label="Close" to={"/forum"}></Link>
                        </div>
                        <div className="modal-body">
                            <div>
                                <div className="mb-3">
                                    <label htmlFor="recipient-name" className="col-form-label">Title</label>
                                    <input type="text"
                                           name={"title"}
                                           className="form-control"
                                           id="title"
                                           onChange={handleChange}/>
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="message-text" className="col-form-label">Question here</label>
                                    <textarea
                                        className="form-control"
                                        id="description"
                                        name={"description"}
                                        onChange={handleChange}
                                        style={{height: "200px"}}/>
                                </div>
                            </div>
                        </div>
                        <div className="modal-footer">
                            <Link type="button" className="btn btn-secondary" data-bs-dismiss="modal"
                                  to={"/forum"}>Close
                            </Link>
                            <button type="submit" className="btn btn-primary">Post</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    )

}

export default AddQuestion;