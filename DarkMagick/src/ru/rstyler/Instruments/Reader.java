package ru.rstyler.Instruments;

import java.util.HashMap;

interface Reader<Income, Result> {
    Result read (Income arg);
    HashMap<String, String> ResText(Result tem);
    String Split();
}
