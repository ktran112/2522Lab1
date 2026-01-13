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





}
