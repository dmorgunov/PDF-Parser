package dm.dev.pdfparser;

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

	public static void main(String[] args) {
		SpringApplication.run(PdfParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i <= 3; i++) {
//			PDDocument pdDocument = PDDocument.load(resourceFile.getInputStream());
//			ObjectExtractor extractor = new ObjectExtractor(pdDocument);
//			Page page = extractor.extract(i);



		}
	}
}
