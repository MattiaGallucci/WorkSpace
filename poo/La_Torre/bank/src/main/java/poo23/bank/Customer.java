package poo23.bank;

public class Customer implements Cloneable {
	private String name;
	private BankAccount account;

	public Customer(String name, BankAccount account) {
		this.name = name;
		this.account = account;
	}

	public BankAccount getAccount() {
		// return account;			// incapsulamento violato
		return account.clone();
	}

	public void setAccount(BankAccount anAccount) {
		// account = anAccount; 	// incapsulamento violato
		account = anAccount.clone();
	}

	public Customer clone() {
		try {
			Customer cloned = (Customer) super.clone();
			cloned.account = account.clone();
			return cloned;
		} catch (CloneNotSupportedException e) {
			// non succede mai perchè implementiamo Cloneable
			return null;
		}
	}
}
