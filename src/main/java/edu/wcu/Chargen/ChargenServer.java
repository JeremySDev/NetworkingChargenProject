package edu.wcu.Chargen;

/**
 * ChargenServer is the interface to a chargen server implementation. The
 * interface includes a method: listen(). Classes implementing this interface
 * will provide an implementation of this method.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13
 */
public interface ChargenServer {
    /* listen will listen for requests from clients. */

    /**
     * Listens for a connection from a client.
     * @throws ChargenServerException - If there are problems receiving or
     *                                  sending a packet.
     */
    public void listen() throws ChargenServerException;
}
