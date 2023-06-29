package fr.matteo_appmob.myapplication.backend.planets;

import fr.matteo_appmob.myapplication.backend.buildings.IBuilding;
import fr.matteo_appmob.myapplication.backend.resources.IResource;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlanet implements IPlanet {

    public static final String PLANET_ID = "P-XP";

    List<IBuilding> buildings = new ArrayList<>();
    List<IResource> resources = new ArrayList<>();
    long            crystals  = 0;

    public long getCrystals() {
        return this.crystals;
    }

    public void addCrystal(long crystal) {
        this.crystals += crystal;
    }

    public List<IBuilding> getBuildings() {
        return this.buildings;
    }

    public List<IResource> getResources() {
        return this.resources;
    }

    public IBuilding getBuildingByClazz(Class<? extends IBuilding> clazz) {
        return this.getBuildings().stream().filter(building -> building.getClass().equals(clazz)).findFirst().orElse(null);
    }

    public IResource getResourceByClazz(Class<? extends IResource> clazz) {
        return this.getResources().stream().filter(resource -> resource.getClass().equals(clazz)).findFirst().orElse(null);
    }

    public boolean canUpgradeNewPlanet() {
        //NOT IMPLEMENTED
        return false;
    }

    public void run() {
        for (IBuilding b : this.getBuildings()) {
            b.setup();
        }
    }
}
