package zmk.read;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import zmk.file.util.FileReadUtil;

/**
 * Class for reading files.
 * 
 * @author Zimon
 * @date 2017-06-03
 */
public abstract class FileReader {
    protected File file;
    protected List<String> lines;

    /**
     * Constructs a file reader.
     */
    public FileReader() {}

    /**
     * Constructs a file reader which immediately processes a file.
     * 
     * @param file
     *            The file to read.
     * @throws IOException
     *             if there was any error reading {@code file}.
     */
    public FileReader(File file) throws IOException {
        read(file);
    }

    /**
     * Retrieves the file used by this {@code FileReader}.
     * 
     * @return the file used by this {@code FileReader}.
     */
    public File file() {
        return file;
    }

    /**
     * Retrieves a non-editable listing of all the lines in this file.
     * 
     * @return a non-editable listing of all the lines in this file.
     */
    public List<String> asLines() {
        return lines;
    }

    /**
     * Reads a file.
     * 
     * @param file
     *            The file to read.
     * @throws IOException
     *             if there was any error reading {@code file}.
     */
    public void read(File file) throws IOException {
        this.file = file;
        this.lines = Collections.<String>unmodifiableList(FileReadUtil.fileAsLines(file));
    }
}
