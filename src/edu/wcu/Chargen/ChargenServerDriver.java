package edu.wcu.Chargen;
import java.io.IOException;

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
    public static void main(String[] args) throws IOException {
        /* default "well-known" chargen port number */
        int portNum = 19;

        /* Server type of TCP or UDP*/
        String serverType = null;

        /* Declaration of a ChargenServer */
        ChargenServer chargenServer = null;

        /* Not enough or too many cmd line args call usage */
        if (args.length == 0 || args.length >= 3)
        {
            usage();
        }

        /* TODO: ask Kreahling if we should exit or try to get the right server type */
        /* Only one arg then set the server type */
        if (args.length >= 1)
        {
            serverType = args[0];
            /*if (!serverType.equalsIgnoreCase("TCP") ||
                    !serverType.equalsIgnoreCase("UDP"))
            {
                usage();
            }*/
        }

        /* Two arguments set the port number as well */
        if (args.length == 2)
        {
            portNum = Integer.decode(args[1]);
        }

        if (serverType != null) {
            if (serverType.equalsIgnoreCase("TCP"))
            {
                chargenServer = new ChargenTcpServer(portNum);
            }

            if (serverType.equalsIgnoreCase("UDP"))
            {
                chargenServer = new ChargenUdpServer(portNum);
            }
        }

        if (chargenServer != null) {
            chargenServer.listen();
        }
    }

    private static void usage() {
        System.err.println(
                "usage: java ChargenServerDriver <TCP or UDP> [port number]");
        System.exit(1);
    }
}