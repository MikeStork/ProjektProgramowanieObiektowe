package simulation.workers;

import simulation.interfaces.I_CSVWriter;

import java.io.IOException;
import java.util.Arrays;

/**
 * This class provides functionality for working with CSV files.
 */
public class CSVFileWorker {
    private I_CSVWriter csvWriter;

    /**
     * Constructs a CSVFileWorker object with the specified file name.
     *
     * @param fileName the name of the CSV file
     * @throws IOException if an I/O error occurs
     */
    public CSVFileWorker(String fileName) throws IOException {
        csvWriter = new CSVFileWriter(fileName);
        String[] headerRow = {"Cycle", "Width", "Height", "Cells", "Weed", "Cats","Birds","Fish","Tigers","Cougars","Eagles","Pikes","Amfiprions","Storks"};
        csvWriter.appendRow(headerRow);
    }

    /**
     * Appends the given data to the CSV file.
     *
     * @param inputData the data to append
     * @throws IOException if an I/O error occurs
     */
    public void appendData(int[] inputData) throws IOException {
        String[] rowData = Arrays.stream(inputData)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        csvWriter.appendRow(rowData);
    }

    /**
     * Closes the CSV file.
     *
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException {
        csvWriter.close();
    }
}