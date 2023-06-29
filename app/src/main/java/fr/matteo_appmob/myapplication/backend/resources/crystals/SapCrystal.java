package fr.matteo_appmob.myapplication.backend.resources.crystals;

import fr.matteo_appmob.myapplication.backend.planets.IPlanet;
import fr.matteo_appmob.myapplication.backend.planets.XyronPrime;

public class SapCrystal extends AbstractCrystal {

    public String getId() {
        return "C-SAPCRYSTAL";
    }
    public String getName() {
        return "Cristaux de Sève";
    }

    public String getDescription() {
        return null;
    }

    @Override
    public Class<? extends IPlanet> getPlanet() {
        return XyronPrime.class;
    }
}
