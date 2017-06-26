package zmk.run;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import zmk.enumeration.EnumUtil;
import zmk.enumeration.EnumerationUtil;
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

    private enum SantaOptionSpecification implements OptionSpecification {
        ;

        private static final Map<String, OptionSpecification> stringToEnum = Collections
                .<String, OptionSpecification>unmodifiableMap(EnumerationUtil.stringMap(values()));

        private String name;
        private Option<?> option;
        private Object defaultValue;

        private SantaOptionSpecification(String name, Object defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
            this.option = Option.create(name, defaultValue);
        }

        @Override
        public String optionName() {
            return name;
        }

        @Override
        public Option<?> option() {
            return option;
        }

    };

    public SantaOptionRegistry(Arguments arguments) {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Collection<Option<?>> options() {
        return Arrays.asList(options);
    }

}
