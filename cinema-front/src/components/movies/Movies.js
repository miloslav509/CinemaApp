import React from 'react';
import { Button, Table } from 'react-bootstrap';
import CinemaAxios from './../../apis/CinemaAxios'

class Movies extends React.Component {

    constructor(props) {
        super(props);
        this.functionForMovieEdit = props.selectMovie;

        this.state = { movies: []};
    }

    componentDidMount() {
        this.getMovies();
    }

    getMovies() {
        CinemaAxios.get('/filmovi')
            .then(res => {
                console.log(res);
                this.setState({movies: res.data});
            })
            .catch(error =>{
                console.log(error);
                alert('Error occured please try again');
            });
    }

    getGenresString(map) {
        return Object.values(map).join(",");
    }

    goToEdit(id) {
        this.functionForMovieEdit(this.state.movies.find(movie => movie.id == id));
        this.props.history.push('/movies/add');
    }

    goToAdd() {
        this.props.history.push('movies/add');
    }

    delete(id) {
        CinemaAxios.delete('/filmovi' + id)
            .then(res => {
                console.log(res);
                alert('Movies was deleted succesfully');
                window.location.reload();
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again');
            })
    }



    renderMovies() {
        return this.state.movies.map((movie, index) => {
            return (
                <tr key={movie.id}>
                    <td>{movie.naziv}</td>
                    <td>{movie.trajanje}</td>
                    <td>{movie.reziser}</td>
                    <td>{movie.godinaProizvodnje}</td>
                    <td>{this.getGenresString(movie.zanrovi)}</td>
                    <td>{movie.opis}</td>
                    {window.localStorage['role'] == 'ROLE_ADMIN'?
                    [<td><Button variant="warning" onClick = {() => this.goToEdit(movie.id) } >Edit</Button></td>,
                    <td><Button variant="danger" onClick = {() => this.delete(movie.id) } >Delete</Button></td> ]
                    : null}
                </tr>
            )
        })
    }

    render() {
        return (
            <div>
                <h1>Movies</h1>

                <div>
                    {window.localStorage['role'] == 'ROLE_ADMIN'?
                    <Button onClick={() => this.goToAdd() }>Add</Button>: null}
                    <br/>
                    <Table id="movies-table" style={{margin:5}}>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Duration(min)</th>
                                <th>Director</th>
                                <th>Year</th>
                                <th>Genres</th>
                                <th>Description</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderMovies()}
                        </tbody>
                    </Table>
                </div>
            </div>
        )
    }

}

export default Movies;