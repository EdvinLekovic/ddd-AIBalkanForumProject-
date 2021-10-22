import './App.css';
import React, {Component} from "react";
import {Redirect, Route, BrowserRouter as Router, Link} from "react-router-dom";
import Header from "../UI/Header/Header";
import Forum from '../pages/Forum/Forum'
import Register from '../pages/Authentication/Register'
import Login from "../pages/Authentication/Login";
import Home from "../pages/Home/Home";
import {userRepository} from "../../repository/userRepository";
import AddQuestion from "../pages/Forum/questions/AddQuestion";
import {forumRepository} from "../../repository/forumRepository";
import {QuestionInfo} from "../pages/Forum/questions/QuestionInfo";
import {AddAnswer} from "../pages/Forum/questions/answer/AddAnswer";
import {jobRepository} from "../../repository/jobRepository";
import {Job} from "../pages/Job/Job";
import {AddJob} from "../pages/Job/AddJob/AddJob";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            questions: [],
            answers: [],
            question: {},
            jobs: [],
            job: {}
        }
    }


    render() {
        return (
            <Router>
                <Header/>
                <div>
                    <Route path={"/forum"} exact render={() =>
                        <Forum questions={this.state.questions}
                               showQuestionDeleteButton={this.showQuestionDeleteButton}
                               getUser={this.getUserById}
                               deleteQuestion={this.deleteQuestion}
                               getQuestion={this.getQuestion}/>}/>
                    <Route path={"/register"} exact render={() => <Register/>}/>
                    <Route path={"/login"} exact render={() => <Login/>}/>
                    <Route path={"/"} exact render={() => <Home/>}/>
                    <Route
                        path={"/addQuestion"}
                        exact
                        render={() =>
                            <AddQuestion addQuestion={this.addQuestion}/>}/>
                    <Route path={"/questionInfo/:id"} exact render={() =>
                        <QuestionInfo
                            question={this.state.question}
                            showQuestionDeleteButton={this.showQuestionDeleteButton}
                            showAnswerDeleteButton={this.showAnswerDeleteButton}
                            showReplyButton={this.showReplyButton}
                            getQuestion={this.getQuestion}/>}/>

                    <Route path={"/addAnswer"}
                           exact
                           render={() => <AddAnswer addAnswer={this.addAnswer}
                                                    question={this.state.question}/>}/>
                    <Route path={"/jobs"}
                           exact
                           render={() => <Job jobs={this.state.jobs}
                                              showDeleteJobButton={this.showDeleteJobButton}/>}/>
                    <Route path={"/addJob"}
                           exact
                           render={() => <AddJob addJob={this.addJob}/>}/>
                    {/*<Redirect to={"/forum"}/>*/}
                </div>
            </Router>
        )
    }

    checkIfUserIsValid = async () => {

        let token = localStorage.getItem("token");
        //if the token exist check the validity of the token
        if (token) {
            let validity = await userRepository.checkUserValidity(token);
            //if the validity is ok fetch the logged user into app
            if (validity) {
                userRepository.getUserByToken()
                    .then(data => {
                        let userStringify = JSON.stringify(data.data);
                        localStorage.setItem("user", userStringify);
                    })
            } else {
                localStorage.removeItem("token");
                this.setState({
                    user: {}
                })
            }
        }
    }

    componentDidMount() {
        //check if user is valid every 10 hours
        this.loadQuestions();
        this.loadJobs();
        setInterval(this.checkIfUserIsValid, 1000 * 60 * 60 * 10);
    }

    loadQuestions = () => {
        forumRepository.fetchAllQuestions()
            .then(data => {
                this.setState({
                    questions: data.data
                })
            });
    }

    addQuestion = (title, description, userId) => {
        forumRepository.createQuestion(title, description, userId)
            .then(() => {
                this.loadQuestions();
            })
    }

    deleteQuestion = (questionId) => {
        forumRepository.deleteQuestion(questionId)
            .then(() => this.loadQuestions())
    }

    getQuestion = async (questionId) => {
        await forumRepository.findQuestionById(questionId)
            .then(data => {
                this.setState({
                    question: data.data
                })
            })
    }

    showQuestionDeleteButton = (question) => {
        let user = JSON.parse(localStorage.getItem("user"));
        if (user?.id?.id === question?.userId?.id) {
            return (
                <div className="d-flex flex-column justify-content-center">
                    <Link className="btn btn-outline-danger"
                          onClick={() => this.deleteQuestion(question.id.id)}
                          to={"/forum"}>
                        Delete
                    </Link>
                </div>
            )
        }
    }

    addAnswer = (description, questionId, userId) => {
        forumRepository.createAnswer(description, questionId, userId)
            .then(() => this.getQuestion(questionId));
    }

    deleteAnswer = (questionId, answerId) => {
        console.log(questionId, answerId);
        forumRepository.deleteAnswer(questionId, answerId)
            .then(() => this.getQuestion(questionId));
    }

    showAnswerDeleteButton = (question, answer) => {
        let user = JSON.parse(localStorage.getItem("user"));

        if (user?.id?.id === answer.userId.id || user?.id?.id === question.userId.id) {
            return (
                <div className="d-flex flex-column justify-content-center">
                    <button className="btn btn-outline-danger"
                            onClick={() => this.deleteAnswer(question.id.id, answer.id.id)}>
                        Delete
                    </button>
                </div>
            )
        }
    }

    showReplyButton = (question) => {
        let user = JSON.parse(localStorage.getItem("user"));
        if (user) {
            return (
                <div>
                    <Link className={"btn btn-secondary"}
                          onClick={() => this.getQuestion(question.id.id)}
                          to={"/addAnswer"}>Reply</Link>
                </div>
            )
        }
    }

    getUserById = async (userId) => {
        console.log("getUserId App");
        return (await userRepository.getUserById(userId)).data;
    }

    loadJobs = () => {
        jobRepository.fetchAllJobs()
            .then(data => {
                this.setState({
                    jobs: data.data
                })
            })
    }

    getJob = (jobId) => {
        jobRepository.getJobById(jobId).then(data => {
            this.setState({
                job: data.data
            })
        });
    }

    addJob = (jobType,
              description,
              knowledgeSkillsAndAbilities,
              experience,
              salary,
              deadlineApply,
              location,
              category,
              company,
              userId) => {
        jobRepository.addJob(jobType,
            description,
            knowledgeSkillsAndAbilities,
            experience,
            salary,
            deadlineApply,
            location,
            category,
            company,
            userId)
            .then(() => this.loadJobs());
    }

    deleteJob = (jobId) => {
        jobRepository.deleteJob(jobId)
            .then(() => this.loadJobs());
    }

    showDeleteJobButton = (job) => {
        let user = JSON.parse(localStorage.getItem("user"));

        if (user?.id?.id === job.userId.id) {
            return (
                <div className="d-flex flex-column justify-content-center">
                    <button className="btn btn-outline-danger"
                            onClick={() => this.deleteJob(job.id.id)}>
                        Delete
                    </button>
                </div>
            )
        }
    }


}

export default App;
