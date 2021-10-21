import './App.css';
import {Component} from "react";
import {Redirect, Route, BrowserRouter as Router} from "react-router-dom";
import Header from "../UI/Header/Header";
import Forum from '../pages/Forum/Forum'
import Register from '../pages/Authentication/Register'
import Login from "../pages/Authentication/Login";
import Home from "../pages/Home/Home";
import {userRepository} from "../../repository/userRepository";
import AddQuestion from "../pages/Forum/questions/AddQuestion";
import {forumRepository} from "../../repository/forumRepository";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            questions:[],
            answers:[],
            users:[],
        }
    }



    render() {
        return (
            <Router>
                <Header/>
                <div>
                    <Route path={"/forum"}
                           exact
                           render={() =>
                               <Forum questions={this.state.questions}
                               getUser={this.getUserById}
                               deleteQuestion={this.deleteQuestion}/>}/>
                    <Route path={"/register"} exact render={() => <Register/>}/>
                    <Route path={"/login"} exact render={() => <Login/>}/>
                    <Route path={"/"} exact render={() => <Home/>}/>
                    <Route
                        path={"/addQuestion"}
                        exact render={() =>
                        <AddQuestion addQuestion={this.addQuestion}/>}/>
                    {/*<Redirect to={"/forum"}/>*/}
                </div>
            </Router>
        )
    }

    checkIfUserIsValid = async () => {

        let token = localStorage.getItem("token");
        //if the token exist check the validity of the token
        if(token){
            let validity = await userRepository.checkUserValidity(token);
            //if the validity is ok fetch the logged user into app
            if(validity){
                userRepository.getUserByToken()
                    .then( data => {
                        let userStringify = JSON.stringify(data.data);
                        localStorage.setItem("user",userStringify);
                })
            }
            else {
                localStorage.removeItem("token");
                this.setState({
                    user:{}
                })
            }
        }
    }

    loadQuestions = () => {
        forumRepository.fetchAllQuestions()
            .then(data => {
                this.setState({
                    questions:data.data
                })
            });
    }

    addQuestion = (title,description,userId) => {
        forumRepository.createQuestion(title,description,userId)
            .then(() => {
                this.loadQuestions();
            })
    }

    deleteQuestion = (questionId) => {
        forumRepository.deleteQuestion(questionId)
            .then(() => this.loadQuestions())
    }


    getUserById = async (userId) => {
        console.log("getUserId App");
      return (await userRepository.getUserById(userId)).data;
    }

    componentDidMount() {
        //check if user is valid every 10 hours
        this.loadQuestions();
        setInterval(this.checkIfUserIsValid,1000 * 60 * 60 * 10);
    }

}

export default App;
