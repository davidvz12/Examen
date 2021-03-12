package com.example.examen.Adapter;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.examen.Model.Edicion;
import com.example.examen.Model.Volumenes;
import com.example.examen.R;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
                DescargarPDF(edicion.getUrlViewGalley(),edicion.getSection());
            }
        });

    }

    public void DescargarPDF(String pdf,String name) {
        try {
            URL url = new URL(pdf);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();

            String Path = Environment.getExternalStorageDirectory() + "/download/";
            Log.v("PdfManager", "PATH: " + Path);
            File file = new File(Path);
            file.mkdirs();
            FileOutputStream fos = new FileOutputStream(name+".pdf");

            InputStream is = c.getInputStream();

            byte[] buffer = new byte[702];
            int len1 = 0;
            while ((len1 = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len1);
            }
            fos.close();
            is.close();
        } catch (IOException e) {
            Log.d("PdfManager", "Error: " + e);
        }
        Log.v("PdfManager", "Check: ");
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
