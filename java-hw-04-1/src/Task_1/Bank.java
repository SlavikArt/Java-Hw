package Task_1;

public class Bank {
    private final ATM[] atms;

    public Bank(int atmCount) {
        this.atms = new ATM[atmCount];
    }

    public void initATM(int index, int[] denominations, int[] counts,
                        int minWithdrawal, int maxNotes) throws ATMException {
        if (index < 0 || index >= atms.length)
            throw new ATMException("Невірний індекс банкомату");
        atms[index] = new ATM(denominations, counts, minWithdrawal, maxNotes);
    }

    public int getTotalMoney() {
        int total = 0;
        for (int i = 0; i < atms.length; i++)
            if (atms[i] != null)
                total += atms[i].getTotal();
        return total;
    }

    public ATM getATM(int index) throws ATMException {
        if (index < 0 || index >= atms.length || atms[index] == null)
            throw new ATMException("Банкомат не існує");
        return atms[index];
    }
}
