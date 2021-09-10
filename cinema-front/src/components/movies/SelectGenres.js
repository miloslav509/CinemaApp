import React from "react";
import { Button, Modal, Table } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";

class SelectGenres extends React.Component {

    constructor(props) {
        super(props);

        this.state = { genres: [], selectedGenres: Object.values(this.props.selectedGenres) };

        this.inSelectedGenres = this.isInSelectedGenres.bind(this);
        this.selectionOccured = this.selectionOccured.bind(this);
    }

    componentDidMount() {
        this.getGenres();
    }

    async getGenres() {
        try {
            let result = await CinemaAxios.get("/zanrovi");
            this.setState({ genres: result.data});
        } catch (error) {
            alert("Couldnt not fetch genres");
            console.log(error);
        }
    }

    getSelectedGenres() {
        console.log(this.state.genres.filter(genre => this.state.selectedGenres.includes(genre.naziv)));
        return this.state.genres.filter(genre => this.state.selectedGenres.includes(genre.naziv));
    }

    isInSelectedGenres(genre) {
        return this.state.selectedGenres.some(alredySelected => alredySelected == genre.naziv);
    }

    selectionOccured(event, genre) {

        let previouslySelected = this.state.selectedGenres;

        if(event.ctrlKey) {
            if(!this.isInSelectedGenres(genre)) {
                previouslySelected.push(genre.naziv);
                this.setState({ selectedGenres: previouslySelected });
            }
        }
        else {
            this.setState({ selectedGenres: [genre.naziv] });
        }
    }



    render() {
        return (
            <>
                <Modal
                show={this.props.show}
                onHide={this.props.handleClose}
                backdrop="static"
                >
                    <Modal.Header closeButton>
                        <Modal.Title>Select genres</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <div style={{ marginBottom: "5px"}}>
                            <Button variant="info" onClick={() => this.props.finishSelection(this.getSelectedGenres())}>Select</Button>
                        </div>

                        <Table>
                            <thead>
                                <tr>
                                    <th>Name</th>    
                                </tr>    
                            </thead>
                            <tbody>
                                {this.state.genres.map((g) => {
                                    return (
                                        <tr
                                        style={ this.isInSelectedGenres(g) ? { backgroundColor: "#23abed", color: "white" } : {}}
                                        onClick={(event) => this.selectionOccured(event, g)}
                                        key={g.id} >
                                        <td>{g.naziv}</td> 
                                        </tr>
                                                  
                                    )
                                })}    
                            </tbody>    
                        </Table>    
                    </Modal.Body>    
                 </Modal>
            </>
        )
    }

}

export default SelectGenres;