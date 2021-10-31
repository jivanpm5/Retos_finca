package co.edu.usa.farm.reporte;

import co.edu.usa.farm.entidad.Cliente;

public class ClienteContador {
    private Long total;
    private Cliente client;

    public ClienteContador(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

}
