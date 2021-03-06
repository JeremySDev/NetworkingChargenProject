package edu.wcu.Chargen;

/**
 * AbstractChargenServer is an abstract class that implements the ChargenServer
 * interface. This class includes attributes that are common to all Chargen
 * server implementations, as well as protected methods that enable subclasses
 * to access those attributes. For all constructors, if no
 * ChargenCharacterSource is supplied, DefactoChargenCharacterSource is used by
 * default. getCharacterSource() will return a ChargenCharacterSource – an
 * object used to generated the character sequence produced by the server.
 * changeSource(ChargenCharacterSource) will accept a new ChargenCharacterSource
 * that will change the one used to generate characters.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public abstract class AbstractChargenServer implements ChargenServer {

    /* The number of the port to be used */
    private final int port;

    /* The character source to be used */
    private ChargenCharacterSource source;

    /**
     * AbstractChargenServer constructor this is the default constructor for the
     * AbstractChargenServer class.
     */
    public AbstractChargenServer()
    {
        this(19, new DefactoChargenCharacterSource());
    }

    /**
     * AbstractChargenServer constructor this constructor is used when the port
     * number is provided.
     *
     * @param port - the port number to be used.
     */
    public AbstractChargenServer(int port)
    {
        this(port, new DefactoChargenCharacterSource());
    }

    /**
     * AbstractChargenServer constructor this constructor is used when the
     * source is provided.
     *
     * @param source - stuff
     */
    public AbstractChargenServer(ChargenCharacterSource source)
    {
        this(19, source);
    }

    /**
     * AbstractChargenServer constructor this constructor is used when the port
     * number and source are provided
     *
     * @param port - the port number to be used.
     * @param source  - stuff
     */
    public AbstractChargenServer(int port, ChargenCharacterSource source)
    {
        this.port = port;
        this.source = source;
    }

    /**
     * getPort - returns the port number of the AbstractChargenServer.
     * @return - the port number
     */
    protected int getPort()
    {
        return port;
    }

    /**
     * getCharacterSource - returns the ChargenCharacterSource of the
     * AbstractChargenServer.
     *
     * @return - A CharacterSource.
     */
    protected ChargenCharacterSource getCharacterSource()
    {
        return source;
    }

    /**
     * changeSource - allows for the modification of the source field in the
     * AbstractChargenServer.
     *
     * @param source - A CharacterSource.
     */
    protected void changeSource(ChargenCharacterSource source)
    {
        this.source = source;
    }

    /**
     * Listens for a connection from a client.
     *
     * @throws ChargenServerException - If there are problems receiving or
     *                                  sending a packet.
     */
    public void listen() throws ChargenServerException
    {

    }
}