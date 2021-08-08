/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Swal */

function confirmDeleteHuesped(){
    var respuesta = confirm('Si elimina al Huesped, tambien se borrara toda la informacion relacionada a este, incluyendo las Reservas asociadas, esta seguro que desea hacerlo?');

    if(respuesta === true){
        return true;
    }else{
        return false;
    }
}

function confirmDeleteReserva(){
    var respuesta = confirm('Esta seguro que desea eliminar esta reserva?');
    
    if(respuesta === true){
        return true;
    }else{
        return false;
    }
}

