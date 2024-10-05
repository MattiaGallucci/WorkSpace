package poo23.esercizio2;

public class AccountTest {
	public static void main(String[] args) {
		BankAccount mattia = new BankAccount(-5);
		BankAccount chicca = new BankAccount(50000);

		chicca.deposit(-40);
		chicca.withdraw(-10);

	}
}
