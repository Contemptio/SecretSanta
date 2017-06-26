package zmk.run;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import zmk.enumeration.EnumUtil;
import zmk.run.option.NoDefaultException;
import zmk.run.option.OptionRegistry;
import zmk.run.option.OptionSpecification;
import zmk.run.option.type.Option;

/**
 * Option registry for the Secret Santa program.
 * 
 * @author Zimon
 *
 */
public class SantaOptionRegistry extends OptionRegistry {

    private static Option<?>[] options = Option.create(SantaOptionSpecification.values());

    private enum SantaOptionSpecification implements Enumeration, OptionSpecification {
        ;

        private static final Map<String, OptionSpecification> stringToEnum = Collections
                .<String, OptionSpecification>unmodifiableMap(EnumUtil.stringMap(values()));

        private String name;
        private Object defaultValue;

        private SantaOptionSpecification(String name, Object defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
        }

        @Override
        public Option<?> option() {
            return Option.create(name, defaultValue);
        }

    };

    public SantaOptionRegistry(Arguments arguments) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Option<?> create(String option) throws NoDefaultException {
        // TODO I am so useful right now.
        return null;
    }

    @Override
    public Option<?> create(String option, String value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Option<?> create(String option, List<String> values) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Collection<Option<?>> options() {
        return Arrays.asList(options);
    }

}
