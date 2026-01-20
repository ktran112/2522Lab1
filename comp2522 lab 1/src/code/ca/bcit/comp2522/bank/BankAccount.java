package ca.bcit.comp2522.bank;

public class BankAccount {
    double balanceUsd;
    private final String accountNumber;
    private final int pin;

    /** Represents the minimum of characters a BankAccount can have. */
    private final int MIN_ACCOUNT_NUM_LENGTH = 6;
    /** Represents the maximum of characters a BankAccount can have. */
    private final int MAX_ACCOUNT_NUM_LENGTH = 7;

    BankClient client;
    Date accountOpened;
    Date accountClosed;

    //has to have a clinet, a 6/7 character account number, has
    //has a date for account opened, and has a date for account closed (can be null if not closed.)

    public BankAccount(final BankClient client, final String accountNumber, final Date accountOpened, final Date accountClosed, final int pin)
    {
        this.client = client;

        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.pin = pin;
        validateBankClient(client);
        validateAccountNumber(accountNumber);
        validateAccountOpened(accountOpened);
        validateAccountClosed(accountClosed);
        validatePin(pin);
    }

    /**
     * Withdraw function using only amountUsd.
     * @param amountUsd
     */

    private void withdraw(final double amountUsd)
    {
        if (balanceUsd >= amountUsd)
        {
            balanceUsd -= amountUsd;
        }
    }

    /**
     * Withdraw function using amountUsd and pinToMatch.
     * @param amountUsd
     * @param pinToMatch
     */
    private void withdraw(final double amountUsd, final int pinToMatch)
    {
        if (pinToMatch == pin)
        {
            //could probablby use this() for this code; to-do later.
            if (balanceUsd >= amountUsd)
            {
                balanceUsd -= amountUsd;
            }
        }
    }

    /**
     * Returns string representing the bank account details.
     */
    private void getDetails()
    {
        final StringBuilder accountDetails;
        final String clientName;
        final String accountBalance;
        final String accountOpenDate;
        final String accountCloseDate;

        clientName = client.getDetails();

        // amount usd. account number. opened date, closed date.
        //need a getDetails method that retunrs a string excatly in the format:
        // "Albert Einstein had $900 USD in account #abc123 which he
        //opened on Monday January 1, 1900 and closed Saturday October 14, 1950.
    }


    private void validatePin(int pin)
    {
        if (pin <= 9999 && pin >= 1000)
        {

        }
    }

    private void validateAccountClosed(Date accountClosed)
    {

    }

    private void validateAccountOpened(Date accountOpened)
    {

    }

    private void validateAccountNumber(final String accountNumber)
    {
        if(accountNumber.length() ==) {

        }
    }

    private void validateBankClient(BankClient client)
    {

    }
}
