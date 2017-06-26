package zmk.person;

import java.util.List;

/**
 * Class representing a person (with an e-mail address).
 * 
 * @author Zimon
 * @date 2017-06-03
 */
public class Person {
    protected String name;
    protected String email;

    /**
     * Constructs a {@code Person}.
     * 
     * @param name
     *            the person's name.
     * @param email
     *            the person's e-mail address.
     */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Constructs a {@code Person} from a set of arguments.
     * <p>
     * The required arguments are:
     * <ul>
     * <li>The person's name.</li>
     * <li>The person's e-mail address.</li>
     * </ul>
     * 
     * @param data
     *            The string data used to construct this {@code Person}.
     */
    public Person(List<String> data) {

    }

    /**
     * Retrieves the person's name.
     * 
     * @return the person's name.
     */
    public String name() {
        return name;
    }

    /**
     * Retrieves the person's e-mail address.
     * 
     * @return the person's e-mail address.
     */
    public String email() {
        return email;
    }

    /**
     * Checks whether or not {@code this} instance is a null object.
     * 
     * @return {@code true} if {@code this} is an instance of
     *         {@link NullPerson}, {@code false} otherwise.
     */
    public boolean isNull() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, email);
    }
}
