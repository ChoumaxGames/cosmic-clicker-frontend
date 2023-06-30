package fr.matteo_appmob.myapplication.backend.planets;

import fr.matteo_appmob.myapplication.backend.buildings.Arboretum;
import fr.matteo_appmob.myapplication.backend.buildings.FonderieCrystalline;
import fr.matteo_appmob.myapplication.backend.resources.crystals.SapCrystal;
import fr.matteo_appmob.myapplication.backend.resources.essences.SylvanEssence;

/**
 * First Planet
 */
public class XyronPrime extends AbstractPlanet {

    public static final String PLANET_ID = "P-XP";

    public XyronPrime() {
        resources.add(new SapCrystal());
        resources.add(new SylvanEssence());
        buildings.add(new Arboretum());
        buildings.add(new FonderieCrystalline());
    }

    @Override
    public String getId() {
        return PLANET_ID;
    }

    public String getName() {
        return "XyronPrime";
    }

    public String getDescription() {
        return "Xyron Prime est une planète recouverte de jungles luxuriantes et abritant une flore et une faune extrêmement diversifiées. " +
               "Les vastes forêts cachent de précieuses ressources naturelles et des secrets mystérieux.";
    }
}
