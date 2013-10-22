package edu.wcu.Chargen;

import java.io.PrintStream;
import java.net.InetAddress;

/**
 * AbstractChargenClient is an abstract class that implements the ChargenClient
 * interface. This class includes attributes that are common to all Chargen
 * client implementations, as well as protected methods that enable subclasses
 * to access those attributes.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public abstract class AbstractChargenClient implements ChargenClient {
    /* The InetAddress of the host */
    private InetAddress host;

    /* The default port number of the Chargen Server */
    private int port = 19;

    /* flag for the type of character source */
    private String flag = "<CR><LF>";
    /**
     * Constructor for the AbstractChargenClient that takes accepts the host's
     * address.
     *
     * @param host - the host's InetAddress
     */
    public AbstractChargenClient(InetAddress host)
    {
        this(host, 19);
    }

    /**
     * Constructor for the AbstractChargenClient that takes accepts the host's
     * address.
     *
     * @param host - the host's InetAddress.
     * @param port - the port number to use.
     */
    public AbstractChargenClient(InetAddress host, int port)
    {
        this.port = port;
        this.host = host;
    }

    /**
     * getHost - returns the host field of the AbstractChargenClient.
     *
     * @return - the InetAddress of the host.
     */
    protected InetAddress getHost()
    {
        return this.host;
    }

    /**
     * getPort - returns the port field of the AbstractChargenClient.
     *
     * @return - the number of the port being used
     */
    protected int getPort()
    {
        return this.port;
    }

    /**
     * setFlag - sets the flag which is to be used to determine what Character
     * source should be used
     *
     * @param flag - determines to Character source to be used
     */
    public void setFlag (String flag)
    {
        this.flag = flag;
    }

    /**
     * getFlag - gets the flag which is to be used to determine what Character
     * source should be used
     *
     * @return - A String of the flag's value.
     */
    protected String getFlag()
    {
        return this.flag;
    }

    /**
     * Abstract method used to print data received from the server into a given
     * output stream.
     * @param out - A given PrintStream used to contain server data to print.
     * @throws ChargenServerException - if the client and server communicated
     *                                  incorrectly.
     */
    @Override
    public abstract void printToStream(PrintStream out) throws
            ChargenServerException;
}