package ca.bcit.comp2522.bank;

/**
 * This class represents a client of the bank.
 * Keeps details of the client, such as date of birth, clientID, and more.
 * @author Kiet Tran
 * @version 1.0
 */
public class BankClient
{

    private final Name fullName;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;

    /** This represents the minimum amounts of characters a client ID needs */
    private int MIN_CHARACTER_ID = 6;

    /** This represents the maximum amounts of characters a client ID needs */
    private int MAX_CHARACTER_ID = 7;

    /**
     * This constructs the BankClient object. Acts as the master constructor.
     * @param fullName first and last name
     * @param birthDate date of birth
     * @param deathDate date of death if applicable
     * @param signupDate date of signup
     * @param clientID the ID that differentiates clients
     */
    public BankClient(final Name fullName, final Date birthDate, final Date deathDate, final Date signupDate, final String clientID)
    {
        // Checks if the name of the client is null
        if (fullName != null)
        {
        this.fullName = fullName;
        } else {
            throw new IllegalArgumentException("Name is null"); // If the name is null, then an error is thrown
        }

        // Checks if the name of the client is null
        if (birthDate != null)
        {
            this.birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Birth Date is null"); // If the birthdate is null, then an error is thrown
        }

        // Checks if the client ID is null or if it does not follow character amount restrictions
        if (clientID != null && clientID.length() >= MIN_CHARACTER_ID && clientID.length() <= MAX_CHARACTER_ID)
        {
            this.clientID = clientID;
        } else {
            throw new IllegalArgumentException("Client ID is not within the required length or is null"); // If the client ID is either not the correct length or null, then an error is thrown
        }

        // Checks if the signup date is null
        if (signupDate != null)
        {
            this.signupDate = signupDate;
        } else {
            throw new IllegalArgumentException("Signup date is null"); // If the signup date is null, then an error is thrown
        }

        // Death date is allowed to be null, as everyone has not died yet
        this.deathDate = deathDate;


    }

    /**
     * Alternative constructor for BankClient object that omits the death date
     * @param fullName first and last name
     * @param birthDate date of birth
     * @param signupDate date of signup
     * @param clientID the ID that differentiates clients
     */
    public BankClient(final Name fullName, final Date birthDate, final Date signupDate, final String clientID)
    {
        this(fullName, birthDate, null, signupDate, clientID);
    }


    /**
     * Checks whether the client is still alive.
     * @return alive status (true or false)
     */
    public final boolean isAlive()
    {
        final boolean alive;

        if (this.deathDate == null) {
            alive = true;
        } else
        {
            alive = false;
        }

        return alive;
    }


    /**
     * Creates a statement regarding the client's name, mortality status, and signup date.
     * @return full statement
     */
    public final String getDetails() {
        final StringBuilder statementParser;
        final String clientIDStatement;
        final String mortalityStatement;
        final String signupStatement;
        final String fullStatement;

        clientIDStatement = " client " + this.clientID;

        if (isAlive()) {
            mortalityStatement = " (alive) ";
        } else {
            mortalityStatement = " (died on " + this.deathDate.toString() + ") ";
        }

        signupStatement = "joined the bank on " + this.signupDate.toString();

        statementParser = new StringBuilder();
        statementParser.append(this.fullName);
        statementParser.append(clientIDStatement);
        statementParser.append(mortalityStatement);
        statementParser.append(signupStatement);

        fullStatement = statementParser.toString();

        return fullStatement;


 /*

 // This is the old version of getDetails()

    /**
     * Creates a statement regarding the client's name, mortality status, and date of birth.
     * @return full statement
     /
    public final String getDetails()
    {
        final StringBuilder statementParser;
        final String mortalityStatus;
        final String birthStatement;
        final String fullStatement;

        if (isAlive())
        {
            mortalityStatus = " (alive) ";
        } else
        {
            mortalityStatus = " (died on " + deathDate.toString() + ") ";
        }

        birthStatement = "was born on " + birthDate.toString() + "!";

        statementParser = new StringBuilder();
        statementParser.append(this.fullName);
        statementParser.append(mortalityStatus);
        statementParser.append(birthStatement);

        fullStatement = statementParser.toString();

        return fullStatement;
    }

 */
    }


}
