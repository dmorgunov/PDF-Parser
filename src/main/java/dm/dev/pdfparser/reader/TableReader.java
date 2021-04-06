package dm.dev.pdfparser.reader;

import dm.dev.pdfparser.data.Row;
import dm.dev.pdfparser.data.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TableReader implements Reader {

    @Override
    public List<Table> read(final StringBuilder sb) {
        List<String> tableRows = Arrays.stream(sb.toString().split("\n"))
                .filter(s -> s.startsWith(" "))
                .map(String::trim)
                .collect(Collectors.toList());

        List<Table> tables = new ArrayList<>();
        List<Row> rows = new ArrayList<>();

        for (String row : tableRows) {
            if (StringUtils.isBlank(row)) {
                tables.add(new Table(rows));
                rows = new ArrayList<>();
                continue;
            }
            List<String> tableRow = Arrays.stream(row.split("  "))
                    .map(String::trim)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());
            rows.add(new Row(tableRow));
        }

        return tables;
    }
}
