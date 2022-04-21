package ru.rstyler.Instruments;

public class Character{
    final String name;
    final String SpritePath;
 public Character(String name, String SpritePath){
     this.name = name;
     this.SpritePath = SpritePath;
 }
 private String GetName(){
     return name;
 }
public Sprite CharSprite(){
     return new Sprite() {
         @Override
         public Image GetSprite() {
             try{
                 return new Image() {
                     @Override
                     public String path() {
                         return SpritePath;
                     }

                     @Override
                     public String options() {
                         return "null";
                     }
                 };
             }catch(NullPointerException e){
                 throw new NullPointerException();
             }
         }
     };
}
}

