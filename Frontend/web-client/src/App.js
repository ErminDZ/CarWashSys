import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useParams,
    useRouteMatch,
    NavLink
} from "react-router-dom";

import Login from "./Components/Login";

import React, { useState,useEffect } from "react";
import facade from "./ApiFacade";
import Menu from "./Components/Menu";
import Home from "./Components/Home";

import NoMatch from "./Components/NoMatch";
import WashingAssistant from "./Components/WashingAssistant";
import Booking from "./Components/Booking";
import AddBooking from "./Components/AddBooking";



function App() {
    const [loggedIn, setLoggedIn] = useState(false)
    const [userName, setUserName] = useState("")


    const logout = () => {
        // confused on how we get this to work as it's not being called
        facade.logout()
        setLoggedIn(false)
    }

    if (logout == true) {
        return "admin has logged out"
    }

    const login = (user, pass) => {
        setUserName(user);
        facade.login(user,pass)
            .then(res =>setLoggedIn(true));
    }

    if (login === true) {
        return "admin has logged in"
    }

    return (
        <div>
            {!loggedIn ? (<Login login={login} />) : (
                <div>
                    <Menu />
                    <Switch>
                         <Route exact path="/">
                         <Home />
                         </Route>
                        <Route exact path="/washingassistant">
                            <WashingAssistant />
                        </Route>
                        <Route exact path="/booking">
                            <Booking />
                        </Route>
                        <Route exact path="/AddBooking">
                            <AddBooking />
                        </Route>
                        <NoMatch />
                    </Switch>
                </div>
            )}
        </div>
    )

}



export default App;
