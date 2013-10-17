package edu.wcu.Chargen;
import java.io.IOException;
import java.io.PrintStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * ChargenClient is the interface to a chargen client implementation. The
 * interface includes one method: printToStream() which takes a PrintStream as
 * a parameter. Classes implementing this interface will provide an
 * implementation of this method that prints the received character sequence to
 * the supplied stream.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public interface ChargenClient {

    /**
     * Method used to print data received from the server into a given output
     * stream.
     * @param out - A given PrintStream used to contain server data to print.
     * @throws SocketTimeoutException - when the socket has timed out.
     * @throws SocketException - when creating a new DatagramSocket.
     * @throws UnknownHostException - if local host can't be resolved into an
     * address.
     * @throws IOException - if the client and server communicated incorrectly.
     */
    public void printToStream(PrintStream out) throws SocketTimeoutException,
            SocketException, UnknownHostException, IOException;

    public void setFlag(String chargenFlag);
}