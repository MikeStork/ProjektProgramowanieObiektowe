package simulation.workers;

import simulation.interfaces.I_CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class provides functionality for writing data to a CSV file.
 */
class CSVFileWriter implements I_CSVWriter {
    private FileWriter fileWriter;

    /**
     * Constructs a CSVFileWriter object with the specified file name.
     *
     * @param fileName the name of the CSV file
     * @throws IOException if an I/O error occurs
     */
    public CSVFileWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true);
    }

    /**
     * Appends a row of data to the CSV file.
     *
     * @param rowData the data to append
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void appendRow(String[] rowData) throws IOException {
        StringBuilder row = new StringBuilder();

        for (String data : rowData) {
            row.append(data).append(",");
        }

        row.deleteCharAt(row.length() - 1);

        fileWriter.append(row.toString()).append("\n");
        fileWriter.flush();
    }

    /**
     * Closes the CSV file.
     *
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {
        fileWriter.close();
    }
}