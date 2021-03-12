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
import com.example.examen.Model.Volumenes;
import com.example.examen.R;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

public class VolumenAdapter extends InfinitePlaceHolderView.Adapter<VolumenAdapter.VolumenViewHolder> implements View.OnClickListener{

    private Context Ctx;
    private List<Volumenes> lstVolumen;
    private View.OnClickListener v;

    public VolumenAdapter(Context mCtx, List<Volumenes> volumen) {
        this.lstVolumen = volumen;
        Ctx=mCtx;
    }


    @Override
    public void onClick(View view) {
        if(v!=null){
            v.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.v = listener;
    }

    @NonNull
    @Override
    public VolumenAdapter.VolumenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_volumen, null);
        view.setOnClickListener(this);
        return new VolumenAdapter.VolumenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolumenAdapter.VolumenViewHolder holder, int position) {
        Volumenes volumen = lstVolumen.get(position);

        holder.txtTitle.setText(volumen.getTitle());
        holder.txtDate.setText(volumen.getDate_published());
        holder.txtDoy.setText(volumen.getDoi());
        holder.txtissui.setText(volumen.getIssue_id());
        holder.txtnumber.setText(volumen.getNumber());
        holder.txtVolumen.setText(volumen.getVolume());
        holder.txtYear.setText(volumen.getYear());

        Glide.with(Ctx)
                .load(volumen.getCover())
                .into(holder.imgCover);
    }

    @Override
    public int getItemCount() {
        return lstVolumen.size();
    }

    public class VolumenViewHolder extends InfinitePlaceHolderView.ViewHolder {

        TextView txtTitle, txtDate, txtDoy,txtissui, txtnumber,txtVolumen,txtYear;
        ImageView imgCover;

        public VolumenViewHolder(View itemView) {
            super(itemView);
            txtTitle= itemView.findViewById(R.id.txtTitle);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtDoy = itemView.findViewById(R.id.txtDoy);
            txtissui = itemView.findViewById(R.id.txtissui);
            txtnumber = itemView.findViewById(R.id.txtnumber);
            txtVolumen = itemView.findViewById(R.id.txtVolumen);
            txtYear = itemView.findViewById(R.id.txtYear);
            imgCover = itemView.findViewById(R.id.imgCover);
        }

    }
}
