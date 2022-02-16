import React, {useState, useEffect} from "react";
import facade from "../ApiFacade";
import {useParams} from "react-router-dom";

const AddBooking = ({userName}) => {
    const [booking, setBooking] = useState({}); // show rating
    const [username, setUsername] = useState({}); // show username

    let {id} = useParams();

// add booking
    const addBooking = (event) => {
        event.preventDefault(); // prevent page from reloading after submitting form
        const body = {"userName": userName, "registrationNumber": id, ...booking};
        setUsername({body})
        facade.postData(body, "AddBooking").then(() => {

        })
    }

    const changeBooking = (event) => {
        event.preventDefault();
        setBooking({...booking, [event.target.id]: event.target.value});
    }

    return (

        <table className="table mt-4">

            <tbody>
            {
                <div className="addBooking">
                    <form onChange={changeBooking}>
                        <h3>test</h3>
                        <textarea name="comment" className="form-control mt-3" id="booking" cols="30" rows="10"
                                  name="booking"></textarea>
                        <button onClick={addBooking} type="submit" className="btn btn-success mt-3 float-end">Send
                        </button>
                    </form>
                </div>
            }
            </tbody>
        </table>
    )

}

export default AddBooking;