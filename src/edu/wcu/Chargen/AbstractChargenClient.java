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
     * @return host - the InetAddress of the host.
     */
    protected InetAddress getHost()
    {
        return this.host;
    }

    /**
     * getPort - returns the port field of the AbstractChargenClient.
     *
     * @return port - the number of the port being
     */
    protected int getPort()
    {
        return this.port;
    }

    @Override
    public void printToStream(PrintStream out)
    {

    }
}