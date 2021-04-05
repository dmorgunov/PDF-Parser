package dm.dev.pdfparser.helper;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

public class RegexpHelper {

    public static List<String> find(StringBuilder sb, Matcher matcher) {
        List<String> list = new LinkedList<>();
        while (matcher.find()) {
            list.add(sb.substring(matcher.start(), matcher.end()));
        }
        return list;
    }
}
