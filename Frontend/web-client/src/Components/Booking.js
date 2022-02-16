import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const Booking = () => {
    const [bookingList, setBookingList] = useState([]);
    useEffect(() => {
        facade.fetchData("booking")
            .then(data => {
                setBookingList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List Of Bookings</h2>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>id</th>
                    <th>dateAndTime</th>
                    <th>duration</th>
                </tr>
                </thead>
                <tbody>
                {
                    bookingList.map((booking, index) => (
                        <tr>
                            <td>{booking.id}</td>
                            <td>{booking.dateAndTime}</td>
                            <td>{booking.duration}</td>

                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )

}

export default Booking;