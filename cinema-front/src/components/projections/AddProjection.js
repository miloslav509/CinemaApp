import React from 'react';
import { Form, Row, Col, Button} from 'react-bootstrap';
import CinemaAxios from '../../apis/CinemaAxios';

class AddProjection extends React.Component {

    constructor(props) {
        super(props);
        const projection = this.props.selectedProjection =="" ? {
            id: -1,
            datumIVreme: "",
            filmId: -1,
            salaId: -1,
            tipId: -1,
            cenaKarte: 0
        }: this.props.selectedProjection;
        this.props.deleteProjection("");
        this.state = {
            projection: projection,
            movies: [],
            halls: [],
            types: []
        };

    }

    componentDidMount() {
        if (this.state.projection.id !== -1) {
            this.getHalls(this.state.projection.tipId);
        }
        this.getMovies();
        this.getTypes();
    }

    async getMovies() {

        try {
            let result = await CinemaAxios.get("/filmovi");
            this.setState({movies: result.data});
        }catch(error) {
            console.log(error);
            alert("Couldn't fetch movies");
        }
    }

    async getTypes() {

        try {
            let result = await CinemaAxios.get("/tipovi");
            this.setState({types: result.data});
        }catch(error) {
            console.log(error);
            alert("Couldn't fetch types");
        }
    }

    async getHalls(typeId) {

        try {
            let result = await CinemaAxios.get("/tipovi/" + typeId + "/sale");
            this.setState({halls: result.data});
        }catch(error) {
            console.log(error);
            alert("Couldn't fetch halls");
        }
    }

    create(e) {
        e.preventDefault();
        console.log(this.state)
        let projection = this.state.projection;
        let projectionDTO = {
            datumIVreme: projection.datumIVreme,
            filmId: projection.filmId,
            salaId: projection.salaId,
            tipId: projection.tipId,
            canaKarte: projection.cenaKarte
        }
        console.log(projectionDTO)
        if (this.state.projection.id == -1) {
            let response = CinemaAxios.post("/projekcije", projectionDTO)
            .then((res) => {
                console.log(res);
                alert("Projection was added succesfully");
                this.props.history.push("/projections");
            })
            .catch((error) => {
                console.log(error);
                alert("Error occured please try again!");
            }) 
                
        }else {
            let projectionId = this.state.projection.id;
            projectionDTO['id'] = projectionId;
            CinemaAxios.put("/projekcije/" + projectionId, projectionDTO)
            .then((res) => {
                console.log(res);
                alert("Projection was added successfuly")
                this.props.history.push("/projections");
            })
            .catch((error) => {
                alert("Error occured please try again!");
            })

        }

    }

    valueInputChange(event) {
        let name = event.target.name;
        let value = event.target.value;

        let projection = this.state.projection;
        projection[name] = value;
        if (name === "tipId") {
            this.getHalls(value);
        }
        this.setState({projection: projection});
        console.log(this.state)
    }

    
    render() {
        return (
            <>
                <Col></Col>
                <Col xs="12" sm="10" md="8">
                    <h1>{this.state.projection.id==-1 ? "Add projection": "Edit projection"}</h1>
                    <Form>
                        <Form.Group>
                            <Form.Label htmlFor="pTime">Time</Form.Label>
                            <Form.Control id="datumIVreme" name="datumIVreme" value={this.state.projection.datumIVreme} onChange={(e) => this.valueInputChange(e)}/> <br/>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label htmlFor="pPrice">Price</Form.Label>
                            <Form.Control id="cenaKarte" name="cenaKarte" value={this.state.projection.cenaKarte} onChange={(e) => this.valueInputChange(e)}/> <br/>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label htmlFor="pMovie">Movie</Form.Label>
                            <Form.Control as="select" id="filmId" name="filmId" value={this.state.projection.filmId} onChange={(e) => this.valueInputChange(e)}>
                                <option></option>
                                {
                                    this.state.movies.map((movie) => {
                                        return (
                                            <option key={movie.id} value={movie.id}>{movie.naziv}</option>
                                        )
                                    })
                                }
                            </Form.Control>
                        </Form.Group>    
                        <Form.Group>
                            <Form.Label htmlFor="pType">Type</Form.Label>
                            <Form.Control as="select" id="tipId" name="tipId" value={this.state.projection.tipId} onChange={(e) => this.valueInputChange(e)}>
                                <option></option>
                                {
                                    this.state.types.map((type) => {
                                        return (
                                            <option key={type.id} value={type.id}>{type.naziv}</option>
                                        )
                                    })
                                    }
                            </Form.Control>
                        </Form.Group>    
                        <Form.Group>
                            <Form.Label htmlFor="pMovie">Hall</Form.Label>
                            <Form.Control as="select" id="salaId" name="salaId" value={this.state.projection.salaId} onChange={(e) => this.valueInputChange(e)}>
                                <option></option>
                                {
                                    this.state.halls.map((hall) => {
                                        return (
                                            <option key={hall.id} value={hall.id}>{hall.naziv}</option>
                                        )
                                    })
                                }
                            </Form.Control>
                            <Button style={{ marginTop: "25px" }} onClick={(e) => this.create(e)}>
                                {this.state.projection.id==-1?"Add":"Edit"}
                            </Button>
                        </Form.Group>
                    </Form>
                </Col>
            </>
        )
    }

}

export default AddProjection;