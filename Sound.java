import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound{
	Clip clip;
    public Sound(String audio) {
    	try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(audio));
			this.clip = AudioSystem.getClip();
			this.clip.open(ais);
			this.clip.loop(Clip.LOOP_CONTINUOUSLY);
			this.clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
    }
    
    public void endSound() {
    	this.clip.stop();
    }
}

