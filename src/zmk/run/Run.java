package zmk.run;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import zmk.person.SantaPerson;
import zmk.read.CSVReader;

/**
 * 
 * @author Zimon
 *
 */
public class Run {

    /**
     * 
     * @param args
     *            The expected arguments to this program:
     *            <ul>
     *            <li>{@code -f} &lt;filePath&gt; The file from which to read
     *            people.</li>
     *            </ul>
     * @throws IOException
     *             if there was any error reading the file specified by
     *             {@code -f}.
     */
    public static void main(String[] args) throws IOException {
        Map<String, SantaPerson> people = SantaPerson.getPeople(
                new CSVReader(new File(new SantaOptionRegistry(new Arguments(args)).get("f").value())).entries());
        for (String name : people.keySet()) {
            System.out.println(people.get(name));
        }
    }
}
