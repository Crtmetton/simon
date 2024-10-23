package fr.esgi.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoundManager {
    private Map<String,String>soundFile;

   private void playSound(String Color) {
       switch (Color) {
           case "red":
             //Sound Red
           case "green":

           case "blue":

           case "yellow":
       }
   }

   private void changeSoundSetting(String soundType){

   }
}
