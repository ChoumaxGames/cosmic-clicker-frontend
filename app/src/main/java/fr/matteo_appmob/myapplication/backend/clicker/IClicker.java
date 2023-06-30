package fr.matteo_appmob.myapplication.backend.clicker;

import android.media.MediaPlayer;

import fr.matteo_appmob.myapplication.backend.planets.IPlanet;
import fr.matteo_appmob.myapplication.backend.players.PlayerRecord;

import java.util.List;

public interface IClicker {
    IPlanet getPlanetById(String id);
    IPlanet getPlanetByClazz(Class<? extends IPlanet> clazz);
    void addPlanets(IPlanet... planets);

    List<IPlanet> getPlanetList();

    IPlanet getCurrentPlanet();
    PlayerRecord getPlayer();
    void setCurrentPlanet(IPlanet planet);
    void setPlayer(PlayerRecord player);

    public void setMediaPlayer(MediaPlayer mediaPlayer);

    public MediaPlayer getMediaPlayer();

    long getEssences();
    void addEssences(long essences);

}
