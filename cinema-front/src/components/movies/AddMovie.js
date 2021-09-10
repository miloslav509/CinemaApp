import React from "react";
import { Button, Col, Form, InputGroup, Row } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";
import SelectGenres from "./SelectGenres";

class AddMovie extends React.Component {

    constructor(props) {
        super(props);
        const movie = this.props.selectedMovie == "" ? {
            id: -1,
            naziv: "",
            trajanje: 0,
            zanrovi: [],
            reziser: "",
            godinaProizvodnje: 0,
            opis: ""
        }: this.props.selectedMovie
        this.props.deleteMovie("");
        this.state = {
            movie: movie,
            showSelectedGenres: false
        };
        this.create = this.create.bind(this);
        this.handleGenreSelection = this.handleGenreSelection.bind(this);
    }

    componentDidMount() {
        console.log(this.state);
    }

    handleGenreSelection(selectedGenres) {
        this.setState({selectedGenres: selectedGenres});
    }

    create() {

    }

    sumarizedGenres() {

    }

    onChangeHandler(event) {
        let movie = this.state.movie;
        let id = event.target.id;

        movie[id] = event.target.value;
        this.setState({movie: movie});
        console.log(this.state);
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>{this.state.movie.id == -1 ? "Add new movie" : "Edit movie"}</h1>
                        <Form>
                            <Form.Label htmlFor="naziv">Name</Form.Label>
                            <Form.Control 
                            value={this.state.movie.naziv}
                                id="naziv"
                                type="text"
                                onChange={(e) => this.onChangeHandler(e)}
                            />
                            <Form.Label htmlFor="trajanje">Duration</Form.Label>
                            <Form.Control 
                            value={this.state.movie.trajanje}
                                id="trajanje"
                                type="number"
                                onChange={(e) => this.onChangeHandler(e)}
                            />
                            <Form.Label htmlFor="reziser">Director</Form.Label>
                            <Form.Control 
                            value={this.state.movie.reziser}
                                id="reziser"
                                type="text"
                                onChange={(e) => this.onChangeHandler(e)}
                            />
                            <Form.Label htmlFor="godinaProizvodnje">Year</Form.Label>
                            <Form.Control 
                            value={this.state.movie.godinaProizvodnje}
                                id="godinaProizvodnje"
                                type="number"
                                onChange={(e) => this.onChangeHandler(e)}
                            />
                            <Form.Label htmlFor="opis">Description</Form.Label>
                            <Form.Control 
                            value={this.state.movie.opis}
                                id="opis"
                                type="text"
                                onChange={(e) => this.onChangeHandler(e)}
                            />
                            <Form.Label>Genres</Form.Label>
                            <InputGroup>
                                <Form.Control value={this.sumarizedGenres()} disabled />
                                <InputGroup.Append>
                                    <Button 
                                        variant="info"
                                        onClick={() => this.setState({showSelectedGenres: true})}
                                    >
                                    &gt;
                                    </Button>
                                </InputGroup.Append>
                            </InputGroup>

                            <Button style={{ marginTop: "25px"}} onClick={this.create}>
                                {this.state.movie.id == -1 ? "Add" : "Edit"}
                            </Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>

                <SelectGenres
                    show={this.state.showSelectedGenres}
                    handleClose={() => this.setState({ showSelectedGenres: false })}
                    selectedGenres={this.state.movie.zanrovi}
                    finishSelection={(newlySelectedGenres) =>
                    {
                        let zanrovi= {}
                        newlySelectedGenres.map(genre => zanrovi[genre.id]=genre.naziv)
                        let movie = JSON.parse(JSON.stringify(this.state.movie))
                        movie.zanrovi = zanrovi
                        this.setState({
                            movie: movie,
                            showSelectGenres: false,
                        })
                    }
                    }
                 />
            </>
        )
    }
}

export default AddMovie;