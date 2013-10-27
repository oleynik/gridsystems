package ua.infinity.studies.gridsystems.lab3;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date: 27.10.2013
 * 
 * @author infinity a.k.a Alexander Oleynik (email: <a
 *         href="mailto:seti.post@gmail.com">seti.post@gmail.com</a>).
 * 
 */
public class Main {

    /**
     * <p>
     * The Logger.
     * 
     * */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * @param args
     * 
     * */
    public static void main(String[] args) throws IOException {
        PoemLoader loader = new PoemLoader();
        for ( String poem : new String[]{"TheBirksOfAberfeldie", "MyFatherWasAFarmer"} ) {
            String path = ClassLoader.getSystemResource(poem + ".txt").getFile();
            String source = loader.load(path);
            WordCounter counter = new WordCounter(source);
            counter.calculate();
            logger.info("Most popular words in poem {}:", poem);
            for (String word : counter.getMostPopularWord()) {
                logger.info("{}={}", word, counter.getRepetitionNumber(word));
            }
        }
    }
}
