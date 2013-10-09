package edu.wcu.Chargen;

/**
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public abstract class AbstractChargenServer{
    private int port;
    private ChargenCharacterSource source;

    public ChargenCharacterSource(){}
    public ChargenCharacterSource(int port){}
    public ChargenCharacterSource(ChargenCharacterSource source){}
    public ChargenCharacterSource(int port, ChargenCharacterSource source){}

    public int getPort() {
        return port;
    }

    public ChargenCharacterSource getCharacterSource() {
        return source;
    }

    public void changeSource(ChargenCharacterSource source) {
        this.source = source;
    }
}
