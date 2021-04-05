package dm.dev.pdfparser.reader;

import java.util.List;

public interface Reader {
    List<?> read(StringBuilder sb);
}
