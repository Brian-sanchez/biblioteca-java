import React, { useState, useEffect } from 'react';
import { DataGrid } from "@mui/x-data-grid";
import { prestamosColumns } from "./prestamoData";
import { Link, useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getAllPrestamos, deletePrestamoById, devolverPrestamo } from "../../../../Redux/actions/index";

import "../datatable.scss";

const PrestamosTable = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const prestamos = useSelector((state) => state.allPrestamos);
  const prestamoID = prestamos.map((l) => {
    return l.id;
  });

  const [data, setData] = useState(prestamos);

  const actionColumn = [
    {
      field: "action",
      headerName: "Accion",
      width: 240,
      renderCell: (params) => {
        return (
          <div className="cellAction">
            <div className="deleteButton" onClick={() => handleDelete(params.row.id)}>Eliminar</div>

            <Link to={`/admin/prestamos/${params.row.id}`} className="editButton">Editar</Link>

            <div className="devolverButton" onClick={() => handleDevolver(params.row.id)}>Devolver</div>
          </div>
        );
      },
    },
  ];

  const handleDelete = (id) => {
    const idPrestamo = prestamoID.find(e => e === id)
    dispatch(deletePrestamoById(idPrestamo));
    setData(data.filter((item) => item.id !== id));
    dispatch(getAllPrestamos());
  };

  const handleDevolver = (id) => {
    const idPrestamo = prestamoID.find(e => e === id);
    dispatch(devolverPrestamo(idPrestamo));
    dispatch(getAllPrestamos());
    navigate("/admin");
  }

  useEffect(() => {
    dispatch(getAllPrestamos());
  }, [dispatch]);

  return (
    <div className="datatable">
      <div className="datatableTitle">
        <Link to="/admin/prestamos/agregarPrestamos" className="link">
          Añadir Prestamo
        </Link>
      </div>
      <DataGrid
        className="datagrid"
        rows={data}
        columns={prestamosColumns.concat(actionColumn)}
        pageSize={9}
        rowsPerPageOptions={[9]}
        checkboxSelection
      />
    </div>
  );
};

export default PrestamosTable;