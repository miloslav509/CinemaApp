import React from "react";
import { Button, Col, Form, Table, Row, ButtonGroup } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";

class Projections extends React.Component {

    constructor(props) {
        super(props);
        this.functionForProjectionEdit = props.selectProjection;
        const search = {
            minPrice: "",
            maxPrice: "",
            movieId: "",
            from: "",
            until: ""
        }

        this.state = {
            search: search,
            projections: [],
            movies: [],
            pageNo: 0,
            totalPages: 1,
        }
    }

    componentDidMount() {
        this.getProjections(0);
        this.getMovies();
    }

    async getProjections(newPageNo) {
        
        const config = {
            params: {
                pageNo: newPageNo
            }
        }

        if (this.state.search.maxPrice != "") {
            config.params["cenaKarteDo"] = this.state.search.maxPrice;
        }
        if (this.state.search.minPrice != "") {
            config.params["cenaKarteOd"] = this.state.search.minPrice;
        }
        if (this.state.search.until != "") {
            config.params["datumIVremeDoParametar"] = this.state.search.until;
        }
        if (this.state.search.from != "") {
            config.params["datumIVremeOdParametar"] = this.state.search.from;
        }
        if (this.state.search.movieId != "") {
            config.params["filmId"] = this.state.search.movieId;
        }
        console.log(config)
        try{
            let result = await CinemaAxios.get("/projekcije", config);
            this.setState({
            projections: result.data,
            pageNo: newPageNo,
            totalPages: result.headers["total-pages"]
            });
        }catch(error) {
            console.log(error);
        }

    }


    async getMovies() {

        try {
            let result = await CinemaAxios.get("/filmovi");
            this.setState({
                movies: result.data
            })    
        }catch(error) {
            console.log(error);
        }
    }

    gotoAdd() {
        this.props.history.push("/projections/add");
    }

    goToEdit(projectionId) {
        this.functionForProjectionEdit(this.state.projections.find(projection => projection.id == projectionId));
        this.props.history.push('/projections/add');
    }

    goToBuyTicket(projectionId) {
        this.functionForProjectionEdit(this.state.projections.find(projection => projection.id == projectionId));
        this.props.history.push('/projections/ticket');
    }

    delete(id) {
        CinemaAxios.delete('/projekcije/' + id)
        .then(res => {
            
            console.log(res);
            alert('Projection was deleted successfully!');
            window.location.reload();
        })
        .catch(error => {
            console.log(error);
            alert('Error occured please try again!');
         });
    }

    inputChange(event) {
        const name = event.target.name;
        const value = event.target.value;

        let search = {...this.state.search};
        search[name] = value;
        this.setState({search});
        console.log(this.state)
        this.getProjections(0);
    }

    renderProjections() {
        return this.state.projections.map((projection, index) => {
            return (
                <tr key={projection.id}>
                    <td>{projection.filmNaziv}</td>
                    <td>{projection.datumIVreme}</td>
                    <td>{projection.tipNaziv}</td>
                    <td>{projection.salaNaziv}</td>
                    <td>{projection.cenaKarte}</td>
                    {window.localStorage["role"] == "ROLE_ADMIN" ?
                    [<td><Button variant="warning" onClick={() => this.goToEdit(projection.id)}>Edit</Button></td>,
                    <td><Button variant="danger" onClick={() => this.delete(projection.id)} >Delete</Button></td>]
                    :<td><Button variant="info" onClick={() => this.goToBuyTicket(projection.id)} >Buy ticket</Button></td>}
                </tr>
            )
        })
    }

    render() {
        return (
            <div>
                <h1>Projections</h1>

                <Form style={{marginTop:35}}>
                    <Row>
                        <Col md={6}>
                            <Form.Group>
                                <Form.Label>From</Form.Label>
                                <Form.Control
                                    value={this.state.search.from}
                                    name="from"
                                    as="input"
                                    type="text"
                                    onChange={(e) => this.inputChange(e)}
                                ></Form.Control>    
                            </Form.Group>
                        </Col>
                        <Col md={6}>
                            <Form.Group>
                                <Form.Label>Until</Form.Label>
                                <Form.Control
                                    value={this.state.search.until}
                                    name="until"
                                    as="input"
                                    type="text"
                                    onChange={(e) => this.inputChange(e)}
                                ></Form.Control>    
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row>
                        <Col md={6}>
                            <Form.Group>
                                <Form.Label>Min price</Form.Label>
                                <Form.Control
                                    value={this.state.search.minPrice}
                                    name="minPrice"
                                    as="input"
                                    type="number"
                                    onChange={(e) => this.inputChange(e)}
                                ></Form.Control>    
                            </Form.Group>
                        </Col>
                        <Col md={6}>
                            <Form.Group>
                                <Form.Label>Max price</Form.Label>
                                <Form.Control
                                    value={this.state.search.maxPrice}
                                    name="maxPrice"
                                    as="input"
                                    type="number"
                                    onChange={(e) => this.inputChange(e)}
                                ></Form.Control>    
                            </Form.Group>
                        </Col>
                    </Row>
                    <Form.Group>
                        <Form.Label>Movie</Form.Label>
                        <Form.Control
                            value={this.state.search.movieId}
                            name="movieId"
                            as="select"
                            onChange={(e) => this.inputChange(e)}>
                            <option value={-1}></option>
                            {this.state.movies.map((movie) => {
                                return (
                                    <option value={movie.id} key={movie.id}>
                                        {movie.naziv}
                                    </option>    
                                )
                            })}
                        </Form.Control>    
                    </Form.Group>
                    <Button variant="info" onClick={() => this.getProjections(0)}>Search</Button>
                </Form>
                <br/><br/>
                
                <div>
                    {window.localStorage['role'] == 'ROLE_ADMIN'?
                    <Button onClick={() => this.goToAdd() }>Add</Button>: null}
                    <br/>
                    <Table id="movies-table" style={{marginTop: 5}}>
                        <thead>
                            <tr>
                                <th>Movie name</th>
                                <th>Time</th>
                                <th>Projections Type</th>
                                <th>Hall</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderProjections()}
                        </tbody>
                    </Table>
                    <ButtonGroup>
                        <Button disabled={this.state.pageNo===0} onClick={()=> this.getProjections(this.state.pageNo-1)}>Prev</Button>
                        <Button disabled={this.state.pageNo===this.state.totalPages-1} onClick={()=> this.getProjections(this.state.pageNo+1)}>Next</Button>
                    </ButtonGroup>
                </div>
            </div>
        )
    }


}

export default Projections;