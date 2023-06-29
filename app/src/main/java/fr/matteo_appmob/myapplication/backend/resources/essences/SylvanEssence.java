package fr.matteo_appmob.myapplication.backend.resources.essences;

import fr.matteo_appmob.myapplication.backend.planets.IPlanet;
import fr.matteo_appmob.myapplication.backend.planets.XyronPrime;

public class SylvanEssence extends AbstractEssence{

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Class<? extends IPlanet> getPlanet() {
        return XyronPrime.class;
    }
}
