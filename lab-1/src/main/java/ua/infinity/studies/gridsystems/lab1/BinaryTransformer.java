package ua.infinity.studies.gridsystems.lab1;

/**
 * Date: 26.10.2013
 * 
 * @author infinity a.k.a Alexander Oleynik (email: <a
 *         href="mailto:seti.post@gmail.com">seti.post@gmail.com</a>).
 * 
 */
public interface BinaryTransformer<T> {

    /**
     * <p>
     * Binary radix.
     * 
     * */
    static final int RADIX = 2;

    /**
     * <p>
     * Create binary view from specific value.
     * 
     * @param value
     *            - specific value
     * 
     * @return String representation of binary view.
     * 
     * */
    String transform(final T value);
}
