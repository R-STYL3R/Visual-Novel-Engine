package ru.rstyler.fields;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Character alfa = new Character();
        alfa.setName("alfa");
        Sounds music = new Sounds();

        System.out.print(alfa.getName()+": "+alfa.Phrase("Я сосу шлены"));
    }
}
