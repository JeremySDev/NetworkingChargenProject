package edu.wcu.Chargen;

/**
 * The Chargen RFC does not specify the format of the character sequence
 * produced by a server application. Therefore, servers may choose to vary the
 * character sequence. The ChargenCharacterSource provides the abstract
 * interface to a component that produces some character sequence for chargen.
 *
 * @author Jeremy Stilwell
 * @author Alisha Hayman
 * @version 10/8/13.
 */
public interface ChargenCharacterSource {
    public char getNextChar();
}