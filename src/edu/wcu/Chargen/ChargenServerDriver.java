package edu.wcu.Chargen;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ChargenServerDriver provides the entry point for this application. It has
 * one method: main(). The program accepts one or two parameters. The first
 * parameter is either the string “TCP” or the string “UDP”. The program will
 * use this parameter to determine which server implementation to use. The
 * second, optional, parameter is the port number on which the server will
 * listen for incoming connections. If this parameter is not supplied, the
 * default value must be 19 (the “well-known” chargen port).
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenServerDriver {
    public static void main(String[] args)
    {
        /* default "well-known" chargen port number */
        int portNum = 19;

        /* Server type TCP of UDP*/
        String serverType;

        /* Not enough or too many cmd line args call usage */
        if (args.length == 0 || args.length >= 3)
        {
            usage();
        }

        /* Only one arg then set the server type */
        /*TODO: ask Kreahling if we should exit or try to get the right server type*/
        if (args.length == 1)
        {
            serverType = args[0];
            if (!serverType.equalsIgnoreCase("TCP") ||
                    !serverType.equalsIgnoreCase("UDP"))
            {
                usage();
            }
        }

        /* Two arguments set the port number as well */
        if (args.length == 2)
        {
            portNum = Integer.decode(args[1]);
        }
    }

    private static void usage() {
        System.err.println(
                "usage: java ChargenServerDriver <TCP or UDP> [port number]");
        System.exit(1);
    }
}