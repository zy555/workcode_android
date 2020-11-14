package com.example.text_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaoAdapter extends RecyclerView.Adapter<TaoAdapter.ViewHolder> {
    private List<Tao>mTaoList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View taoView;
        ImageView taoImage;
        TextView taoName;
        public ViewHolder(View view) {
            super(view);
            taoView=view;
            taoImage = (ImageView) view.findViewById(R.id.tao_image);
            taoName = (TextView) view.findViewById(R.id.tao_name);
        }
}
    public TaoAdapter(List<Tao> taoList) {
        mTaoList=taoList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.tao_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.taoView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position=holder.getAdapterPosition();
            Tao tao=mTaoList.get(position);
            Toast.makeText(v.getContext(),"you clicked view"+tao.getName(),
                    Toast.LENGTH_SHORT).show();
        }
    });
        holder.taoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Tao tao=mTaoList.get(position);
                Toast.makeText(v.getContext(),"you clicked image"+tao.getName(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Tao tao=mTaoList.get(position);
        holder.taoImage.setImageResource(tao.getImageID());
        holder.taoName.setText(tao.getName());
    }
    @Override
    public int getItemCount(){
        return mTaoList.size();
    }
}

