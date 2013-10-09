package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public abstract class AbstractChargenServer implements ChargenServer{
    private int port;
    private ChargenCharacterSource source;

    public AbstractChargenServer(){}
    public AbstractChargenServer(int port){}
    public AbstractChargenServer(ChargenCharacterSource source){}
    public AbstractChargenServer(int port, ChargenCharacterSource source){}

    public int getPort() {
        return port;
    }

    public ChargenCharacterSource getCharacterSource() {
        return source;
    }

    public void changeSource(ChargenCharacterSource source) {
        this.source = source;
    }

    private void listen()
    {

    }
}
