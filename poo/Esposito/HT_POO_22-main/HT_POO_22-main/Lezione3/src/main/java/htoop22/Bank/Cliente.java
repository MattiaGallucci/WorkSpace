package htoop22.Bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String cognome;
    private final int customerNumber;
    private final int customerPin;
    private ArrayList<BankAccount> conti;

    public Cliente(String nome, String cognome, int aNumber, int aPin) {
        this.nome = nome;
        this.cognome = cognome;
        this.customerNumber = aNumber;
        this.customerPin = aPin;
        this.conti = new ArrayList<>();
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getCustomerPin() {
        return customerPin;
    }


    public void addContoToCliente(BankAccount conto) {
        this.conti.add(conto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public ArrayList<BankAccount> getConti() {
        return conti;
    }

    public void setConti(ArrayList<BankAccount> conti) {
        this.conti = conti;
    }

    /**
     Tests if this customer matches a customer number and PIN.
     @param aNumber a customer number
     @param aPin a personal identification number
     @return true if the customer number and PIN match
     */
    public boolean match(int aNumber, int aPin) {
        return this.customerNumber == aNumber && this.customerPin == aPin;
    }

    @Override
    public String toString() {
        return " Cliente nome=" + this.nome + ", cognome = " + this.cognome;
    }
}
