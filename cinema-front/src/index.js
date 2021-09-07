import React from "react";
import ReactDOM from "react-dom";
import { Route, Link, HashRouter as Router, Switch, Redirect } from "react-router-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Login from "./components/authorization/Login";
import { logout } from "./services/Auth";
import { Button, Container, Nav, Navbar } from "react-bootstrap";
import Movies from "./components/movies/Movies";
import AddMovie from "./components/movies/AddMovie";


class App extends React.Component {

    constructor() {
        super();
        this.state = {
            selectedMovie: ""
        }
    }

    changeSelectedMovie(movie) {
        this.setState({selectedMovie: movie});
    }
    
    render() {

        const jwt = window.localStorage['jwt'];
        console.log(jwt);
        if(jwt){
            return (
                <div>
                    <Router>
                        <Navbar expand bg="dark" variant="dark">
                            <Navbar.Brand as={Link} to="/">
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
                                <Route exact path="/movies" render={(props) => <Movies {...props} selectMovie = {(movie) => {this.changeSelectedMovie(movie)}}/>}/>
                                <Route exact path="/movies/add" render={(props) => <AddMovie {...props} deleteMovie = {(movie) => {this.changeSelectedMovie(movie)}}
                                selectedMovie = {this.state.selectedMovie} />}/>
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
                            <Route render={()=> <Redirect to="/login"/>}/>
                        </Switch>
                    </Router>
                </Container>
            )
        }

    }
}

ReactDOM.render(<App/>, document.querySelector("#root"));
