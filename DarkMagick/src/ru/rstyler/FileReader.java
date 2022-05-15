package ru.rstyler;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface FileReader {
    String Regex(int alfa);
    File TextFile(String path);
    HashMap<String, String> TextList();

}
