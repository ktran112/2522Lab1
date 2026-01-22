package ca.bcit.comp2522.bank;

/*
 * Represents the name of a person.
 * @author Kiet Tran
 * @version 1.0
 */
public class Name {


    private final String firstName;
    private final String lastName;
    private final char firstInitial;
    private final char lastInitial;

    private final int MAX_NAME_LEN = 45;


    /**
     * This constructs the Name object. Both first and last names must be neither null nor blank nor longer than 45 characters.
     * @param firstName the first name
     * @param lastName the last name
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateFullName(firstName, lastName); // Checks if name violates constraints.

        StringBuilder firstNameFirstLetterCapitalize; // This will capitalize the first letter of the first name.
        StringBuilder lastNameFirstLetterCapitalize; // This will capitalize the first letter of the last name.

        firstNameFirstLetterCapitalize = new StringBuilder();
        lastNameFirstLetterCapitalize = new StringBuilder();

        this.firstInitial = Character.toUpperCase(firstName.charAt(0)); // Uppercases first letter.

        // Capitalizes the first letter of the first name.
        firstNameFirstLetterCapitalize.append(firstName.toLowerCase());
        firstNameFirstLetterCapitalize.setCharAt(0, this.firstInitial);

        this.firstName = firstNameFirstLetterCapitalize.toString(); // Initializes first name with proper capitalization.

        this.lastInitial = Character.toUpperCase(lastName.charAt(0)); // Uppercases first letter.

        // Capitalizes the first letter of the last name.
        lastNameFirstLetterCapitalize.append(lastName.toLowerCase());
        lastNameFirstLetterCapitalize.setCharAt(0, this.lastInitial);

        this.lastName = lastNameFirstLetterCapitalize.toString(); // Initializes last name with proper capitalization.
    }



    /* Validator method for both the first and last name.
     * Constraints
     * - Cannot have the name "admin" for either the first or last name
     * - Cannot be null for either the first or last name
     * - Cannot have empty name (empty argument)
     * - Cannot have a name longer then 45 characters
     */
    private final void validateFullName(final String firstName,
                                        final  String lastName)
    {
        // Checks if either the first or last names are "admin" or "administrator".
        if (firstName.equalsIgnoreCase("admin") ||
            lastName.equalsIgnoreCase("admin") ||
            firstName.equalsIgnoreCase("administrator")||
            lastName.equalsIgnoreCase("administrator"))

        {
            throw new IllegalArgumentException("Name cannot be admin or administrator"); // Throws error if either name is admin or administrator.
        }

        // Checks if first name is not null or empty.
        if (firstName == null ||
            firstName.isEmpty() ||
            firstName.length() > MAX_NAME_LEN)

        {
            throw new IllegalArgumentException("First name is null or empty"); // Throws error if first name is null or empty.
        }

        // Checks if last name is not null or empty.
        if (lastName == null ||
            lastName.isEmpty() ||
            lastName.length() > MAX_NAME_LEN)

        {
            throw new IllegalArgumentException("Last name is null or empty"); // Throws error if last name is null or empty.
        }
    }



    /**
     * Returns the full name.
     * @return the full name
     */
    public final String getFullName()
    {
        return firstName + " " + lastName;
    }



    /**
     * Returns the first name of the full name.
     * @return the first name
     */
    public final String getFirst()
    {
        return this.firstName;
    }



    /**
     * Returns the last name of the full name.
     * @return the last name
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
        final StringBuilder initialParser; // This will form the "A.B." format.
        final String initial;

        initialParser = new StringBuilder();

        // Builds the "A.B." format for the initial.
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
        final StringBuilder nameReverser; // This will reverse the full name.
        final String reversedName;

        // Forms the full name.
        nameReverser = new StringBuilder();
        nameReverser.append(this.lastName);
        nameReverser.append(" ");
        nameReverser.append(this.firstName);

        nameReverser.reverse(); // Reverses the name.

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