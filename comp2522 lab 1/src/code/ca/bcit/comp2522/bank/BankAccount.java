package ca.bcit.comp2522.bank;

public class BankAccount {
    double balanceUsd;
    String accountNumber;
    int pin;
    BankClient client;
    Date accountOpened;
    Date accountClosed;
    //has to have a clinet, a 6/7 character account number, has
//    has a date for account opened, and has a date for account closed (can be null if not closed.)

    /**
     * Withdraw function using only amountUsd.
     * @param amountUsd
     */
    private void withdraw(final double amountUsd) {

    }

    /**
     * Withdraw function using amountUsd and pinToMatch.
     * @param amountUsd
     * @param pinToMatch
     */
    private void withdraw(final double amountUsd, final int pinToMatch) {

    }

    /**
     * Returns string representing the bank account details.
     */
    private void getDetails() {
        String details;
        details = client.fullName
        // amount usd. account number. opened date, closed date.
        //need a getDetails method that retunrs a string excatly in the format:
        // "Albert Einstein had $900 USD in account #abc123 which he
        //opened on Monday January 1, 1900 and closed Saturday October 14, 1950.
    }
}
