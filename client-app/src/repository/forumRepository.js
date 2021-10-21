import axios from "../custom-axios/axios";
import {forumPageUrl} from "../util/constants";

export const forumRepository = {

    fetchAllQuestions: () => {
        return axios.get(forumPageUrl);
    },

    fetchAllAnswersByQuestion: () => {
        return axios.get(forumPageUrl + "/answers");
    },

    findQuestionById: (id) => {
        return axios.get(forumPageUrl + `/${id}`)
    },

    createQuestion: (title, description,userId) => {
        console.log(title,description,userId);
        return axios.post(forumPageUrl + "/createQuestion", {
            answerList:[],
            description: description,
            title: title,
            userId: userId
        })
    },

    deleteQuestion: (id) => {
        return axios.delete(forumPageUrl+`/deleteQuestion/${id}`,{
            headers:{
                "Authentication":"Bearer "+localStorage.getItem("token")
            }
        })
    },

    createAnswer: (questionId,description) => {
        return axios.post(forumPageUrl+`/createAnswer`, {
            questionId:questionId,
            answerForm: {
                description: description
            }
        },{
            headers:{
                "Authentication":"Bearer "+localStorage.getItem("token")
            }
        })
    },

    deleteAnswer: (questionId,answerId) => {
        return axios.delete(forumPageUrl+`/deleteAnswer/${questionId}/${answerId}`,{
            headers:{
                "Authentication":"Bearer "+localStorage.getItem("token")
            }
        });
    }

}