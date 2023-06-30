package fr.matteo_appmob.myapplication.backend.resources;

import fr.matteo_appmob.myapplication.backend.buildings.IBuilding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractResource implements IResource{

    protected long            generatingTime = 1;
    private       boolean         isGenerating = false;
    private final List<IBuilding> multipliers  = new ArrayList<>();

    public void addMultiplier(IBuilding multiplier) {
        this.multipliers.add(multiplier);
    }

    public List<IBuilding> getMultipliers() {
        return this.multipliers;
    }

    public void setGeneratingTime(long generatingTime) {
        this.generatingTime = generatingTime;
    }

    public long getGeneratingTime() {
        return generatingTime;
    }

    protected abstract Runnable getTask();

    public void generate() {

        if (this.isGenerating) return;

        this.isGenerating = true;

        Thread t = new Thread(() -> {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            scheduler.scheduleAtFixedRate(this.getTask(), 0, this.getGeneratingTime(), TimeUnit.SECONDS);
        });

        t.start();
    }

}
