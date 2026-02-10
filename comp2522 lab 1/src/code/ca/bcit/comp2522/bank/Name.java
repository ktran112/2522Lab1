package ca.bcit.comp2522.bank;

/**
 * Represents the name of a person.
 *
 * @author Kiet Tran
 * @author Umanga Bagai
 *
 * @version 1.0
 */
public class Name {

    private final static int MAX_NAME_LEN = 150000;

    private final String firstName;
    private final String lastName;
    private final char firstInitial;
    private final char lastInitial;

    /**
     * This constructs the Name object.
     * @param firstName the first name of the name object.
     * @param lastName the last name of the name object.
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateFullName(firstName, lastName);

        StringBuilder firstNameFirstLetterCapitalize;
        StringBuilder lastNameFirstLetterCapitalize;

        firstNameFirstLetterCapitalize = new StringBuilder();
        lastNameFirstLetterCapitalize = new StringBuilder();

        this.firstInitial = Character.toUpperCase(firstName.charAt(0));

        firstNameFirstLetterCapitalize.append(firstName.toLowerCase());
        firstNameFirstLetterCapitalize.setCharAt(0, this.firstInitial);

        this.firstName = firstNameFirstLetterCapitalize.toString();

        this.lastInitial = Character.toUpperCase(lastName.charAt(0));

        lastNameFirstLetterCapitalize.append(lastName.toLowerCase());
        lastNameFirstLetterCapitalize.setCharAt(0, this.lastInitial);

        this.lastName = lastNameFirstLetterCapitalize.toString(); // Initializes last name with proper capitalization.
    }

    /*
     * Validator method for both the first and last name.
     * Constraints
     * - Cannot have the name "admin" for either the first or last name
     * - Cannot be null for either the first or last name
     * - Cannot have Blank name (Blank argument)
     * - Cannot have a name longer then 45 characters
     */
    private final void validateFullName(final String firstName,
                                        final  String lastName)
    {
        if (firstName.equalsIgnoreCase("admin") ||
            lastName.equalsIgnoreCase("admin") ||
            firstName.equalsIgnoreCase("administrator")||
            lastName.equalsIgnoreCase("administrator"))

        {
            throw new IllegalArgumentException("Name cannot be admin or administrator");
        }

        if (firstName == null ||
            firstName.isBlank() ||
            firstName.length() > MAX_NAME_LEN)

        {
            throw new IllegalArgumentException("First name is null or Blank");
        }

        if (lastName == null ||
            lastName.isBlank() ||
            lastName.length() > MAX_NAME_LEN)

        {
            throw new IllegalArgumentException("Last name is null or Blank");
        }
    }

    /**
     * Returns the full name.
     * @return the full name.
     */
    public final String getFullName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Returns the first name of the full name.
     * @return firstName is the first name.
     */
    public final String getFirst()
    {
        return this.firstName;
    }

    /**
     * Returns the last name of the full name.
     * @return the lastName is the last name.
     */
    public final String getLast()
    {
        return this.lastName;
    }

    /**
     * Forms the initials of the given name.
     * @return the initials of the full name
     */
    public final String getInitial()
    {
        final StringBuilder initialParser;
        final String initial;

        initialParser = new StringBuilder();

        initialParser.append(this.firstInitial);
        initialParser.append('.');
        initialParser.append(this.lastInitial);
        initialParser.append('.');

        initial = initialParser.toString();

        return initial;
    }

    /**
     * Forms the initials of the given name.
     * @return the full name reverse
     */
    public final String getReverseName()
    {
        final StringBuilder nameReverser;
        final String reversedName;

        nameReverser = new StringBuilder();
        nameReverser.append(this.lastName);
        nameReverser.append(" ");
        nameReverser.append(this.firstName);

        nameReverser.reverse();

        reversedName = nameReverser.toString();

        return reversedName;
    }

    /**
     * Produces a detailed string regarding the name, including first and last name, and its initials.
     * @return details
     */
    public final String getDetails()
    {
        StringBuilder detailParser;
        String firstName;
        String lastName;
        String firstInitial;
        String lastInitial;

        detailParser = new StringBuilder();
        firstName = "First Name: " + this.firstName;
        lastName = "\nLast Name: " + this.lastName;
        firstInitial = "\nFirst Initial: " + this.firstInitial;
        lastInitial = "\nLast Initial: " + this.lastInitial;

        detailParser.append(firstName);
        detailParser.append(lastName);
        detailParser.append(firstInitial);
        detailParser.append(lastInitial);

        return detailParser.toString();
    }
}