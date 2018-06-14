import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Link, NavLink, Switch, Redirect } from 'react-router-dom';
import './index.css';
import App from './App';
import Register from './components/Register';

const App1 = () => {
    return (
        <div>
            <header>
            <NavLink to="/login">New User</NavLink><br/>  
        <Switch>
        <Route path = "/Register" component ={Register}/>
        </Switch>
            <Redirect from="/login" to="/Register"/> 
            </header>
        </div>

    )
}






ReactDOM.render(<App />, document.getElementById('root'));
