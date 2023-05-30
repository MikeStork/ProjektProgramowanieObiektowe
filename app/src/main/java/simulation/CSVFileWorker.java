package simulation;

import java.io.IOException;
import java.util.Arrays;

public class CSVFileWorker {
    private CSVWriter csvWriter;

    public CSVFileWorker(String fileName) throws IOException {
        csvWriter = new CSVFileWriter(fileName);
        String[] headerRow = {"Cycle", "Width", "Height", "Cells", "Weed", "Cats","Birds","Fish","Tigers","Cougars","Eagles","Pikes","Amfiprions","Storks"};
        csvWriter.appendRow(headerRow);
    }

    public void appendData(int[] inputData) throws IOException {
        String[] rowData = Arrays.stream(inputData)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        csvWriter.appendRow(rowData);
    }

    public void close() throws IOException {
        csvWriter.close();
    }
}