package simulation;

import java.io.IOException;

interface I_CSVWriter {
    void appendRow(String[] rowData) throws IOException;

    void close() throws IOException;
}