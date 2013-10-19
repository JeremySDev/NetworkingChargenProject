package edu.wcu.Chargen;

/**
 * The exceptions generated by the various concrete implementations of the
 * ChargenServer interface’s listen() method vary across implementations. For
 * example, a TCP implementation might throw exceptions related to TCP socket
 * errors; a UDP implementation might throw other exceptions. We did not want
 * users of our interface to have to explicitly catch all these exceptions.
 * (Remember, an interface presents an abstract view of the component.) If a
 * user is using only the UDP implementation, why make them catch TCP-related
 * exceptions? Instead, to provide an abstract interface, we introduce
 * ChargenServerException. Classes that provide concrete implementations of
 * listen() will catch the protocol-specific exceptions, wrap those exceptions
 * in a ChargenServerException, and then throw that exception. This approach
 * passes along all the error information in the wrapped object, but keeps the
 * interface “clean”.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenServerException extends RuntimeException {

    /**
     * Constructor that creates an exception wrapper and passes a given
     * Throwable object to RuntimeException.
     *
     * @param t - A Throwable object to pass to RuntimeException
     */
    public ChargenServerException(Throwable t)
    {
        super(t);
    }
}
