package ua.lelpel.pmumusicians;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ua.lelpel.pmumusicians.enitities.Band;
import ua.lelpel.pmumusicians.enitities.Musician;

public class MainActivity extends AppCompatActivity implements BandFragment.OnListFragmentInteractionListener, MusicianFragment.OnListFragmentInteractionListener {

    private MusicianFragment musicianFragment;
    private BandFragment bandFragment;
    private MusicianDetailsFragment detailsFragment;
    private FragmentTransaction trans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trans = getSupportFragmentManager().beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            musicianFragment = MusicianFragment.newInstance("");
            bandFragment = new BandFragment();

            trans.add(R.id.musician_fragment, musicianFragment);
            trans.add(R.id.band_fragment, bandFragment);

            trans.commit();
        } else {
            musicianFragment = MusicianFragment.newInstance("");
            bandFragment = new BandFragment();
            detailsFragment = MusicianDetailsFragment.newInstance("", "");
            trans = getSupportFragmentManager().beginTransaction();
            trans.add(R.id.musician_fragment, musicianFragment);
            trans.add(R.id.band_fragment, bandFragment);
            //trans.add(R.id.details_fragment, detailsFragment);
            trans.commit();
        }

    }

    @Override
    public void onBandSelected(Band item) {
        trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.musician_fragment, MusicianFragment.newInstance(item.getName()));
        trans.commit();
    }

    @Override
    public void onMusicianSelected(Musician item) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("ОТРАБОТАЛ", "МЕТОД МЬЮЗИШЕН");
            trans = getSupportFragmentManager().beginTransaction();
            trans.add(R.id.details_fragment, MusicianDetailsFragment.newInstance(item.getName(), item.getDescription()));
            trans.commit();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent i = new Intent(MainActivity.this, MusicianDetailsActivity.class);
            i.putExtra(MusicianDetailsActivity.ARG_NAME, item.getName());
            i.putExtra(MusicianDetailsActivity.ARG_DESC, item.getDescription());
            startActivity(i);
        }

    }
}
