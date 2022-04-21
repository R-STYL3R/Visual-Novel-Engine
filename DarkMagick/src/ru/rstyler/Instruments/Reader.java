package ru.rstyler.Instruments;

import java.util.HashMap;

interface Reader{
    void initialization(String path);
    HashMap<String, String> ResultText();
    String Split();
}
