package co.edu.usa.farm.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.farm.entidad.Reserva;
import co.edu.usa.farm.respositorio.ReservaRepositorio;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio Crudreserva;

    public List<Reserva> getAll(){
        return Crudreserva.getAll();
    }

    public Optional<Reserva> getReservation(Long reservationId) {
        return Crudreserva.getReservation(reservationId);
    }

    public Reserva save(Reserva reservation){
        if(reservation.getIdReservation()==null){
            return Crudreserva.save(reservation);
        }else{
            Optional<Reserva> e= Crudreserva.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return Crudreserva.save(reservation);
            }else{
                return reservation;
            }
        }
    }
}
