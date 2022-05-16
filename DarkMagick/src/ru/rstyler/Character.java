package ru.rstyler;

import java.io.FileNotFoundException;

public interface Character {
    String getName();
    String setName(String Name);
    String SpritesPath(String Path) throws FileNotFoundException;
    String Phrase(String Phrase);
}
