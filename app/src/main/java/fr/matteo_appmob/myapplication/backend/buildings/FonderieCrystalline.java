package fr.matteo_appmob.myapplication.backend.buildings;

import fr.matteo_appmob.myapplication.backend.planets.IPlanet;
import fr.matteo_appmob.myapplication.backend.planets.XyronPrime;
import fr.matteo_appmob.myapplication.backend.resources.IResource;
import fr.matteo_appmob.myapplication.backend.resources.essences.SylvanEssence;

public class FonderieCrystalline extends AbstractBuilding {
    public String getId() {
        return "B-FC";
    }

    public String getName() {
        return "Fonderie";
    }

    public String getDescription() {
        return null;
    }

    public Class<? extends IPlanet> getPlanet() {
        return XyronPrime.class;
    }

    public Class<? extends IResource> getResource() {
        return SylvanEssence.class;
    }

    @Override
    protected float getInitialPrice() {
        return 1000f;
    }

    @Override
    protected float getPriceMultiplier() {
        return 1.15f;
    }

    @Override
    protected float getInitialMoneyGenerated() {
        return 1f;
    }
}