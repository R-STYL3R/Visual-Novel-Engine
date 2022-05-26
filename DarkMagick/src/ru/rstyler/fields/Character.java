package ru.rstyler.fields;

import ru.rstyler.Image;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Класс создания и использования персонажа
 * @author Напирели Торнике
 * @version 0.1
 *
 */

public class Character implements ru.rstyler.Character {
    String SpritePath="";
    String Name="";
    /**
     *Метод возвращения имени персонажа
     * @param Name
     * @return возвращает строку имя персонажа
     */
    @Override
    public String setName(String Name) {
        this.Name = Name;
        return Name;
    }
    @Override
    public String getName(){
        return Name;
    }

    /**
     * Проверка валидности пути к спрайтам персонажа
     * @param Path
     * @return Возвращает путь до спрайтов
     * @throws FileNotFoundException
     */
    @Override
    public String SpritesPath(String Path) throws FileNotFoundException {
        File sprite = new File(Path);
        if(sprite.isDirectory()){
            SpritePath = Path;
            return Path;
        }else{
            throw new FileNotFoundException("Invalid file path");
        }

    }

    @Override
    public String getSpritePath() {
        return SpritePath;
    }

    /**
     * Основной метод для использования персонажа в игре
     * @param Phrase
     * @return возвращает фразу персонажа
     */
    @Override
    public String Phrase(String Phrase) {
        return Phrase;
    }
}
