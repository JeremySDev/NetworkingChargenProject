import edu.wcu.Chargen.ChargenCharacterSource;
import edu.wcu.Chargen.ChargenServer;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


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
    private int port;
    private ChargenCharacterSource source;

    public AbstractChargenServer(){}
    public AbstractChargenServer(int port){}
    public AbstractChargenServer(ChargenCharacterSource source){}
    public AbstractChargenServer(int port, ChargenCharacterSource source){}

    protected int getPort()
    {
        return port;
    }

    protected ChargenCharacterSource getCharacterSource()
    {
        return source;
    }

    protected void changeSource(ChargenCharacterSource source)
    {
        this.source = source;
    }

    public void listen()
    {

    }
}
