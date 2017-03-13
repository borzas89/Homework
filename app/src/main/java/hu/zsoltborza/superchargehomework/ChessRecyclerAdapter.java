package hu.zsoltborza.superchargehomework;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by Borzas on 2017. 03. 13..
 */

public class ChessRecyclerAdapter extends RecyclerView.Adapter<ChessRecyclerAdapter.ChessViewHolder> {

    public List<String> mQueensList;

    private Context mContext;
    private LayoutInflater inflater;
    private final TypedValue mTypedValue = new TypedValue();

    public ChessRecyclerAdapter(Context context, List<String> queensList){
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        inflater = LayoutInflater.from(context);
        mContext = context;
        mQueensList = queensList;

    }


    @Override
    public ChessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_chess, parent, false);

        return new ChessViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChessViewHolder holder, final int position) {

        String queenItem = mQueensList.get(position);

        holder.tvData.setText(queenItem);
        holder.tvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQueensList.get(position);
             //   Toast.makeText(mContext, mQueensList.get(position)+ " clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return mQueensList.size();
    }





    public class ChessViewHolder extends RecyclerView.ViewHolder {

        TextView tvData;

        public ChessViewHolder(View itemView) {
            super(itemView);
           tvData = (TextView) itemView.findViewById(R.id.tvData);


        }


    }


}
