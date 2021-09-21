import React from 'react';
import { Button, Table } from 'react-bootstrap';
import CinemaAxios from './../../apis/CinemaAxios'

class Users extends React.Component {

    constructor(props) {
        super();
        this.state = { users: []};
    }

    componentDidMount() {
        this.getUsers();
    }

    getUsers() {
        CinemaAxios.get('/korisnici')
            .then(res => {
                console.log(res);
                this.setState({users: res.data});
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

    goToTickets(username) {
        this.props.history.push("/users/tickets/" + username);
    }



    renderUsers() {
        return this.state.users.map((user, index) => {
            return (
                <tr key={user.id}>
                    <td>{user.korisnickoIme}</td>
                    <td>{user.eMail}</td>
                    <td>{user.ime}</td>
                    <td>{user.prezime}</td>
                    <td>{user.adresaDTO.ulica}</td>
                    <td>{user.adresaDTO.broj}</td>
                    <td><Button variant="danger" onClick = {() => this.delete(user.id) } >Delete</Button></td> 
                    <td><Button variant="info" onClick = {() => this.goToTickets(user.korisnickoIme) } >Tickets</Button></td> 
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
                                <th>Username</th>
                                <th>eMail</th>
                                <th>Name</th>
                                <th>Lastname</th>
                                <th>Ulica</th>
                                <th>Broj</th>
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

export default Users;