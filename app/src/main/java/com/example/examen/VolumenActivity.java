package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.examen.Adapter.RevistaAdapter;
import com.example.examen.Model.Revistas;
import com.example.examen.WebService.Asynchtask;
import com.example.examen.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VolumenActivity extends AppCompatActivity implements Asynchtask {
    RecyclerView recyclerView;
    ArrayList<Revistas> lstVolumen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewVolumen);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Bundle bundle = this.getIntent().getExtras();


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+bundle.getString("journal_id"),
                datos, VolumenActivity.this, VolumenActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        lstVolumen = new ArrayList<> ();
        try {
            JSONArray JSONlistaVolumen=  new JSONArray(result);
            lstVolumen = Revistas.JsonObjectsBuild(JSONlistaVolumen);
            RevistaAdapter adapaterVolumen= new RevistaAdapter(this, lstVolumen);
            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                    resId);
            adapaterVolumen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(VolumenActivity.this, VolumenActivity.class);
                    //Bundle b = new Bundle();
                    //b.putString("journal_id", lstVolumen.get(recyclerView.getChildAdapterPosition(v)).getJournal_id().replace("Journal_id :",""));
                    //intent.putExtras(b);
                    //startActivity(intent);
                }
            });
            recyclerView.setLayoutAnimation(animation);
            recyclerView.setAdapter(adapaterVolumen);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }

    }
}