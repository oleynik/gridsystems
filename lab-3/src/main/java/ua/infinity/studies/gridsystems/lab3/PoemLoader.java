package ua.infinity.studies.gridsystems.lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date: 27.10.2013
 * 
 * @author infinity a.k.a Alexander Oleynik (email: <a
 *         href="mailto:seti.post@gmail.com">seti.post@gmail.com</a>).
 * 
 */
public class PoemLoader {

    /**
     * <p>
     * The Logger.
     * 
     * */
    private static final Logger logger = LoggerFactory.getLogger(PoemLoader.class);

    /**
     * <p>
     * Load poem from file to memory and return content.
     * 
     * @param path
     *            - path to file with poem
     * 
     * @return Content of file.
     * 
     * @throws IllegalArgumentException
     *             when path is {@code null} or empty.
     * 
     *             throws IOException when I/O error occurs.
     * 
     * */
    public String load(String path) throws IOException {
        logger.debug("Try load poem from {}", path);
        if (StringUtils.trimToNull(path) == null) {
            throw new IllegalArgumentException(path);
        }
        String normalize = path;
        if (normalize.startsWith("/") || normalize.startsWith("\\")) {
            normalize = normalize.substring(NumberUtils.INTEGER_ONE);
        }
        Path pathToFile = Paths.get(normalize);
        return new String(Files.readAllBytes(pathToFile));
    }
}
