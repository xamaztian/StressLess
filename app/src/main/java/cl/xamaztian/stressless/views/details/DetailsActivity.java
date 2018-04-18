package cl.xamaztian.stressless.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import cl.xamaztian.stressless.R;
import cl.xamaztian.stressless.models.Pending;

public class DetailsActivity extends AppCompatActivity {

    public static final String ID_PENDING = "cl.xamaztian.stressless.views.details.DetailsActivity.KEY.ID_PENDING";

    private Pending pending;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long pendingId = getIntent().getLongExtra(ID_PENDING, 0);
        pending = Pending.findById(Pending.class, pendingId);
        getSupportActionBar().setTitle(pending.getName());

        editText = findViewById(R.id.descriptionEt);

        Toast.makeText(this, pending.getName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, pending.getDescription(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (editText.getText().toString().trim().length() > 0) {
            pending.setDescription(editText.getText().toString());
            pending.save();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (pending.getDescription() != null)
        editText.setText(pending.getDescription());
    }
}
