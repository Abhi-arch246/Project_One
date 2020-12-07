package com.abhi.projectone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

    public class    Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private List<Model> modelList;
        private Context ctx;

        public Adapter(List<Model> modelList, Context ctx) {
            this.modelList = modelList;
            this.ctx = ctx;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
            final Model ld=modelList.get(position);
            holder.txttitle.setText(ld.getTitle());
            holder.txtdesc.setText(ld.getDescription());
            Picasso.get().load(ld.getImage()).into(holder.txtimg);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(holder.linearLayout.getContext(),ld.getTitle()+" Clicked",Toast.LENGTH_SHORT).show();
                    Intent detail=new Intent(ctx,DetailActivity.class);
                    detail.putExtra("detail_title",ld.getTitle());
                    detail.putExtra("detail_desc",ld.getDescription());
                    detail.putExtra("detail_img",ld.getImage());
                    detail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.linearLayout.getContext().startActivity(detail);
                }
            });

        }



        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView txttitle,txtdesc;
            ImageView txtimg;
            LinearLayout linearLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                txttitle= itemView.findViewById(R.id.idtxt);
                txtdesc=itemView.findViewById(R.id.nametxt);
                txtimg=itemView.findViewById(R.id.movietxt);
                linearLayout=itemView.findViewById(R.id.lasd);
            }
        }

    }
