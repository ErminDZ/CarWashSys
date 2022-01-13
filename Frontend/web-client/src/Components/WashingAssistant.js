import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const WashingAssistant = () => {
    const [washingassistantList, setWashingAssistantList] = useState([]);
    useEffect(() => {
        facade.fetchData("washingassistant")
            .then(data => {
                setWashingAssistantList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List Of Washing Assistant</h2>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>primary Language</th>
                    <th>years of Experience</th>
                    <th>price Pr. Hour</th>
                </tr>
                </thead>
                <tbody>
                {
                    washingassistantList.map((washingassistant, index) => (
                        <tr>
                            <td>{washingassistant.id}</td>
                            <td>{washingassistant.name}</td>
                            <td>{washingassistant.primaryLanguage}</td>
                            <td>{washingassistant.yearsOfExperience}</td>
                            <td>{washingassistant.pricePrHour}</td>

                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )

}

export default WashingAssistant;