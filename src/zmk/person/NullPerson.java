package zmk.person;

/**
 * Null object class for {@link Person}.
 * 
 * @author Zimon
 * @date 2017-06-03
 */
public final class NullPerson extends Person {
    private static final Person instance = new NullPerson();

    /**
     * Instantiates the {@link Person} null object.
     */
    private NullPerson() {
        super("NULL", "NULL");
    }

    /**
     * Retrieves the singleton instance of the null object.
     * 
     * @return the singleton instance of the null object.
     */
    public static final Person instance() {
        return instance;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
