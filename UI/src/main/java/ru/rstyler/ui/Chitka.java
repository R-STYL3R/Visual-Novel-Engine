package ru.rstyler.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chitka {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner alfa = new Scanner(new File("./UI/src/main/resources/ru/rstyler/ui/Config.txt"));
        System.out.print(alfa.nextLine());
    }

}
