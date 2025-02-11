package Task_1;

public class ATMException extends Exception {
    public ATMException(String message) {
        super(message);
    }
}

class InvalidAmountException extends ATMException {
    public InvalidAmountException() {
        super("Невірна сума");
    }
}

class InsufficientFundsException extends ATMException {
    public InsufficientFundsException() {
        super("Недостатньо коштів");
    }
}

class MaxNotesExceededException extends ATMException {
    public MaxNotesExceededException() {
        super("Перевищено максимальну кількість купюр");
    }
}
