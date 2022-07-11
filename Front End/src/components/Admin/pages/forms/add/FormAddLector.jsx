import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { addLector, getAllLectores } from "../../../../../Redux/actions/index";

import Swal from 'sweetalert2/dist/sweetalert2.js';
import 'sweetalert2/src/sweetalert2.scss';

import Sidebar from "../../../sidebar/Sidebar";

import "./formAddStyles.scss";

const FormAddLector = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [input, setInput] = useState({
    nombre: "",
    telefono: "",
    direccion: ""
  });

  const [errors, setErrors] = useState({ name: "" });


  const handleInputChange = (e) => {
    setInput({
      ...input,
      [e.target.name]: e.target.value
    });

    setErrors(validateForm({
      ...input,
      [e.target.name]: e.target.value
    }));
  };

  const swalStyle = Swal.mixin({
    customClass: {
      title: 'swal-title',
      htmlContainer: 'swal-text',
    }
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!input.nombre || !input.telefono || !input.direccion) return swalStyle.fire({
      icon: 'error',
      title: 'Error',
      text: 'Por favor complete todo el formulario',
    });
    
    e.preventDefault();
    dispatch(addLector(input));
    setInput({
      nombre: "",
      telefono: "",
      direccion: ""
    });

    alert("El lector a sido creado exitosamente!");
    dispatch(getAllLectores());
    navigate("/admin/lectores");
  };

  return (
    <div className="new">
      <Sidebar/>

      <div className="newContainer">
        <div className="top">
          <h1>Agregue un Lector</h1>
        </div>

        <div className="bottom">
          <form onSubmit={handleSubmit}>
            <div className="formInput">
              <label>Nombre</label>
              <input type="text" placeholder="Ingrese el nombre del Lector" name="nombre" onChange={handleInputChange} value={input.nombre}/>
              { errors.nombre && <p className="errors">{errors.nombre}</p> }
            </div>

            <div className="formInput">
              <label>Telefono</label>
              <input type="text" placeholder="Ingrese el nombre del Lector" name="telefono" onChange={handleInputChange} value={input.telefono}/>
            </div>

            <div className="formInput">
              <label>Direccion</label>
              <input type="text" placeholder="Ingrese el nombre del Lector" name="direccion" onChange={handleInputChange} value={input.direccion}/>
            </div>

            <button>Añadir lector</button>
          </form>
        </div>
      </div>
    </div>
  );
};

// Validations
export function validateForm(input) {
  let errors = {};

  if (!input.nombre) {
    errors.nombre = "El nombre es requerido";
  }

  return errors;
};

export default FormAddLector;