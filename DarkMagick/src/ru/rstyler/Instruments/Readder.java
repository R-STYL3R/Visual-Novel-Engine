package ru.rstyler.Instruments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Readder implements Reader{
    protected List<String> text;
    protected Pattern regex(int index){
        if(index == 1){
        Pattern CharName = Pattern.compile("^([А-Яа-я]*): \\\"([а-яА-Я0-9 :,.!?]*)\\\"");
        return CharName;
        }else if(index == 2){
        Pattern CharText = Pattern.compile(": \\\"([а-яА-Я0-9 :,.!?]*)\\\"");
        return CharText;
        }else{
        Pattern SolidText = Pattern.compile("^\\\"([а-яА-Я0-9 ]*)\\\"");
        return SolidText;
        }
    }
    @Override
    public void initialization(String path) {
        text = new ArrayList<String>();
        try{
            Scanner scenario = new Scanner(new File(path));
            while(scenario.hasNextLine()){
                text.add(scenario.nextLine());

            }
            scenario.close();
        }catch(NullPointerException e){
            throw new IllegalArgumentException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public HashMap<String, String> ResultText() {
       HashMap<String, String> alfaText;
       alfaText= new HashMap<>();
        for(String s:text){
                Matcher matcher = regex(1).matcher(s);
                if (matcher.matches()) {
                alfaText.put(matcher.group(1), matcher.group(2));
                }

        }
        return alfaText;
    }

    @Override
    public String Split() {
        return null;
    }


    public static void main(String[] args){
    Readder alfa = new Readder();
    alfa.initialization("Z:\\R_STYLER IX\\учеба\\git\\visual-novel-engine\\DarkMagick\\src\\lol.txt");
    System.out.print(alfa.ResultText());


    }

}
