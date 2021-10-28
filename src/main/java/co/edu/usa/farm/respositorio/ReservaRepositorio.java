package co.edu.usa.farm.respositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.farm.entidad.Reserva;
import co.edu.usa.farm.interfaz.ReservaCrudRepositorio;

@Repository
public class ReservaRepositorio {
    
    @Autowired
    private  ReservaCrudRepositorio reservaRepoitorio;

    public List<Reserva> getAll(){
        return (List<Reserva>) reservaRepoitorio.findAll();
    }
    public Optional<Reserva> getReservation(Long idReservation){
        return reservaRepoitorio.findById(idReservation);
    }
    public Reserva save(Reserva reservation){
        return reservaRepoitorio.save(reservation);
    }
    public void delete(Reserva reservation) {
        reservaRepoitorio.delete(reservation);
    }

}
