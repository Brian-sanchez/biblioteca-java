import Swal from 'sweetalert2/dist/sweetalert2.js';
import 'sweetalert2/src/sweetalert2.scss';
import axios from "axios";

const swalStyle = Swal.mixin({
  customClass: {
    title: 'swal-title',
    htmlContainer: 'swal-text',
  }
});

// Actions Get
export function getAllBooks() {
  return async function (dispatch) {
    try {
      const response = await axios.get(`http://localhost:8081/api/libros`);
      dispatch({ type: "GET_ALL_BOOKS", payload: response.data });
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable en getAllBooks, revisar codigo',
      });
      console.log("Get all books:", error);
    }
  };
};

export function getAllCopias() {
  return async function (dispatch) {
    try {
      const response = await axios.get(`http://localhost:8081/api/copias`);
      dispatch({ type: "GET_ALL_COPIAS", payload: response.data });
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable en getAllCopias, revisar codigo',
      });
      console.log("Get all copias:", error);
    }
  };
};

export function getAllLectores() {
  return async function (dispatch) {
    try {
      const response = await axios.get(`http://localhost:8081/api/lectores`);
      dispatch({ type: "GET_ALL_LECTORES", payload: response.data });
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable getAllLectores, revisar codigo',
      });
      console.log("Get all lectores:", error);
    }
  };
};

export function getAllPrestamos() {
  return async function (dispatch) {
    try {
      const response = await axios.get(`http://localhost:8081/api/prestamos`);
      dispatch({ type: "GET_ALL_PRESTAMOS", payload: response.data });
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable en getAllPrestamos, revisar codigo',
      });
      console.log("Get all prestamos:", error);
    }
  };
};

export function getAllMultas() {
  return async function (dispatch) {
    try {
      const response = await axios.get(`http://localhost:8081/api/multas`);
      dispatch({ type: "GET_ALL_MULTAS", payload: response.data });
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable en getAllMultas, revisar codigo',
      });
      console.log("Get all multas:", error);
    }
  };
};

export function getCopiasDisponibles() {
  return async function (dispatch) {
    try {
      const response = await axios.get(`http://localhost:8081/api/copias/disponibles`);
      dispatch({ type: "GET_DISPONIBLES", payload: response.data });
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable getCopiasDisponibles, revisar codigo',
      });
      console.log("Get copias disponibles:", error);
    }
  };
};

// Actions posts
export function addLector(lector) {
  return async function (dispatch) {
    try {
      dispatch({ type: "POST_ACTION", payload: "true" });
      const response = await axios.post("http://localhost:8081/api/lectores", lector);
      console.log(response);
      Swal.fire(
        'Excelente!',
        'El lector ha sido creado exitosamente',
        'success'
      )
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable en addLector, revisar codigo',
      });
      dispatch({ type: "POST_ACTION", payload: "false" });
    }
  };
};

export function addCopia(copia) {
  return async function (dispatch) {
    try {
      dispatch({ type: "POST_ACTION", payload: "true" });
      const response = await axios.post("http://localhost:8081/api/copias", copia);
      console.log(response);
      Swal.fire(
        'Excelente!',
        'La copia ha sido creado exitosamente',
        'success'
      )
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable en addCopia, revisar codigo',
      });
      dispatch({ type: "POST_ACTION", payload: "false" });
    }
  };
};

export function addLibro(libro) {
  return async function (dispatch) {
    try {
      dispatch({ type: "POST_ACTION", payload: "true" });
      const response = await axios.post("http://localhost:8081/api/libros", libro);
      console.log(response);
      Swal.fire(
        'Excelente!',
        'El libro ha sido creado exitosamente',
        'success'
      )
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'A ocurrido un error inexplicable en addLibro, revisar codigo',
      });
      dispatch({ type: "POST_ACTION", payload: "false" });
    }
  };
};

export function addPrestamo(prestamo) {
  return async function (dispatch) {
    try {
      dispatch({ type: "POST_ACTION", payload: "true" });
      const response = await axios.post("http://localhost:8081/api/prestamos/prestar", prestamo);
      console.log(response);
      Swal.fire(
        'Excelente!',
        'El prestamo ha sido creado exitosamente',
        'success'
      )
    } catch (error) {
      swalStyle.fire({
        icon: 'error',
        title: 'Error',
        text: 'El lector seleccionado no puede tener mas de 3 prestamos, el prestamo no se a efectuado',
      });
      dispatch({ type: "POST_ACTION", payload: "false" });
    }
  };
};

