package htoop22.Bank;

import java.io.Serializable;

public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private double saldo;
    private Cliente cliente;

    public BankAccount(double saldo, Cliente cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
    }

    /**
     * @param amount the amount of money to withdrawal
     * @throws NotEnoughMoneyException if there are no enough money
     */
    public void withdrawal(double amount) throws NotEnoughMoneyException{
        if (amount > this.saldo) {
            throw new NotEnoughMoneyException("Non ci sono abbastanza soldi");
        } else {
            this.saldo -= amount;
        }
    }

    /**
     * @param amount the amount of money to deposit
     */
    public void deposit(double amount) {
        this.saldo += amount;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "saldo = " + this.saldo  + this.cliente;
    }
}
