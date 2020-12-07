package com.abhi.projectone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.ViewHolder> {
    private List<Modelf> modelfList;
    private Context nctx;

    public FactsAdapter(List<Modelf> modelfList, Context nctx) {
        this.modelfList = modelfList;
        this.nctx = nctx;
    }

    @NonNull
    @Override
    public FactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(nctx).inflate(R.layout.single_fact,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactsAdapter.ViewHolder holder, int position) {
        final Modelf lf=modelfList.get(position);
        holder.mtextview.setText(lf.getFtext());

    }

    @Override
    public int getItemCount() {
        return modelfList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mtextview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtextview=itemView.findViewById(R.id.ftext);
        }
    }
}
