package zmk.read;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import zmk.collection.ArrayList;

/**
 * File reader for CSV files.
 * 
 * @author Zimon
 * @date 2017-06-03
 */
public class CSVReader extends FileReader {
    /**
     * The delimiter for which to split CSV entries.
     */
    public static final String DELIMITER = "\\s+[,|;]\\s+";
    private List<List<String>> entries = new ArrayList<List<String>>();

    /**
     * Constructs a CSV file reader.
     * 
     * @param file
     *            The file to read.
     * @throws IOException
     *             if there was any error reading {@code file}.
     */
    public CSVReader(File file) throws IOException {
        super(file);
    }

    @Override
    public void read(File file) throws IOException {
        super.read(file);
        for (String line : lines) {
            entries.add(Arrays.asList(line.split(DELIMITER)));
        }
    }

    /**
     * Retrieves the entries parsed for the latest file.
     * 
     * @return the entries parsed for the latest file.
     */
    public List<List<String>> entries() {
        if (file == null) {
            throw new IllegalStateException("No file has been read yet.");
        }
        return entries;
    }
}
