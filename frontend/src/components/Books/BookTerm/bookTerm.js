import React from 'react';
import {Link} from 'react-router-dom';
//TODO VIDI GO CONTROLLEROT
const BookTerm = (props) => {
    return (
        <tr key={props.term.id}>
            <td>{props.term.name}</td>
            <td>{props.term.author.name + " " + props.term.author.surname}</td>
            <td>{props.term.availableCopies}</td>
            <td>{props.term.category}</td>
            <td className={"text-right"}>
                <Link className={"btn btn-warning"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>

                <Link className={"btn btn-success m-2"}
                      onClick={() => props.onReserve(props.term.id)}
                      to={'/books'}>
                    Mark as taken
                </Link>

                <a href="/" title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
            </td>
        </tr>
    )
}

export default BookTerm;
