package co.edu.usa.farm.interfaz;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.usa.farm.entidad.Reserva;

public interface ReservaCrudRepositorio extends CrudRepository<Reserva,Long>{
    
    public List<Reserva> findAllByStatus (String status); 
    
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reserva group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reserva AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
