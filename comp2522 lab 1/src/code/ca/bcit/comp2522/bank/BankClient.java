package ca.bcit.comp2522.bank;

/**
 * This class represents a client of the bank.
 * Keeps details of the client, such as date of birth, clientID, and more.
 * @author Kiet Tran
 * @version 1.0
 */
public class BankClient
{

    private static final int MIN_CHARACTER_ID = 6;
    private static final int MAX_CHARACTER_ID = 7;

    private final Name fullName;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;



    /**
     * This constructs the BankClient object. Acts as the master constructor.
     * @param fullName first and last name
     * @param birthDate date of birth
     * @param deathDate date of death if applicable
     * @param signupDate date of signup
     * @param clientID the ID that differentiates clients
     */
    public BankClient(final Name fullName,
                      final Date birthDate,
                      final Date deathDate,
                      final Date signupDate,
                      final String clientID)
    {
        // Validator methods.
        validateFullName(fullName); // Cannot be null
        validateBirthDate(birthDate); // Cannot be null
        validateSignupDate(signupDate); // Cannot be null
        validateClientID(clientID); // Cannot be null or outside the bounds between MIN_CHARACTER_ID and MAX_CHARACTER ID (inclusive)

        // Initialization after validation is successful.
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.signupDate = signupDate;
        this.clientID = clientID;

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
    public BankClient(final Name fullName,
                      final Date birthDate,
                      final Date signupDate,
                      final String clientID)
    {
        this(fullName, birthDate, null, signupDate, clientID);
    }



    /* Validator method for full name.
     * Constraints
     * - Cannot be null
     */
    private final void validateFullName(final Name fullName)
    {
        // Checks if the name of the client is null
        if (fullName == null)

        {
            throw new IllegalArgumentException("Name is null"); // If the name is null, then an error is thrown
        }
    }



    /* Validator method for birthdate.
     * Constraints
     * - Cannot be null
     */
    private final void validateBirthDate(final Date birthDate)
    {
        // Checks if the birthdate of the client is null
        if (birthDate == null)

        {
            throw new IllegalArgumentException("Birth Date is null"); // If the birthdate is null, then an error is thrown
        }
    }



    /* Validator method for client ID.
     * Constraints
     * - Cannot be null
     * - Cannot be lesser than 6
     * - Cannot be greater than 7
     */
    private final void validateClientID(final String clientID)
    {
        // Checks if the client ID is null or if it does not follow character amount restrictions
        if (clientID == null ||
            clientID.length() < MIN_CHARACTER_ID ||
            clientID.length() > MAX_CHARACTER_ID)

        {
            throw new IllegalArgumentException("Client ID is not within the required length or is null"); // If the client ID is either not the correct length or null, then an error is thrown
        }
    }



    /*
     * Validator method for signup.
     * Constraints
     * - Cannot be null
     */
    private final void validateSignupDate(final Date signupDate)
    {
        // Checks if the signup date is null
        if (signupDate == null)

        {
            throw new IllegalArgumentException("Signup date is null"); // If the signup date is null, then an error is thrown
        }
    }



    /**
     * Provides the Name object.
     * @return Name object
     */
    public final Name getName()
    {
        return this.fullName;
    }



    /**
     * Provides the Date object of the death date.
     * @return death date
     */
    public final Date getDeathDate()
    {
        return this.deathDate;
    }



    /**
     * Provides the Date object of the signup date.
     * @return signup date
     */
    public final Date getSignupDate()
    {
        return this.signupDate;
    }



    /**
     * Provides the client ID.
     * @return client ID
     */
    public final String getClientID()
    {
        return this.clientID;
    }



    /**
     * Checks whether the client is still alive.
     * @return alive status (true or false)
     */
    public final boolean isAlive()
    {
        final boolean alive;

        if (this.deathDate == null)

        {
            alive = true;
        }

        else

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
        final String fullName;
        final String clientIDStatement;
        final String mortalityStatement;
        final String signupStatement;
        final String fullStatement;

        statementParser = new StringBuilder();


        fullName = this.fullName.getFullName();

        clientIDStatement = " client " + this.clientID;

        if (isAlive())

        {
            mortalityStatement = " (alive) ";
        }

        else

        {
            mortalityStatement = " (died on " + this.deathDate.getFormattedDate() + ") ";
        }

        signupStatement = "joined the bank on " + this.signupDate.getFormattedDate();

        statementParser.append(fullName);
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
