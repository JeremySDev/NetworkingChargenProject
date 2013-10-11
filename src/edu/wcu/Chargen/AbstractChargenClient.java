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

    /* The port number to connect to on the host */
    private int port;

    /**
     * Constructor for the AbstractChargenClient that takes accepts the host's
     * address.
     *
     * @param host - the host's InetAddress
     */
    public AbstractChargenClient(InetAddress host)
    {
        this(19, host);
    }


    /**
     * Constructor for the AbstractChargenClient that takes accepts the host's
     * address.
     *
     * @param host - the host's InetAddress.
     * @param port
     *
     */
    public AbstractChargenClient(InetAddress host, int port)
    {
        this.port = port;
        this.host = host;

    }

    protected InetAddress getHost()
    {
        return this.host;
    }

    protected int getPort()
    {
        return this.port;

    }

    @Override
    public void printToStream(PrintStream out)
    {

    }
}