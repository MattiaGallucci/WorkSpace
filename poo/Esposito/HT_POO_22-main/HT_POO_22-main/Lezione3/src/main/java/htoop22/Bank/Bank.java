package htoop22.Bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<BankAccount> conti;
    private ArrayList<Cliente> clienti;

    public Bank() {
        this.conti = new ArrayList<>();
        this.clienti = new ArrayList<>();
    }

    public void addCostumer(Cliente c) {
        this.clienti.add(c);
    }

    public void addConto(BankAccount conto) {
        this.conti.add(conto);
        Cliente c = conto.getCliente();
        c.addContoToCliente(conto);
    }

    /**
    * Search the costumer with given costumer number and return it only if the pin matches
     * @param aNumber customer number
     * @param aPin customer pin
     * @return Cliente if it's been found, null otherwise
    * */

    public Cliente findCostumer(int aNumber, int aPin) {
        for (Cliente c: clienti) {
            if (c.match(aNumber, aPin)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<BankAccount> getConti() {
        return conti;
    }

    public void setConti(ArrayList<BankAccount> conti) {
        this.conti = conti;
    }

    public ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(ArrayList<Cliente> clienti) {
        this.clienti = clienti;
    }
}
