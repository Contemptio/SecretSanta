package zmk.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for people giving and receiving gifts for the secret Santa game.
 * 
 * @author Zimon
 * @date 2017-06-03
 */
public class SantaPerson extends Person {
    private Person recipient = NullPerson.instance();
    private Person giver = NullPerson.instance();
    private List<String> exclusions;
    private String recipientName;

    /**
     * Constructs a {@code SantaPerson}, i.e. a person with a designated
     * recipient.
     * 
     * @param name
     *            The person's name.
     * @param email
     *            The person's e-mail address.
     */
    public SantaPerson(String name, String email) {
        super(name, email);
        this.exclusions = new ArrayList<String>();
    }

    /**
     * Constructs a {@code SantaPerson}, i.e. a person with a designated
     * recipient, from a set of arguments.
     * <p>
     * The required arguments are:
     * <ul>
     * <li>The person's name.</li>
     * <li>The person's e-mail address.</li>
     * <li>The name of the recipient of the gift given by this person.</li>
     * </ul>
     * 
     * @param data
     *            The string data used to construct this {@code SantaPerson}.
     */
    public SantaPerson(List<String> data) {
        super(data);
        recipientName = data.get(2);

        for (int i = 2; i < data.size(); ++i) {
            exclusions.add(data.get(i));
        }
    }

    /**
     * Retrieves the recipient.
     * 
     * @return the recipient.
     */
    public Person recipient() {
        return recipient;
    }

    /**
     * Retrieves the recipient name.
     * 
     * @return the recipient name.
     */
    public String recipientName() {
        return recipientName;
    }

    /**
     * Checks whether or not this person has a recipient.
     * 
     * @return
     *         {@code true} if this person has a recipient, {@code false}
     *         otherwise.
     */
    public boolean hasRecipient() {
        return !recipient.isNull();
    }

    /**
     * Sets the recipient of a gift from {@code this} person.
     * 
     * @param recipient
     *            The {@link Person} who should receive a gift from this person.
     * @return
     *         {@code true} if it was possible to set this person's recipient,
     *         i.e. this person did not have a recipient.
     */
    public boolean setRecipient(SantaPerson recipient) {
        if (hasRecipient()) {
            throw new UnsupportedOperationException("A recipient is already set for " + name + ".");
        }
        this.recipient = recipient;
        recipient.setGiver(this);
        return true;
    }

    /**
     * Sets a recipient, i.e. a person not equal to this person and not in the
     * exclusions' list.
     * 
     * @param people
     *            A map of names to people from which to choose a recipient.
     * @return
     *         {@code true} if it was possible to set a recipient, {@code false}
     *         otherwise.
     */
    public boolean setRecipient(Map<String, SantaPerson> people) {
        for (SantaPerson person : people.values()) {
            if (!equals(person) && !isExcluded(person) && !person.hasRecipient()) {
                setRecipient(person);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the giver, if this person has a giver.
     * 
     * @return the giver, if this person has a giver.
     */
    public Person giver() {
        return recipient;
    }

    /**
     * Retrieves the giver's name, if this person has a giver.
     * 
     * @return the giver's name, if this person has a giver.
     */
    public String giverName() {
        return giver.name();
    }

    /**
     * Checks whether or not this person has a giver.
     * 
     * @return
     *         {@code true} if this person has a giver, {@code false} otherwise.
     */
    public boolean hasGiver() {
        return !giver.isNull();
    }

    /**
     * Sets a giver for this person.
     * 
     * @param person
     *            The person who is to give this person a gift.
     * @return
     *         {@code true} if it was possible to set a giver for this person,
     *         i.e. if this person did not already have a giver.
     */
    public boolean setGiver(Person person) {
        if (hasGiver()) {
            throw new UnsupportedOperationException("A giver is already set for " + name + ".");
        }
        this.giver = person;
        return true;
    }

    /**
     * Checks whether or not a person is excluded from being the recipient of a
     * gift from {@code this}.
     * 
     * @param person
     *            A person for which it should be checked if it is excluded from
     *            being the recipient of a gift from {@code this}.
     * @return
     *         {@code true} if {@code person} is excluded, {@code false}
     *         otherwise.
     */
    public boolean isExcluded(Person person) {
        return !exclusions.contains(person.name());
    }

    /**
     * Builds a map for {@code SantaPerson} objects with set recipients.
     * 
     * @param list
     *            A list of data lists from which to construct people.
     * @return
     *         a map from people names to {@code SantaPerson} objects
     *         representing them.
     */
    public static Map<String, SantaPerson> getPeople(List<List<String>> list) {
        Map<String, SantaPerson> people = new HashMap<String, SantaPerson>();
        for (List<String> row : list) {
            SantaPerson person = new SantaPerson(row);
            people.put(person.name(), person);
        }
        List<String> names = new ArrayList<String>(people.keySet());
        for (String name : names) {
            people.get(name).setRecipient(people);
        }
        return people;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + recipient.name();
    }
}
