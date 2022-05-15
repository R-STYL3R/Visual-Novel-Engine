package ru.rstyler;

import java.io.FileNotFoundException;

public interface Character {
    String Name(String Name);
    String SpritesPath(String Path) throws FileNotFoundException;
    String Phrase(String Phrase);
}
