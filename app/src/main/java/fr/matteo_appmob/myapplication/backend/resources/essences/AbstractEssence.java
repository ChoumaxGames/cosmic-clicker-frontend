package fr.matteo_appmob.myapplication.backend.resources.essences;

import fr.matteo_appmob.myapplication.backend.clicker.CosmicClicker;
import fr.matteo_appmob.myapplication.backend.buildings.IBuilding;
import fr.matteo_appmob.myapplication.backend.resources.AbstractResource;

public abstract class AbstractEssence extends AbstractResource {

    protected Runnable getTask() {
        return () -> {
            for (IBuilding b : this.getMultipliers()) {
                CosmicClicker.getInstance().addEssences(b.getMultiplicator());
            }
        };
    };

}
