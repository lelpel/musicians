package ua.lelpel.pmumusicians;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MusicianDetailsActivity extends AppCompatActivity {
    public static final String ARG_NAME = "name";
    public static final String ARG_DESC = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_details);

        String name = getIntent().getStringExtra(ARG_NAME);
        String desc = getIntent().getStringExtra(ARG_DESC);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.details_p_fragment,
                        MusicianDetailsFragment.newInstance(name, desc)).
                commit();
    }
}
