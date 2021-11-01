package co.edu.usa.farm.respositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.farm.entidad.Cliente;
import co.edu.usa.farm.entidad.Reserva;
import co.edu.usa.farm.interfaz.ReservaCrudRepositorio;
import co.edu.usa.farm.reporte.ClienteContador;

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
public List<Reserva> ReservacionStatusRepositorio (String status){
        return reservaRepoitorio.findAllByStatus(status);
    }

    public List<Reserva> ReservacionTiempoRepositorio (Date a, Date b){
        return reservaRepoitorio.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
    public List<ClienteContador> getClientesRepositorio(){
        List<ClienteContador> res = new ArrayList<>();
        List<Object[]> report = reservaRepoitorio.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ClienteContador((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }

}
