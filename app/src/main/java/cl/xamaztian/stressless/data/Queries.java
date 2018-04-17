package cl.xamaztian.stressless.data;

import java.util.ArrayList;
import java.util.List;

import cl.xamaztian.stressless.models.Pending;

/**
 * Created by Xamaztian on 15-04-2018.
 */

public class Queries {

    public List<Pending> pendings() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0 ");

        if (pendingList != null && pendingList.size() > 0)
            pendings.addAll(pendingList);

        return pendings;
    }
}
