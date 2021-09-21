import React from 'react';
import { Button, Table } from 'react-bootstrap';
import CinemaAxios from './../../apis/CinemaAxios'

class UsersTickets extends React.Component {

    constructor(props) {
        super();
        this.state = { tickets: []};
    }

    componentDidMount() {
        this.getTickets(this.props.match.params.username);
    }

    getTickets(username) {
        CinemaAxios.get('/korisnici/' + username + '/karte')
            .then(res => {
                console.log(res);
                this.setState({tickets: res.data});
            })
            .catch(error =>{
                console.log(error);
                alert('Error occured please try again');
            });
    }


    delete(id) {
        CinemaAxios.delete('/korisnici/' + id)
            .then(res => {
                console.log(res);
                alert('User was deleted succesfully');
                window.location.reload();
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again');
            })
    }


    renderUsers() {
        return this.state.tickets.map((ticket, index) => {
            return (
                <tr key={ticket.id}>
                    <td>{ticket.datumIVreme}</td>
                    <td>{ticket.filmNaziv}</td>
                    <td>{ticket.projekcijaVreme}</td>
                    <td>{ticket.salaNaziv}</td>
                    <td>{ticket.sedisteBroj}</td>
                    <td>{ticket.korisnikUsername}</td>
                    <td><Button variant="danger" onClick = {() => this.delete(ticket.id) } >Delete</Button></td>  
                </tr>
            )
        })
    }

    render() {
        return (
            <div>
                <h1>Users</h1>

                <div>
                    <Table id="movies-table" style={{margin:5}}>
                        <thead>
                            <tr>
                                <th>Date and time</th>
                                <th>Movie</th>
                                <th>Projection time</th>
                                <th>Hall</th>
                                <th>Seat</th>
                                <th>Username</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderUsers()}
                        </tbody>
                    </Table>
                </div>
            </div>
        )
    }

}

export default UsersTickets;