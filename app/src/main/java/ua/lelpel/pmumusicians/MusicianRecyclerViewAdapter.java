package ua.lelpel.pmumusicians;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ua.lelpel.pmumusicians.MusicianFragment.OnListFragmentInteractionListener;
import ua.lelpel.pmumusicians.dummy.DummyContent.DummyItem;
import ua.lelpel.pmumusicians.enitities.DummyItems;
import ua.lelpel.pmumusicians.enitities.Musician;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MusicianRecyclerViewAdapter extends RecyclerView.Adapter<MusicianRecyclerViewAdapter.ViewHolder> {

    private final List<Musician> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MusicianRecyclerViewAdapter(OnListFragmentInteractionListener listener, String title) {
        mValues = DummyItems.getMembers(title);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_musician, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(holder.mItem.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onMusicianSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public Musician mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.membername);
        }
    }
}
