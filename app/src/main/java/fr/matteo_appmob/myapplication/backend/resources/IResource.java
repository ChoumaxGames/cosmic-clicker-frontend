package fr.matteo_appmob.myapplication.backend.resources;

import fr.matteo_appmob.myapplication.backend.buildings.IBuilding;
import fr.matteo_appmob.myapplication.backend.planets.IPlanet;

import java.util.List;

public interface IResource {

    String getId();
    String getName();
    String getDescription();

    Class<? extends IPlanet> getPlanet();

    void addMultiplier(IBuilding multiplier);

    List<IBuilding> getMultipliers();

    void generate();

    void setGeneratingTime(long generatingTime);
    long getGeneratingTime();



}
