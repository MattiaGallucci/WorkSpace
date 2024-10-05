package htoop22.Bank;

public class NotEnoughMoneyException extends IllegalArgumentException{
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
