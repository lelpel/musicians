package ua.lelpel.pmumusicians;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ua.lelpel.pmumusicians.BandFragment.OnListFragmentInteractionListener;
import ua.lelpel.pmumusicians.enitities.Band;
import ua.lelpel.pmumusicians.enitities.DummyItems;

import java.util.List;

public class BandRecyclerViewAdapter extends RecyclerView.Adapter<BandRecyclerViewAdapter.ViewHolder> {

    private final List<Band> mValues;
    private final OnListFragmentInteractionListener mListener;

    public BandRecyclerViewAdapter(OnListFragmentInteractionListener listener) {
        mValues = DummyItems.getBands();
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_band, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mName.setText(holder.mItem.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onBandSelected(holder.mItem);
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
        public final TextView mName;
        public Band mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mName = view.findViewById(R.id.bandname);
        }

    }
}
