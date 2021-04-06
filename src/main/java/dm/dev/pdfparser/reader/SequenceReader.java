package dm.dev.pdfparser.reader;

import dm.dev.pdfparser.helper.RegexpHelper;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class SequenceReader implements Reader {

    private final String sequenceElement = "(([A-Z]{1,2}[a-z]{1,20}([ ]([A-Za-z]{1,20})){0,2}) \\d{1,4})";
    private final String delimiter = ", ";
    private final String endOfSequence = "[. ]?";
    private final String elementsInSequence = String.format("(%s)+", sequenceElement + delimiter)
            + sequenceElement + endOfSequence;

    @Override
    public List<String> read(final StringBuilder sb) {
        Pattern sequencePattern = Pattern.compile(elementsInSequence);
        Matcher matcher = sequencePattern.matcher(sb.toString());
        return RegexpHelper.find(sb, matcher);
    }
}
