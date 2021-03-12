package com.example.examen.Adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.example.examen.Model.Edicion;
import com.example.examen.R;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.List;

public class EdicionAdapter extends InfinitePlaceHolderView.Adapter<EdicionAdapter.EdicionViewHolder> implements View.OnClickListener{


    private Context Ctx;
    private List<Edicion> lstEdicion;
    private View.OnClickListener v;

    public EdicionAdapter(Context mCtx, List<Edicion> edicion) {
        this.lstEdicion = edicion;
        Ctx=mCtx;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.v = listener;
    }

    @Override
    public void onClick(View view) {
        if(v!=null){
            v.onClick(view);
        }
    }

    @NonNull
    @Override
    public EdicionAdapter.EdicionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_edicion, null);
        view.setOnClickListener(this);
        return new EdicionAdapter.EdicionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EdicionAdapter.EdicionViewHolder holder, int position) {
        Edicion edicion = lstEdicion.get(position);

        holder.txtSection.setText(edicion.getSection());
        holder.txtEdicionTitle.setText(edicion.getTitle());
        holder.txtAutores.setText(edicion.getAuthors());
        holder.txtEdicionDate.setText(edicion.getDate_published());
        holder.txtUrl.setText(edicion.getUrlViewGalley());

        holder.btnPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DescargarPDF(edicion.getUrlViewGalley());
                //Toast.makeText(Ctx,edicion.getUrlViewGalley(),Toast.LENGTH_LONG).show();
            }
        });

    }


    public void DescargarPDF(String pdf) {

        DownloadManager.Request request=new DownloadManager.Request(Uri.parse("http://www.jtech.ua.es/dadm/restringido/android/sesion01-apuntes.pdf"));

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI|
                DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download");
        request.setDescription("Downloading..");

        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+System.currentTimeMillis());
        DownloadManager manager = (DownloadManager)Ctx.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

    }

    @Override
    public int getItemCount() {
        return lstEdicion.size();
    }

    public class EdicionViewHolder extends InfinitePlaceHolderView.ViewHolder {
        TextView txtSection, txtEdicionTitle, txtAutores,txtEdicionDate, txtUrl;
        Button btnPDF;

        public EdicionViewHolder(View itemView) {
            super(itemView);
            txtSection= itemView.findViewById(R.id.txtSection);
            txtEdicionTitle = itemView.findViewById(R.id.txtEdicionTitle);
            txtAutores = itemView.findViewById(R.id.txtAutores);
            txtEdicionDate = itemView.findViewById(R.id.txtEdicionDate);
            txtUrl = itemView.findViewById(R.id.txtUrl);
             btnPDF = itemView.findViewById(R.id.btnPDF);
        }
    }
}
