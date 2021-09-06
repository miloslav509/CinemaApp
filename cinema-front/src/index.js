import React from "react";
import ReactDOM from "react-dom";
import { Route, Link, HashRouter as Router, Switch, Redirect } from "react-router-dom";
import { Navbar, Nav, Container, Button } from "react-bootstrap";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Login from "./components/authorization/Login";
import { logout } from "./services/Auth";

class App extends React.Component {
    
    render() {

        const jwt = window.localStorage['jwt'];
        
        if(jwt){
            return (
                <div>
                    <Router>
                        <Navbar expand bg="dark" variant="dark">
                            <Navbar.Brand as={Link} onTouchCancel="/">
                                JWD
                            </Navbar.Brand>
                            <Nav>
                                <Nav.Link as={Link} to="/movies">
                                    Movies
                                </Nav.Link>
                                <Nav.Link as={Link} to="/projections">
                                    Projections
                                </Nav.Link>
                                <Button onClick={()=>logout()}>Logout</Button>
                            </Nav>
                        </Navbar>
                        <Container style={{paddingTop:"25px"}}>
                            <Switch>
                                <Route exact path="/" component={Home}/>
                                <Route exact path="/login" render={()=> <Redirect to="/movies"/>}/>
                                <Route component={NotFound}/>
                            </Switch>
                        </Container>
                    </Router>
                </div>
            );
        } else {
            return (
                <Container>
                    <Router>
                        <Switch>
                            <Route exact path="/login" component={Login}/>
                            <Route rende={()=> <Redirect to="/login"/>}/>
                        </Switch>
                    </Router>
                </Container>
            )
        }

    }
}

ReactDOM.render(<App/>, document.querySelector("#root"));
