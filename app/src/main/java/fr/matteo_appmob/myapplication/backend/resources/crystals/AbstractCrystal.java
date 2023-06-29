package fr.matteo_appmob.myapplication.backend.resources.crystals;

import fr.matteo_appmob.myapplication.backend.clicker.CosmicClicker;
import fr.matteo_appmob.myapplication.backend.buildings.IBuilding;
import fr.matteo_appmob.myapplication.backend.resources.AbstractResource;

public abstract class AbstractCrystal extends AbstractResource {

    protected Runnable getTask() {
        return () -> {
            for (IBuilding b : this.getMultipliers()) {
                CosmicClicker.getInstance().getPlanetByClazz(this.getPlanet()).addCrystal(b.getMultiplicator());
            }
        };
    };

}
