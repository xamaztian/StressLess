package cl.xamaztian.stressless.models;

import com.orm.SugarRecord;

/**
 * Created by Xamaztian on 15-04-2018.
 */

public class Pending extends SugarRecord {

    private String name, description;
    private boolean done;

    public Pending() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
