package edu.wcu.Chargen;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ChargenClientDriver is the entry point of the application. It includes one
 * method: main(). The program accepts either two, three, or four parameters.
 * The first parameter must be the string “TCP” or the string “UDP” (case does
 * not matter). The program will use this parameter to determine which client
 * implementation to use. The second parameter must be the IP address or
 * hostname of the server to which to connect. The third, optional, parameter is
 * the port number to which to connect. If this parameter is not supplied, the
 * default value will be 19 (the “well-known” chargen port). The fourth,
 * optional, parameter is a flag to send to the version of the Chargen server.
 * The flags are defined in the RFC listed on the main web page. In the absence
 * of any flag, the client and server use default behaviors.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public class ChargenClientDriver {
    public static void main(String[] args) {

        /* default "well-known" chargen port number */
        int portNum = 19;

        /* Server type TCP of UDP*/
        String clientType = null;

        /* The host's name in String form */
        String hostName = null;

        /* Flag for which CharacterSource our chargen server needs to use */
        String chargenFlag = "<CR><LF>";

        /* Declaration of a ChargenClient */
        ChargenClient chargenClient = null;


        /* Not enough or too many cmd line args call usage */
        if (args.length == 0 || args.length >= 5)
        {
            usage();
        }

        /* Take the two mandatory arguments to set the server type and host */
        if (args.length >= 2)
        {
            clientType = args[0];
            hostName = args[1];
        }

        /* if there is a third arg set that as the port number */
        if (args.length >= 3)
        {
            portNum = Integer.decode(args[2]);
        }

        /* if there is a third arg set that as the flag for our chargen server*/
        if (args.length >= 4)
        {
            chargenFlag = args[3];
        }

        /* Check what the client type needs to be */
        if (clientType != null) {
            if (clientType.equalsIgnoreCase("TCP"))
            {
                try {
                    /* create a chargenClient hostname and port number given */
                    chargenClient = new ChargenTcpClient(
                            /* create an InetAddress from the String hostName */
                            InetAddress.getByName(hostName), portNum);
                } catch (UnknownHostException uhe) {
                    System.err.println(uhe.getMessage());
                    System.exit(1);
                } catch (ChargenServerException cse) {
                    System.err.println(cse.getMessage());
                    System.exit(1);
                }
            }
            else if (clientType.equalsIgnoreCase("UDP"))
            {
                try {
                    chargenClient = new ChargenUdpClient(
                            InetAddress.getByName(hostName), portNum);
                } catch (UnknownHostException uhe) {
                    System.err.println(uhe.getMessage());
                    System.exit(1);
                } catch (ChargenServerException cse) {
                System.err.println(cse.getMessage());
                System.exit(1);
                }
            }
            else
            {
                usage();
            }
        }

        if (chargenClient != null)
        {
            try {
                PrintStream out = new PrintStream(System.out);
                chargenClient.setFlag(chargenFlag);
                chargenClient.printToStream(out);
            } catch (ChargenServerException cse) {
                System.err.println(cse.getMessage());
                System.exit(1);
            }
        }
    }

    private static void usage() {
        System.err.println(
                "usage: java ChargenServerDriver <TCP or UDP> <hostname> " +
                        "[port number] [chargen server flag]");
        System.exit(1);
    }
}