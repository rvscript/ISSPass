package com.example.ga_mlsdiscovery.isspass.view;

import android.content.Context;
import android.os.Build;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ga_mlsdiscovery.isspass.R;
import com.example.ga_mlsdiscovery.isspass.pojos.IssResponse;

import java.util.List;
import java.util.Set;

public class ListAdapterIss extends BaseAdapter {
    private static final String TAG = ListAdapterIss.class.getSimpleName();
    private List<IssResponse> issResponseList;
    private Context context;
    private LayoutInflater layoutInflater;
    private Set<View> viewSet;

    //ListAdapter Constructor
    public ListAdapterIss(Context context, List<IssResponse> issResponseList){
        this.issResponseList = issResponseList;
        this.context = context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            viewSet = new ArraySet<View>();
        }
    }
    @Override
    public int getCount() {
        return issResponseList.size();
    }

    @Override
    public Object getItem(int position) {
        return issResponseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IssViewHolder issViewHolder;

        //reduces the number of row items in memory
        if(convertView == null){
            layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.iss_item_layout, null);
            issViewHolder = new IssViewHolder();
            issViewHolder.tvDuration = convertView.findViewById(R.id.tv_duration);
            issViewHolder.tvRiseTime = convertView.findViewById(R.id.tv_risetime);
            //set  view to viewholder class
            convertView.setTag(issViewHolder);
        } else {
            issViewHolder = (IssViewHolder) convertView.getTag();
        }

        final IssResponse issResponse = issResponseList.get(position);
        issViewHolder.tvRiseTime.setText(""+issResponse.getRisetime());
        issViewHolder.tvDuration.setText(""+issResponse.getDuration());
        viewSet.add(convertView);

        Log.i(TAG, "getView: "+position+": "+convertView+" Size "+viewSet.size());
        return convertView;
    }

    private static class IssViewHolder{
        public TextView tvRiseTime;
        public TextView tvDuration;

    }
}
