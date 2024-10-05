package poo23.text_area;

public class BankAccount implements Measurable {
	private double balance;
	private int accountNumber;

	public BankAccount() {
		balance = 0;
	}

	public BankAccount(double initialBalance) {
		if(initialBalance < 0)
			throw new IllegalArgumentException("Saldo negativo");
		balance = initialBalance;
	}
	
	public BankAccount(int anAccountNumber) {
	    accountNumber = anAccountNumber;
	    balance = 0;
	}

	public BankAccount(int anAccountNumber, double initialBalance) {
	    accountNumber = anAccountNumber;
	    balance = initialBalance;
	}

	public double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void deposit(double amount) {
		if(amount < 0)
			throw new IllegalAccessError("Impossibile depositare somme negative");
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount > balance)
			throw new IllegalArgumentException("Saldo insufficiente");
		balance -= amount;
	}

	

	public void transfer(double amount, BankAccount other) {
		withdraw(amount);
		other.deposit(amount);
	}

	public double getMeasure() {
		return balance;
	}

}
