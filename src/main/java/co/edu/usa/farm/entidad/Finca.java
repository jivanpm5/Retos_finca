package co.edu.usa.farm.entidad;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name="fincas")
public class Finca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Long extension;
    private String description;

    @ManyToOne
    @JoinColumn(name="idCategoria")
    @JsonIgnoreProperties("farms")
    private Categoria category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm", "client"})
    private List<Mensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "farm")
    @JsonIgnoreProperties({"farm","message"})
    private List<Reserva> reservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getExtension() {
        return extension;
    }

    public void setExtension(Long extension) {
        this.extension = extension;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria categoria) {
        this.category = categoria;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reserva> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }



}
