package com.example.examen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.examen.Model.Revistas;
import com.example.examen.R;

import java.util.List;

public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.RevistaViewHolder> implements View.OnClickListener{

    private Context Ctx;
    private List<Revistas> lstRevista;
    private View.OnClickListener v;

    public RevistaAdapter(Context mCtx, List<Revistas> revista) {
        this.lstRevista = revista;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public RevistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_revistas, null);
        view.setOnClickListener(this);
        return new RevistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaViewHolder holder, int position) {
        Revistas revista = lstRevista.get(position);

        holder.txtNameTitle.setText(revista.getName());
        holder.txtDescription.setText(revista.getDescription());
        holder.txtAbrev.setText(revista.getAbbreviation());
        holder.txtJournal.setText(revista.getJournal_id());

        Glide.with(Ctx)
                .load(revista.getPortada())
                .into(holder.imgPortada);
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.v = listener;
    }
    @Override
    public int getItemCount() {
        return lstRevista.size();
    }

    @Override
    public void onClick(View view) {
        if(v!=null){
            v.onClick(view);
        }

    }

    public class RevistaViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameTitle, txtDescription, txtAbrev,txtJournal;
        ImageView imgPortada;

        public RevistaViewHolder(View itemView) {
            super(itemView);
            txtNameTitle= itemView.findViewById(R.id.txtNameTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtAbrev = itemView.findViewById(R.id.txtAbrev);
            txtJournal = itemView.findViewById(R.id.txtJournal);
            imgPortada = itemView.findViewById(R.id.imgPortada);
        }

    }
}
