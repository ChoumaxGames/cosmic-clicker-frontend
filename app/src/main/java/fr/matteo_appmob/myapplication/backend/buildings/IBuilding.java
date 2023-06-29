package fr.matteo_appmob.myapplication.backend.buildings;

import fr.matteo_appmob.myapplication.backend.planets.IPlanet;
import fr.matteo_appmob.myapplication.backend.resources.IResource;

public interface IBuilding {

    String getId();

    String getName();

    String getDescription();

    Class<? extends IPlanet> getPlanet();

    Class<? extends IResource> getResource();

    int getPrice();

    void purchase();

    int getCountUpgrade();

    int getMultiplicator();

    void setup();
}
