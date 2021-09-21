import React from 'react';
import { Form, Row, Col, Button, Table } from 'react-bootstrap';
import CinemaAxios from '../../apis/CinemaAxios';
import Select from 'react-select';

class BuyTicket extends React.Component {

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
            seats: [],
            seat: -1
        }    
    }

    componentDidMount() {
        this.getSeats();
        
    }

    async getSeats() {
        try {
            let result = await CinemaAxios.get("/projekcije/" + this.state.projection.id + "/sedista");
            this.setState({seats: result.data});
            console.log(this.state);
        }catch(error) {
            console.log(error);
            alert("Couldn't fetch seats");
        }
    }

    create() {
        
        var today = new Date();
        var month = today.getMonth() + 1;
        if (month < 10) {
            month = '0' + month;
        }
        var date = today.getFullYear()+'-'+month+'-'+today.getDate();
        var time = today.getHours() + ":" + today.getMinutes();
        var dateTime = date+' '+time; 

        let ticketDTO = {
            korisnikUsername: window.localStorage['username'],
            projekcijaId: this.state.projection.id,
            sedisteId: this.state.seat,
            datumIVreme: dateTime
        }
        console.log(ticketDTO)
        let response = CinemaAxios.post("/karte", ticketDTO)
            .then((res) => {
                console.log(res);
                alert("Ticket was added succesfully");
                this.props.history.push("/projections");
            })
            .catch((error) => {
                console.log(error);
                alert("Error occured please try again!");
            })    
    }

    handleChange(event) {
        let seat = event.target.value;
        this.setState({ seat: seat });
    }

    render() {
        return (
            <div>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                    <h1>Buy Ticket</h1>
                    <Table>
                    <thead>
                            <tr>
                                <th>Movie</th>
                                <th>Time</th>
                                <th>Price</th>
                                <th>Type</th>
                                <th>Hall</th>
                                <th>Seat</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{this.state.projection.filmNaziv}</td>
                                <td>{this.state.projection.datumIVreme}</td>
                                <td>{this.state.projection.cenaKarte}</td>
                                <td>{this.state.projection.tipNaziv}</td>
                                <td>{this.state.projection.salaNaziv}</td>
                                <td>
                                    <select onChange={(e) => this.handleChange(e)}>
                                        <option></option>
                                        {
                                            this.state.seats.map((seat) => {
                                                return (
                                                    <option key={seat.id} value={seat.id}>{seat.redniBroj}</option>
                                                )
                                            })
                                        }
                                    </select>
                                </td>
                                <td><Button variant="success" onClick={() => this.create()}>Buy</Button></td>
                            </tr>
                        </tbody>
                        
                    </Table>
                    </Col>
                    <Col></Col>
                </Row>
            </div>
        )
    }
}

export default BuyTicket;