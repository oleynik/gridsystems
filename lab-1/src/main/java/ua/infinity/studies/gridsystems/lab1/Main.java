package ua.infinity.studies.gridsystems.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date: 26.10.2013
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
    public static void main(String[] args) {
        IntegerBinaryTransformer transformer = new IntegerBinaryTransformer();
        for (int i = -8; i < 8; i++) {
            int decimal = i;
            String binary = transformer.transform(decimal);
            logger.info("Dec={}, Bin={}", decimal, binary);
        }
    }
}
