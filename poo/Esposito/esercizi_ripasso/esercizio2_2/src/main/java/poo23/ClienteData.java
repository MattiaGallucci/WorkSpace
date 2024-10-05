package poo23;

import java.util.Objects;

public class ClienteData {
    private Cliente cliente;
    private String data;
    
    public ClienteData(Cliente cliente, String data) {
        this.cliente = cliente;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass()) 
            return false;
        ClienteData that = (ClienteData) o;
        return cliente.equals(that.cliente) && data.equals(that.data);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cliente, data);
    }

    @Override
    public String toString() {
        return "ClienteData [cliente=" + cliente + ", data=" + data + "]";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
}
