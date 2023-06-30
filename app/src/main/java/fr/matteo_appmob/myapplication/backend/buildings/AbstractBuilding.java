package fr.matteo_appmob.myapplication.backend.buildings;

import android.util.Log;

import fr.matteo_appmob.myapplication.backend.clicker.CosmicClicker;
import fr.matteo_appmob.myapplication.backend.planets.IPlanet;
import fr.matteo_appmob.myapplication.backend.resources.IResource;

public abstract class AbstractBuilding implements IBuilding {

    protected int countPurchases = 0;

    protected abstract float getInitialPrice();

    protected abstract float getPriceMultiplier();

    protected abstract float getInitialMoneyGenerated();

    public void setup() {
        IPlanet planet = CosmicClicker.getInstance().getPlanetByClazz(this.getPlanet());
        IResource resource = planet.getResourceByClazz(this.getResource());

        resource.addMultiplier(this);
        resource.generate();
    }

    public int getPrice() {
        double price = this.getInitialPrice() * (Math.pow(this.getPriceMultiplier(), getCountUpgrade()));

        return (int) price;
    }

    public int getPrice10() {
        double price = 0;

        for (int i = 0; i < 10; i++) {
            price += this.getInitialPrice() * (Math.pow(this.getPriceMultiplier(), getCountUpgrade() + i));
        }
        return (int) price;
    }

    public int getPrice100() {
        double price = 0;

        for (int i = 0; i < 100; i++) {
            price += this.getInitialPrice() * (Math.pow(this.getPriceMultiplier(), getCountUpgrade() + i));
        }
        return (int) price;
    }

    public void purchase() {

        this.countPurchases++;
    }

    public int getCountUpgrade() {
        return this.countPurchases;
    }


    public int getMultiplicator() {
        double result = (getCountUpgrade() == 0) ? 0 : this.getInitialMoneyGenerated() + getCountUpgrade();
        System.out.println(result);
        return (int) result;
    }

}
