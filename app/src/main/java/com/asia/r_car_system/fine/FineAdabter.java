package com.asia.r_car_system.fine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;



import com.asia.r_car_system.R;
import java.util.ArrayList;

class FineAdabter extends RecyclerView.Adapter<FineAdabter.ViewHolder> {


    //vars
    private ArrayList<FindModel> myList;
    private Context mContext;

    // this is constructor get context and data list to adabter
    FineAdabter(Context context, ArrayList<FindModel> myList/*data list*/) {
        this.myList = myList;
        this.mContext = context;
    }

    // inflate one or more items(views) into RecyclerView
    @NonNull
    @Override
    public FineAdabter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fine, parent, false);
        return new FineAdabter.ViewHolder(view);
    }

    //set data in views
    @Override
    public void onBindViewHolder(@NonNull final FineAdabter.ViewHolder holder, final int position) {

        final FindModel object = myList.get(position);//get object from list
        try {
            holder.txVw_date.setText(object.getDate());
            holder.txVw_value.setText(object.getValue());
            holder.txVw_speed.setText(object.getSpeed());
        } catch (NullPointerException ignored) {

        }


    }

    //get number of items
    @Override
    public int getItemCount() {
        return myList.size();
    }

    // hold on item views
    class ViewHolder extends RecyclerView.ViewHolder {
        //views
        private TextView txVw_date, txVw_value, txVw_speed;


        ViewHolder(View itemView) {
            super(itemView);
            // find views by id
            txVw_date = itemView.findViewById(R.id.itemFine_txVw_date);
            txVw_value = itemView.findViewById(R.id.itemFine_txVw_value);
            txVw_speed = itemView.findViewById(R.id.itemFine_txVw_speed);
        }
    }
}
