package com.abhi.projectone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {
    private List<Modelq> modelqList;
    private Context mctx;

    public QuotesAdapter(List<Modelq> modelqList, Context mctx) {
        this.modelqList = modelqList;
        this.mctx = mctx;
    }

    @NonNull
    @Override
    public QuotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mctx).inflate(R.layout.single_quote,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.ViewHolder holder, int position) {
        final Modelq lq=modelqList.get(position);
        holder.textView.setText(lq.getText());


    }

    @Override
    public int getItemCount() {
        return modelqList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.qtext);
        }
    }
}
