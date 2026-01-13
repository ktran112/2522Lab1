package ca.bcit.comp2522.bank;

/*
 * Represents the name of a person.
 * @author Kiet Tran
 * @version 1.0
 */
public class Name {

    private final String firstName;
    private final String lastName;
    private final int MAX_NAME_LEN = 45;

public Name(final String firstName, final String lastName)
{


    // Checks if either the first or last names are "admin".
    if (firstName.equalsIgnoreCase("admin") || lastName.equalsIgnoreCase("admin"))
    {
        throw new IllegalArgumentException("Name cannot be admin"); // Throws error if either name is admin
    }

    // Checks if first name is not null or empty.
    if ((firstName != null && !firstName.isEmpty() && firstName.length() < MAX_NAME_LEN))
    {
        this.firstName = firstName;
    } else {
        throw new IllegalArgumentException("First name is null or empty"); // Throws error if first name is null or empty
    }

    // Checks if last name is not null or empty.
    if ((lastName != null && !lastName.isEmpty() && lastName.length() < MAX_NAME_LEN))
    {
        this.lastName = lastName;
    } else {
        throw new IllegalArgumentException("Last name is null or empty"); // Throws error if last name is null or empty
    }

}


/*
 * Returns the first name of the full name.
 * @return this.first Name the first name
 */
public final String getFirst()
{
    return this.firstName;
}


/*
 * Returns the last name of the full name.
 * @return this.last Name the last name
 */
public final String getLast()
{
    return this.lastName;
}


/*
 * Forms the initials of the given name.
 * @return this.last Name the last name
 */
public final String getInitial()
{
    char firstInitial;
    char lastInitial;
    String initial;

    firstInitial = Character.toUpperCase(this.firstName.charAt(0));
    lastInitial = Character.toUpperCase(this.lastName.charAt(0));

    initial = "" + firstInitial + lastInitial;

    return initial;
}


public final String getReverseName()
{
    StringBuilder fullName;
    String reversedName;

    fullName = new StringBuilder();
    fullName.append(this.firstName);
    fullName.append(this.firstName);

    fullName.reverse();

    reversedName = fullName.toString();

    return reversedName;

}

}