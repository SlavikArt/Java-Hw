package Task_1;

public class ATM {
    private final int[] denominations;
    private final int[] counts;
    private final int minWithdrawal;
    private final int maxNotes;

    public ATM(int[] denominations, int[] counts,
               int minWithdrawal, int maxNotes) throws ATMException {
        if (denominations.length != counts.length)
            throw new ATMException("Масиви номіналів і кількостей повинні мати однакову довжину.");
        this.minWithdrawal = minWithdrawal;
        this.maxNotes = maxNotes;

        this.denominations = new int[denominations.length];
        this.counts = new int[counts.length];
        for (int i = 0; i < denominations.length; i++) {
            this.denominations[i] = denominations[i];
            this.counts[i] = counts[i];
        }

        for (int i = 0; i < this.denominations.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < this.denominations.length; j++)
                if (this.denominations[j] < this.denominations[minIndex])
                    minIndex = j;

            swap(this.denominations, i, minIndex);
            swap(this.counts, i, minIndex);
        }
    }

    public void deposit(int[] depositedCounts) throws ATMException {
        if (depositedCounts.length != counts.length)
            throw new InvalidAmountException();
        for (int i = 0; i < counts.length; i++) {
            if (depositedCounts[i] < 0)
                throw new InvalidAmountException();
            counts[i] += depositedCounts[i];
        }
    }

    public int[] withdraw(int amount) throws ATMException {
        if (amount < minWithdrawal)
            throw new InvalidAmountException();
        if (amount > getTotal())
            throw new InsufficientFundsException();

        int[] result = new int[denominations.length];
        int remaining = amount;
        int totalNotes = 0;

        for (int i = denominations.length - 1; i >= 0; i--) {
            if (remaining <= 0)
                break;
            int available = counts[i];
            int needed = remaining / denominations[i];
            int use = Math.min(needed, available);
            use = Math.min(use, maxNotes - totalNotes);

            result[i] = use;
            remaining -= use * denominations[i];
            totalNotes += use;
        }

        if (remaining != 0)
            throw new InsufficientFundsException();
        if (totalNotes > maxNotes)
            throw new MaxNotesExceededException();

        for (int i = 0; i < counts.length; i++)
            counts[i] -= result[i];
        return result;
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < denominations.length; i++)
            total += denominations[i] * counts[i];
        return total;
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < denominations.length; i++)
            sb.append(denominations[i]).append(" грн: ").append(counts[i]).append("\n");
        return sb.toString();
    }

    public int[] getDenominations() {
        return denominations;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
