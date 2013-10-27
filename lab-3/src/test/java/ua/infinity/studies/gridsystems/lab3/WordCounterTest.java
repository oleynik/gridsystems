package ua.infinity.studies.gridsystems.lab3;

import java.io.IOException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Date: 27.10.2013
 * 
 * @author infinity a.k.a Alexander Oleynik (email: <a
 *         href="mailto:seti.post@gmail.com">seti.post@gmail.com</a>).
 * 
 */
public class WordCounterTest {

    /**
     * <p>
     * The Logger.
     * 
     * */
    private static final Logger logger = LoggerFactory.getLogger(WordCounterTest.class);

    /**
     * <p>
     * Poem loader.
     * 
     * */
    private PoemLoader loader;

    /**
     * <p>
     * Before class.
     * 
     * */
    @BeforeClass
    public void beforeClass() {
        loader = new PoemLoader();
    }

    /**
     * <p>
     * After class.
     * 
     * */
    @AfterClass
    public void afterClass() {
        loader = null;
    }

    /**
     * <p>
     * Test {@link WordCounter} functionality by "My father was a Farmer" poem.
     * 
     * */
    @Test
    public void firstTest() throws IOException {
        String path = ClassLoader.getSystemResource("TheBirksOfAberfeldie.txt").getFile();
        String source = loader.load(path);
        WordCounter counter = new WordCounter(source);
        counter.calculate();
        Set<String> popularWords = counter.getMostPopularWord();
        logger.info("Most popular words for {} - {}", path, popularWords);
        Assert.assertNotNull(popularWords);
        Assert.assertEquals(popularWords.size(), 1);
        Assert.assertEquals(popularWords.iterator().next(), "the");
        Assert.assertEquals(counter.getRepetitionNumber("the"), 15);
        Assert.assertEquals(counter.getRepetitionNumber("will"), 4);
    }

    /**
     * <p>
     * Test {@link WordCounter} functionality by "My father was a Farmer" poem.
     * 
     * */
    @Test
    public void secondTest() throws IOException {
        String path = ClassLoader.getSystemResource("MyFatherWasAFarmer.txt").getFile();
        String source = loader.load(path);
        WordCounter counter = new WordCounter(source);
        counter.calculate();
        Set<String> popularWords = counter.getMostPopularWord();
        logger.info("Most popular words for {} - {}", path, popularWords);
        Assert.assertNotNull(popularWords);
        Assert.assertEquals(popularWords.size(), 1);
        Assert.assertEquals(popularWords.iterator().next(), "i");
        Assert.assertEquals(counter.getRepetitionNumber("i"), 19);
        Assert.assertEquals(counter.getRepetitionNumber("my"), 14);
    }
}
