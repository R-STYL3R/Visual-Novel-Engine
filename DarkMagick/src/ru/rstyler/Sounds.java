package ru.rstyler;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Sounds {
    String SoundsPath(String Path) throws FileNotFoundException;
    String MusicPath(String Path) throws FileNotFoundException;
    Clip SoundClip(String NameOfSound) throws UnsupportedAudioFileException, IOException, LineUnavailableException;
    Clip MusicClip(String TypeOfMusic);

}
