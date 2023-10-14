package org.forms;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
    private MediaPlayerFactory factory;
    private EmbeddedMediaPlayer mediaPlayer;
    public Home() {
        init();
    }

    private void init(){
        factory = new MediaPlayerFactory();
        mediaPlayer = factory.mediaPlayers().newEmbeddedMediaPlayer();
        Canvas canvas = new Canvas();
        mediaPlayer.videoSurface().set(factory.videoSurfaces().newVideoSurface(canvas));

        setLayout(new BorderLayout());
        add(canvas);
    }

    public void play(){
        if(mediaPlayer.status().isPlaying()){
            mediaPlayer.controls().stop();
        }
        mediaPlayer.media().play("videos/WeatheringWithYou.mp4");
        mediaPlayer.controls().play();
    }

    public  void stop(){
        mediaPlayer.controls().stop();
        mediaPlayer.release();
        factory.release();
    }
}
