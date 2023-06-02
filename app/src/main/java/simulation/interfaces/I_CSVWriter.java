package simulation.interfaces;

import java.io.IOException;

/**
 * Interface of CSVWriter class
 */
public interface I_CSVWriter {
    /**
     * Appends a row of data to the CSV file.
     *
     * @param rowData The array of data representing a row.
     * @throws IOException If an I/O error occurs.
     */
    void appendRow(String[] rowData) throws IOException;

    /**
     * Closes the CSV file.
     *
     * @throws IOException If an I/O error occurs.
     */
    void close() throws IOException;
}
