package cl.xamaztian.stressless.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.xamaztian.stressless.R;
import cl.xamaztian.stressless.adapters.PendingClickListener;
import cl.xamaztian.stressless.adapters.PendingsAdapter;
import cl.xamaztian.stressless.models.Pending;
import cl.xamaztian.stressless.views.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class PendingsFragment extends Fragment implements PendingClickListener {

    public static final String ID_PENDING = "cl.xamaztian.stressless.views.details.DetailsActivity.KEY.ID_PENDING";

    private PendingsAdapter adapter;

    public PendingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.pendingRV);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //for (int i = 0; i < 20; i++) {
        //    Pending pending = new Pending();
        //    pending.setName(String.valueOf(i));
        //    pending.setDone(false);
        //    pending.save();
        //}

        adapter = new PendingsAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void updateList(Pending pending){
        adapter.update(pending);
        Log.d("pending", pending.getName());
    }

    @Override
    public void clickeId(long id) {
        Toast.makeText(getContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra(ID_PENDING, id);
        startActivity(intent);
    }
}
