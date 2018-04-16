package ua.lelpel.pmumusicians;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicianDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicianDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_DESC = "description";

    // TODO: Rename and change types of parameters
    private String name;
    private String description;


    public MusicianDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param description Parameter 2.
     * @return A new instance of fragment MusicianDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicianDetailsFragment newInstance(String name, String description) {
        MusicianDetailsFragment fragment = new MusicianDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_DESC, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            description = getArguments().getString(ARG_DESC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(name + "\n" + description);
        return textView;
    }

}
