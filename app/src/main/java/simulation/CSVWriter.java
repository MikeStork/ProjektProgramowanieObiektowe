package simulation;

import java.io.IOException;

interface CSVWriter {
    void appendRow(String[] rowData) throws IOException;

    void close() throws IOException;
}