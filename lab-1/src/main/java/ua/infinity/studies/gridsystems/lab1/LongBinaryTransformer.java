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
public class LongBinaryTransformer implements BinaryTransformer<Long> {

    /**
     * <p>
     * The Logger.
     * 
     * */
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(LongBinaryTransformer.class);

    /**
     * {@inheritDoc}
     * 
     * */
    @Override
    public String transform(Long value) {
        if (value == 0L) {
            return "0";
        }
        final int capacity = 64;
        StringBuilder result = new StringBuilder(capacity);
        if (value > 0) {
            for (long temp = value.longValue(); temp > 0; temp >>= 1) {
                result.insert(0, temp % RADIX);
            }
        } else {
            for (long i = 0, temp = value.longValue(); i < capacity; i++, temp >>= 1) {
                result.insert(0, -1 * (temp % RADIX));
            }
        }
        return result.toString();
    }
}
