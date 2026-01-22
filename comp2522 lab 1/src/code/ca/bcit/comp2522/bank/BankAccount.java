package ca.bcit.comp2522.bank;

/**
 * BankAccount class represents a bank account.
 * @author Umanga Bagai
 * @version 1.0
 */
public class BankAccount {

    private double balanceUsd;
    private final String accountNumber;
    private final int pin;
    private final Date accountOpened;
    private final Date accountClosed;
    private final BankClient client;

    /** Represents the minimum of characters a BankAccount can have. */
    private final int MIN_ACCOUNT_NUM_LENGTH = 6;

    /** Represents the maximum of characters a BankAccount can have. */
    private final int MAX_ACCOUNT_NUM_LENGTH = 7;

    /**
     * Constructor for the BankAccount Object. Acts as a master constructor.
     * @param client represents the client of the bank account.
     * @param accountNumber represents the accountNumber of the bank account.
     * @param accountOpened represents the date the account was opened.
     * @param accountClosed represents the date the account was closed. Null if not closed.
     * @param pin represents the pin to the account.
     */
    public BankAccount(final BankClient client,
                       final String accountNumber,
                       final Date accountOpened,
                       final Date accountClosed,
                       final int pin)
    {
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.pin = pin;

        validateBankClient(client);
        validateAccountNumber(accountNumber);
        validateAccountClosed(accountClosed, accountOpened);
        validateAccountOpened(accountOpened, accountClosed);
        validatePin(pin);

    }

    /**
     * Alternative Constructor for the bankAccount Object, with accountClosed as null.
     * @param client represents the client of the bank account.
     * @param accountNumber represents the accountNumber of the bank account.
     * @param accountOpened represents the date the account was opened.
     * @param pin represents the pin to the account.
     */
    public BankAccount(final BankClient client,
                       final String accountNumber,
                       final Date accountOpened,
                       final int pin)
    {
        this(client, accountNumber, accountOpened, null, pin);
    }


    /**
     * Validator or the pin.
     * Constraints
     *  - Cannot be Null
     * @param pin is the pin of the account.
     */
    private void validatePin(int pin)
    {
        if (pin >= 9999 || pin <= 1000)
        {
            throw new IllegalArgumentException("Pin not 4 digits; invalid pin."); // Throws error if pin is invalid.
        }

    }

    /**
     * Validates accountClosed date.
     * Constraints
     *  - Cannot be before the account was opened.
     * @param accountClosed is the date the account was closed.
     * @param accountOpened is the date that the account was opened.
     */
    private void validateAccountClosed(Date accountClosed, Date accountOpened) {
        if (accountClosed != null && accountClosed.getYYYYMMDD().compareTo(accountOpened.getYYYYMMDD()) < 0) {
            throw new IllegalArgumentException("Account closed before account opened. Invalid dates.");
        }
    }

    /**
     * Validates accountOpened date.
     * Constraints
     *  - Cannot be Null.
     *  - Cannot be past account Closed date.
     * @param accountOpened is the date the account was opened.
     * @param accountClosed is the date the account was closed.
     */
    private void validateAccountOpened(Date accountOpened, Date accountClosed) {
        if (accountOpened == null) {
            throw new IllegalArgumentException("accountOpened date cannot be null");
        } else
        if (accountClosed != null && accountOpened.getYYYYMMDD().compareTo(accountClosed.getYYYYMMDD()) > 0) {
            throw new IllegalArgumentException("Account opened after account closed. Invalid dates.");
        }
    }

    /**
     * Validates Account number.
     * Constraints
     *  - Cannot be null.
     *  - Not within defined min to max account number lengths.
     * @param accountNumber is the ID differentiating accounts.
     */
    private void validateAccountNumber(final String accountNumber)
    {
        if (accountNumber == null) {
            throw new IllegalArgumentException("Account Number cannot be null.");
        }

        if (!(accountNumber.length() == MIN_ACCOUNT_NUM_LENGTH) &&
                !(accountNumber.length() == MAX_ACCOUNT_NUM_LENGTH) )
        {
            throw new IllegalArgumentException("Account Number is not within" +
                    MIN_ACCOUNT_NUM_LENGTH + " to " + MAX_ACCOUNT_NUM_LENGTH + "."); //Throws error if the account number length doesn't match the format.
        }
    }

    /**
     * Validates the bankClient.
     * Constraints
     *  - cannot be null.
     * @param client is the bank account's owner.
     */
    private void validateBankClient(BankClient client)
    {
        if (client == null)
        {
            throw new IllegalArgumentException("Bank client does not exist."); //Throws error if bank client doesn't exist.
        }
    }

    /**
     * Withdraw function using only amountUsd.
     * @param amountUsd is the balance attempting to be withdrawn.
     */

    public void withdraw(final double amountUsd)
    {
        if (balanceUsd >= amountUsd  || amountUsd >= 0)
        {
            balanceUsd -= amountUsd;
        }
    }


    /**
     * Deposit function using amountUsd and pinToMatch.
     * @param amountUsd is the amount in USD to be deposited.
     * @param pinToMatch is the inputted pin
     */
    public void deposit(final double amountUsd,
                        final int pinToMatch)
    {
        if (pinToMatch == pin || amountUsd >= 0)
        {
            balanceUsd += amountUsd;
        }
    }


    /**
     * Withdraw function using amountUsd and pinToMatch.
     * @param amountUsd is the balance attempting to be withdrawn.
     * @param pinToMatch is the inputted pin.
     */
    public void withdraw(final double amountUsd,
                         final int pinToMatch)
    {
        if (pinToMatch == pin || amountUsd >= 0)
        {
            if (balanceUsd >= amountUsd)
            {
                balanceUsd -= amountUsd;
            }
        }

    }

    /**
     * Returns string representing the bank account details.
     */
    public final String getDetails()
    {
        final StringBuilder detailsBuilder;
        final String accountDetails;
        final String clientName;
        final String accountBalance;
        final String accountOpenDate;
        final String accountCloseDate;
        final String accountNum;


        detailsBuilder = new StringBuilder();

        clientName = client.getName().getFullName();

        accountBalance = " had $" + balanceUsd + " USD ";

        accountNum = "in account #" + accountNumber + " ";

        accountOpenDate = "which he opened " + accountOpened.getFormattedDate() + " ";

        if (accountClosed == null) {
            accountCloseDate = "to present.";
        } else
        {
            accountCloseDate = "and closed " + accountClosed.getFormattedDate() + ".";
        }

        detailsBuilder.append(clientName);
        detailsBuilder.append(accountBalance);
        detailsBuilder.append(accountNum);
        detailsBuilder.append(accountOpenDate);
        detailsBuilder.append(accountCloseDate);

        accountDetails = detailsBuilder.toString();

        return accountDetails;
    }
}
