package dm.dev.pdfparser;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import dm.dev.pdfparser.reader.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class PdfParserApplication implements CommandLineRunner {
    @Value("classpath:example.pdf")
    private Resource resourceFile;

    @Autowired
    private List<Reader> readers;

    public static void main(String[] args) {
        SpringApplication.run(PdfParserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PdfReader pdfReader = new PdfReader(resourceFile.getInputStream());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            String textFromPage = PdfTextExtractor.getTextFromPage(pdfReader, i);
            sb.append(textFromPage);
        }


        Map<Reader, List<?>> readerToResult = new HashMap<>();
        readers.forEach(r -> {
            readerToResult.put(r, r.read(sb)); // todo sb should be unmodifiable
        });
        System.out.println(readerToResult);
    }

}
