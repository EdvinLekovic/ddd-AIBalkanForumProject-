import React, {useState} from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css"
import {useHistory} from "react-router-dom";

export const AddJob = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        company: "",
        category: "",
        jobType: "",
        salary: "",
        location: "",
        description: "",
        knowledgeSkillsAndAbilities: "",
        experience: "",
        deadlineApply: ""
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = async (e) => {
        e.preventDefault();
        const company = formData.company;
        const category = formData.category;
        const jobType = formData.jobType;
        const salary = formData.salary;
        const location = formData.location;
        const description = formData.description;
        const knowledgeSkillsAndAbilities = formData.knowledgeSkillsAndAbilities;
        const experience = formData.experience;
        const deadlineApply = startDate;
        const user = JSON.parse(localStorage.getItem("user"));
        console.log("here");
        props.addJob(jobType,
            description,
            knowledgeSkillsAndAbilities,
            experience,
            salary,
            deadlineApply,
            location,
            category,
            company,
            user.id);
        history.push("/jobs");
    }

    const [startDate, setStartDate] = useState(new Date());

    return (
        <form className={"m-5"} onSubmit={onFormSubmit}>
            <div className={"d-flex flex-column mt-5 pt-5  justify-content-center"}>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Company:</label>
                    <select type={"text"}
                            id={"company"}
                            name={"company"}
                            defaultValue={"Netcetera"}
                            required
                            onChange={handleChange}
                            className={"d-flex form-control w-25"}>
                        <option value={"Netcetera"}>Netcetera</option>
                        <option value={"Endava"}>Endava</option>
                        <option value={"Google"}>Google</option>
                        <option value={"Facebook"}>Facebook</option>
                    </select>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Category:</label>
                    <select type={"text"}
                            id={"category"}
                            name={"category"}
                            defaultValue={"Data Science"}
                            required
                            onChange={handleChange}
                            className={"d-flex form-control w-25"}>
                        <option value={"Data Science"}>Data Science</option>
                        <option value={"Machine learning"}>Machine learning</option>
                        <option value={"Deep learning"}>Deep Learning</option>
                    </select>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Job Type:</label>
                    <select type={"text"}
                            className={"form-control w-25"}
                            id={"jobType"}
                            defaultValue={"FULL_TIME"}
                            required
                            onChange={handleChange}
                            name={"jobType"}>
                        <option value={"FULL_TIME"}>FULL_TIME</option>
                        <option value={"PART_TIME"}>PART_TIME</option>
                        <option value={"REMOTE"}>REMOTE</option>
                        <option value={"FREELANCE"}>FREELANCE</option>
                    </select>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Salary:</label>
                    <input type={"text"}
                           id={"salary"}
                           required
                           onChange={handleChange}
                           name={"salary"}
                           className={"d-flex form-control w-25"}
                           placeholder={"Salary"}/>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Location:</label>
                    <select type={"text"}
                            id={"location"}
                            required
                            defaultValue={"North Macedonia, Skopje SKP"}
                            onChange={handleChange}
                            name={"location"}
                            className={"d-flex form-control w-25"}>
                        <option value={"North Macedonia, Skopje SKP"}>North Macedonia, Skopje SKP</option>
                        <option value={"USA, New York"}>USA, New York</option>
                        <option value={"USA, Los Angeles"}>USA, Los Angeles</option>
                        <option value={"England, London"}>England, London</option>
                    </select>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Description:</label>
                    <textarea className={"d-flex form-control w-25"}
                              id={"description"}
                              required
                              onChange={handleChange}
                              name={"description"}>
                    </textarea>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Knowledge, skills and abilities:</label>
                    <textarea className={"d-flex form-control w-25"}
                              id={"knowledgeSkillsAndAbilities"}
                              required
                              onChange={handleChange}
                              name={"knowledgeSkillsAndAbilities"}>
                    </textarea>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Experience:</label>
                    <textarea className={"d-flex form-control w-25"}
                              id={"experience"}
                              required
                              onChange={handleChange}
                              name={"experience"}>
                    </textarea>
                </div>
                <div className={"d-flex flex-column justify-content-center mt-2"}>
                    <label className={"d-flex form-label"}>Deadline apply:</label>
                    <div className={"d-flex"}>
                        <DatePicker selected={startDate} onChange={(date) => setStartDate(date)}/>
                    </div>
                </div>
            </div>
            <div className={"mt-2"}>
                <button type={"submit"} className={"btn btn-primary"}>Submit</button>
            </div>
        </form>
    )


}