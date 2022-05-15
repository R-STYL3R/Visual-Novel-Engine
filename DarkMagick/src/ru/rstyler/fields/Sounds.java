package ru.rstyler.fields;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Класс работы с музыкой и звуками
 * @author Напирели Торнике
 * @version 0.1
 */
public class Sounds implements ru.rstyler.Sounds {
    String SoundPath = "";
    String MusicPath = "";
    /**
     * @param Path задаваемый параметр пути звуков
     * @return возвращает путь до директории со звуками
     * @throws FileNotFoundException Если путь не валидный выбрасывает соответсвующую ошибку
     */
    @Override
    public String SoundsPath(String Path) throws FileNotFoundException {
        File sounds = new File(Path);
        if(sounds.isDirectory()){
            SoundPath = Path;
            return Path;
        }else{
            throw new FileNotFoundException("Invalid file path");
        }
    }

    /**
     *
     * @param Path Параметр пути до директории с музыкой
     * @return возвращает путь до директории с музыкой
     * @throws FileNotFoundException путь не валидный выбрасывает соответсвующую ошибку
     */
    @Override
    public String MusicPath(String Path) throws FileNotFoundException {
        File sprite = new File(Path);
        if(sprite.isDirectory()){
            MusicPath = Path;
            return Path;
        }else{
            throw new FileNotFoundException("Invalid file path");
        }
    }

    /**
     * Метод используется только если класс создан для звуков
     * @param NameOfSound название звука
     * @return возвращает нужный звук
     */
    @Override
    public Clip SoundClip(String NameOfSound) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File sound = new File(SoundPath+"\\"+NameOfSound);
        AudioInputStream SoundStream = AudioSystem.getAudioInputStream(sound);
        Clip clip = AudioSystem.getClip();
        clip.open(SoundStream);
        return clip;
    }

    @Override
    public Clip MusicClip(String TypeOfMusic) {
        return null;
    }
}
