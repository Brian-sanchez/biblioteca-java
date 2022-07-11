import React, { useState, useEffect } from 'react';
import { DataGrid } from "@mui/x-data-grid";
import { librosColumns } from "./libroData";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";

import { getAllBooks } from "../../../../Redux/actions/index";

import "../datatable.scss";

const LibrosTable = () => {
  const dispatch = useDispatch();
  const books = useSelector((state) => state.allBooks);

  const [data, setData] = useState(books);

  const handleDelete = (id) => {
    setData(data.filter((item) => item.id !== id));
  };

  const actionColumn = [
    {
      field: "action",
      headerName: "Accion",
      width: 200,
      renderCell: (params) => {
        return (
          <div className="cellAction">
            <div className="deleteButton" onClick={() => handleDelete(params.row.id)}>Eliminar</div>

            <Link to={`/admin/libros/${params.row.id}`} className="editButton">Editar</Link>
          </div>
        );
      },
    },
  ];

  useEffect(() => {
    dispatch(getAllBooks());
  }, [dispatch]);

  return (
    <div className="datatable">
      <div className="datatableTitle">
        <Link to="/admin/libros/agregarLibros" className="link">
          Añadir Libro
        </Link>
      </div>
      
      <DataGrid
        className="datagrid"
        rows={data}
        columns={librosColumns.concat(actionColumn)}
        pageSize={9}
        rowsPerPageOptions={[9]}
        checkboxSelection
      />
    </div>
  );
};

export default LibrosTable;