package simulation;

import java.io.FileWriter;
import java.io.IOException;

interface CSVWriter {
    void appendRow(String[] rowData) throws IOException;

    void close() throws IOException;
}

class CSVFileWriter implements CSVWriter {
    private FileWriter fileWriter;

    public CSVFileWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true);
    }

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

    public void close() throws IOException {
        fileWriter.close();
    }
}

class CSVFileWorker {
    private CSVWriter csvWriter;

    public CSVFileWorker(String fileName) throws IOException {
        csvWriter = new CSVFileWriter(fileName);
        String[] headerRow = {"Cycle", "Width", "Height", "Cells", ""};
        csvWriter.appendRow(headerRow);
    }

    public void appendData(String[] rowData) throws IOException {
        csvWriter.appendRow(rowData);
    }

    public void close() throws IOException {
        csvWriter.close();
    }
}