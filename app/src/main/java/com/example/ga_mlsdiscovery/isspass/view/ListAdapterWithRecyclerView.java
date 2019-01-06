package com.example.ga_mlsdiscovery.isspass.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ga_mlsdiscovery.isspass.R;
import com.example.ga_mlsdiscovery.isspass.pojos.IssResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ListAdapterWithRecyclerView extends RecyclerView.Adapter<ListAdapterWithRecyclerView.IssViewHolder> {
    private static final String TAG = ListAdapterWithRecyclerView.class.getSimpleName();

    private List<IssResponse> issList;
    private Context context;

    @Inject
    public ListAdapterWithRecyclerView(Context context) {
        this.issList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public IssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_iss_row_item, parent, false);
        return new IssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssViewHolder holder, int position) {
        final IssResponse issResponse = issList.get(position);

        holder.tvRise.setText(""+issResponse.getRisetime());
        holder.tvDuration.setText(""+issResponse.getDuration());
    }

    @Override
    public int getItemCount() {
        return issList.size();
    }

    //Row class to populate from list.get(i)
    public class IssViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRise;
        public TextView tvDuration;

        public IssViewHolder(View view) {
            super(view);
            tvRise = view.findViewById(R.id.tv_rise);
            tvDuration = view.findViewById(R.id.tv_duration);
        }
    }

    public void setData(List<IssResponse> data){
        issList.clear();
        issList.addAll(data);
        notifyDataSetChanged();
    }
}
