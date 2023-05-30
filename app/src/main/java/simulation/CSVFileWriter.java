package simulation;

import java.io.FileWriter;
import java.io.IOException;

class CSVFileWriter implements I_CSVWriter {
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