package simulation.interfaces;

import java.io.IOException;

public interface I_CSVWriter {
    void appendRow(String[] rowData) throws IOException;

    void close() throws IOException;
}