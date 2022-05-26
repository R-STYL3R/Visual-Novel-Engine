package ru.rstyler.ui;

import org.controlsfx.tools.Utils;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import java.io.FileWriter;
import java.io.IOException;

import static javax.sound.sampled.AudioSystem.getClip;

public class Test {
    public void start(float volume, LineListener listener) throws LineUnavailableException {
    Clip clip = getClip();
    if (clip == null)
        return;

    // PulseAudio does not support Master Gain
    if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
        // set volume
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
        gainControl.setValue((float) Utils.clamp(dB, gainControl.getMinimum(), gainControl.getMaximum()));
    } else if (clip.isControlSupported(FloatControl.Type.VOLUME)) {
        // The docs don't mention what unit "volume" is supposed to be,
        // but for PulseAudio it seems to be amplitude
        FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
        float amplitude = (float) Math.sqrt(volume) * volumeControl.getMaximum();
        volumeControl.setValue((float) Utils.clamp(amplitude, volumeControl.getMinimum(), volumeControl.getMaximum()));
    }

    if (listener != null)
        clip.addLineListener(listener);
    clip.setFramePosition(0);
    clip.start();
}
}
