package edu.wcu.Chargen;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public abstract class AbstractChargenClient implements ChargenClient {

    private InetAddress host;

    private int port;

    public AbstractChargenClient(InetAddress host)
    {

    }

    public AbstractChargenClient(InetAddress host, int port)
    {

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