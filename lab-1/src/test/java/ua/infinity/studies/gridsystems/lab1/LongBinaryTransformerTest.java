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
 * @author infinity a.k.a Alexander Oleynik (email: <a href="mailto:seti.post@gmail.com">seti.post@gmail.com</a>).
 * 
 */
public class LongBinaryTransformerTest {

    /**
     * <p>The Logger.
     * 
     * */
    private static final Logger logger = LoggerFactory.getLogger(LongBinaryTransformerTest.class);
    
    /**
     * <p>
     * Transformer.
     * 
     * */
    public LongBinaryTransformer transformer;

    /**
     * <p>
     * Before class.
     * 
     * */
    @BeforeClass
    public void beforeClass() {
        transformer = new LongBinaryTransformer();
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
        for (long i = Long.MIN_VALUE; i <= Long.MIN_VALUE + 1000; i++) {
            Assert.assertEquals(transformer.transform(i), Long.toBinaryString(i), "Wrong result for " + i);
        }
        logger.info("About zero...");
        for (long i = -1024; i <= 1024; i++) {
            Assert.assertEquals(transformer.transform(i), Long.toBinaryString(i), "Wrong result for " + i);
        }
        logger.info("About max. value...");
        for (long i = Long.MAX_VALUE - 100; i < Long.MAX_VALUE; i++) {
            Assert.assertEquals(transformer.transform(i), Long.toBinaryString(i), "Wrong result for " + i);
        }
    }
}
