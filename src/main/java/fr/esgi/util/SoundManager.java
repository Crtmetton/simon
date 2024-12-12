package fr.esgi.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoundManager {
    private Map<String,String>soundFile;

    public void playSound(String aColor) {
        switch (aColor) {
            case "red":
                LecteurAudio(aColor);
                break;
            case "green":
                LecteurAudio(aColor);
                break;
            case "blue":
                LecteurAudio(aColor);
                break;
            case "yellow":
                LecteurAudio(aColor);
                break;
            default:
                System.out.println("Invalid color: " + aColor);
        }
    }

    public static void LecteurAudio(String aColor) {
        String Path = System.getProperties().getProperty("user.dir") + "/src/main/java/fr/esgi/util/sound/" + aColor + ".wav";
        try {
            // Chargement du fichier audio
            File audioFile = new File(Path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Création du lecteur audio
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            // Lecture du fichier
            clip.start();
            System.out.println("Lecture en cours...");
            Thread.sleep(333);

            // Fermeture du lecteur
            clip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

   private void changeSoundSetting(String soundType){

   }
}
