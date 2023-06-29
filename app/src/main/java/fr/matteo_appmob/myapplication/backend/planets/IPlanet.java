package fr.matteo_appmob.myapplication.backend.planets;

import fr.matteo_appmob.myapplication.backend.buildings.IBuilding;
import fr.matteo_appmob.myapplication.backend.resources.IResource;

import java.util.List;

public interface IPlanet {


    String getId();
    String getName();
    String getDescription();

    long getCrystals();
    void addCrystal(long crystal);

    List<IBuilding> getBuildings();
    List<IResource> getResources();

    IBuilding getBuildingByClazz(Class<? extends IBuilding> clazz);
    IResource getResourceByClazz(Class<? extends IResource> clazz);

    boolean canUpgradeNewPlanet();

    void run();
}
