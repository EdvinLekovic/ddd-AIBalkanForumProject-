import axios from "../custom-axios/axios";
import {jobPageUrl} from "../util/constants";

export const jobRepository = {

    fetchAllJobs: () => {
        return axios.get(jobPageUrl);
    },

    getJobById: (id) => {
        return axios.get(jobPageUrl + `/${id}`)
    },

    addJob: (jobType,
             description,
             knowledgeSkillsAndAbilities,
             experience,
             salary,
             deadlineApply,
             location,
             category,
             company,
             userId) => {
        return axios.post(jobPageUrl+"/addJob", {
            jobType: jobType,
            description: description,
            knowledgeSkillsAndAbilities: knowledgeSkillsAndAbilities,
            experience: experience,
            salary: salary,
            deadlineApply: deadlineApply,
            userId:userId,
            location: {
                countryAndCity: location
            },
            category: {
                categoryName: category
            },
            company: {
                companyName: company
            }
        })
    },

    deleteJob: (jobId) => {
        return axios.delete(jobPageUrl+`/deleteJob/${jobId}`);
    }

}