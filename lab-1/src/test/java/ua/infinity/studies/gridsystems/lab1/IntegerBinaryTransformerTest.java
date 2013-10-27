package ua.infinity.studies.gridsystems.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Date: 26.10.2013
 * 
 * @author infinity a.k.a Alexander Oleynik (email: <a
 *         href="mailto:seti.post@gmail.com">seti.post@gmail.com</a>).
 * 
 */
public class IntegerBinaryTransformerTest {

    /**
     * <p>
     * The Logger.
     * 
     * */
    private static final Logger logger = LoggerFactory.getLogger(IntegerBinaryTransformerTest.class);

    /**
     * <p>
     * Transformer.
     * 
     * */
    public IntegerBinaryTransformer transformer;

    /**
     * <p>
     * Before class.
     * 
     * */
    @BeforeClass
    public void beforeClass() {
        transformer = new IntegerBinaryTransformer();
    }

    /**
     * <p>
     * After class.
     * 
     * */
    @AfterClass
    public void afterClass() {
        transformer = null;
    }

    /**
     * <p>
     * Unit test for {@link IntegerBinaryTransformer#transform(Integer)}.
     * 
     * */
    @Test
    public void transform() {
        logger.info("About min. value...");
        for (int i = Integer.MIN_VALUE; i <= Integer.MIN_VALUE + 1000; i++) {
            Assert.assertEquals(transformer.transform(i), Integer.toBinaryString(i), "Wrong result for " + i);
        }
        logger.info("About zero...");
        for (int i = -1024; i <= 1024; i++) {
            Assert.assertEquals(transformer.transform(i), Integer.toBinaryString(i), "Wrong result for " + i);
        }
        logger.info("About max. value...");
        for (int i = Integer.MAX_VALUE - 100; i < Integer.MAX_VALUE; i++) {
            Assert.assertEquals(transformer.transform(i), Integer.toBinaryString(i), "Wrong result for " + i);
        }
    }
}
