import React from "react";

export const User = (props) => {

    const getUser =  async () => {
        let data =  await props.user;
        console.log(data);
        return data;
    }

    const loadUser = async () => {
        console.log("loadUser");
        return await getUser();
    }

    let user = loadUser();


    return (
        <div className={"small text-secondary"}>
            Posted by: {user.username}
        </div>
    )
}