export function addMulta(multa) {
  return async function (dispatch) {
    try {
      dispatch({ type: "POST_ACTION", payload: "true" });
      const response = await axios.post("http://localhost:8081/api/multas", multa);
      console.log(response);
      Swal.fire(
        'Excelente!',
        'La multa ha sido creado exitosamente',
        'success'
      )
    } catch (error) {
      console.log(error);
      dispatch({ type: "POST_ACTION", payload: "false" });
    }
  };
};

// Actions puts
export function editLector(lector, id) {
  return async function () {
    const updated = await axios.put(`http://localhost:8081/api/lectores/${id}`, lector);
    Swal.fire(
      'Excelente!',
      'Se ha editado el lector exitosamente',
      'success'
    )
    return {
      type: "EDIT_ACTION",
      payload: updated,
    };
  };
};

export function editLibro(libro, id) {
  return async function () {
    const updated = await axios.put(`http://localhost:8081/api/libros/${id}`, libro);
    Swal.fire(
      'Excelente!',
      'Se ha editado el libro exitosamente',
      'success'
    )
    return {
      type: "EDIT_ACTION",
      payload: updated,
    };
  };
};

export function editCopia(copia, id) {
  return async function () {
    const updated = await axios.put(`http://localhost:8081/api/libros/${id}`, copia);
    Swal.fire(
      'Excelente!',
      'Se ha editado la copia exitosamente',
      'success'
    )
    return {
      type: "EDIT_ACTION",
      payload: updated,
    };
  };
};

export function editPrestamo(prestamo, id) {
  return async function () {
    const updated = await axios.put(`http://localhost:8081/api/prestamos/edit/${id}`, prestamo);
    Swal.fire(
      'Excelente!',
      'Se ha editado el prestamo exitosamente',
      'success'
    )
    return {
      type: "EDIT_ACTION",
      payload: updated,
    };
  };
};

export function devolverPrestamo(id) {
  return async function () {
    const updated = await axios.put(`http://localhost:8081/api/prestamos/devolver/${id}`);
    Swal.fire(
      'Excelente!',
      'Se ha devuelto el prestamo exitosamente',
      'success'
    )
    return {
      type: "EDIT_ACTION",
      payload: updated,
    };
  };
};

export function editMulta(multa, id) {
  return async function () {
    const updated = await axios.put(`http://localhost:8081/api/multas/edit/${id}`, multa);
    Swal.fire(
      'Excelente!',
      'Se ha editado la multa exitosamente',
      'success'
    )
    return {
      type: "EDIT_ACTION",
      payload: updated,
    };
  };
};

// Actions deletes
export function deleteLibroById(id) {
  return async function () {
    try {
      await axios.delete(`http://localhost:8081/api/libros/${id}`);
      return {
        type: "DELETE_ACTION",
        payload: "libro deleted",
      };
    } catch (error) {
      console.log("Delete libro:", error);
    }
  };
};

export function deleteCopiaById(id) {
  return async function () {
    await axios.delete(`http://localhost:8081/api/copias/${id}`);
    return {
      type: "DELETE_ACTION",
      payload: "lector deleted",
    };
  };
};

export function deleteLectorById(id) {
  return async function () {
    await axios.delete(`http://localhost:8081/api/lectores/${id}`);
    return {
      type: "DELETE_ACTION",
      payload: "lector deleted",
    };
  };
};

export function deletePrestamoById(id) {
  return async function () {
    try {
      await axios.delete(`http://localhost:8081/api/prestamos/${id}`);
      return {
        type: "DELETE_ACTION",
        payload: "prestamo deleted",
      };
    } catch (error) {
      console.log("Delete prestamo:", error);
    }
  };
};

export function deleteMultaById(id) {
  return async function () {
    try {
      await axios.delete(`http://localhost:8081/api/multas/${id}`);
      return {
        type: "DELETE_ACTION",
        payload: "multa deleted",
      };
    } catch (error) {
      console.log("Delete multa:", error);
    }
  };
};