package ua.infinity.studies.gridsystems.lab3;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

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
public class WordCounter {

    /**
     * <p>
     * The Logger.
     * 
     * */
    private static final Logger logger = LoggerFactory.getLogger(WordCounter.class);

    /**
     * <p>
     * Punctuation signs.
     * 
     * */
    private static final String PUNCTUATION = "[!&)(_,./:;\"?\n\r\t]";

    /**
     * <p>
     * Statistic storage.
     * 
     * */
    private Map<String, AtomicLong> statisticStorate = new LinkedHashMap<>();
    
    /**
     * <p>Most popular word.
     * 
     * */
    private Set<String> mostPopularWords = new LinkedHashSet<>();

    /**
     * <p>
     * Source content.
     * 
     * */
    private final String content;

    /**
     * <p>
     * Default constructor.
     * 
     * @param content
     *            - source content
     * 
     * */
    public WordCounter(String content) {
        this.content = content;
    }

    /**
     * <p>
     * Calculate statistics.
     * 
     * */
    public void calculate() {
        if (StringUtils.trimToNull(content) == null) {
            return;
        }
        String cleaned = content.replaceAll(PUNCTUATION, StringUtils.EMPTY).trim().toLowerCase();
        String[] words = cleaned.split(" +");
        long max = NumberUtils.INTEGER_ZERO;
        for (String word : words) {
            AtomicLong count = statisticStorate.get(word);
            if ( count == null ) {
                count = new AtomicLong();
                statisticStorate.put(word, count);
            }
            long current = count.incrementAndGet();
            if ( current >= max ) {
                if ( current > max ) {
                    max = current;
                    mostPopularWords.clear();
                }
                mostPopularWords.add(word);
            }
        }
        logger.debug("Statistics: {}", statisticStorate);
        logger.debug("MostPopularWords: {}", mostPopularWords);
    }

    /**
     * <p>
     * Get most popular word, that occurs most often.
     * 
     * @return The most popular word or {@code null} if poem does not contain
     *         any words.
     * 
     * */
    public Set<String> getMostPopularWord() {
        return mostPopularWords;
    }

    /**
     * <p>
     * Get repetition number of specific word.
     * 
     * @param word
     *            - specific word
     * 
     * @return The number of repetitions.
     * 
     * @throws NullPointerException
     *             when specific word is {@code null}.
     * 
     * */
    public long getRepetitionNumber(String word) {
        return statisticStorate.get(word).get();
    }
}
