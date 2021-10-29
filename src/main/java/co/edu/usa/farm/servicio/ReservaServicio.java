package co.edu.usa.farm.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.farm.entidad.Reserva;
import co.edu.usa.farm.respositorio.ReservaRepositorio;

/**
 * Funcion Crud al repositorio
 */
@Service
public class ReservaServicio {

/**
 * Repositorio
 */
    @Autowired
    private ReservaRepositorio Crudreserva;

    public List<Reserva> getAll(){
        return Crudreserva.getAll();
    }
/**
 * Reservacion id
 */
    public Optional<Reserva> getReservation(Long reservationId) {
        return Crudreserva.getReservation(reservationId);
    }

/**
 * Metodo de gardar información
 */
    public Reserva save(Reserva reservation){
        if(reservation.getIdReservation()==null){
            return Crudreserva.save(reservation);
        }else{
            Optional<Reserva> e= Crudreserva.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return Crudreserva.save(reservation);
            }else{

                //Retorna a Resevation
                return reservation;
            }
        }
    }

/**
 * Metodo de actualizar información
 */
    public Reserva update(Reserva reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reserva> e= Crudreserva.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                Crudreserva.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{

            //Retorna a Resevation
            return reservation;
        }
    }

/**
 * Metodo de eliminar información
 */
    public boolean deleteReservation(Long reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            Crudreserva.delete(reservation);
            return true;
        }).orElse(false);
        
        //Retorna a boolean
        return aBoolean;
    }
}