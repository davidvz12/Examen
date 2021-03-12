package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.examen.Adapter.EdicionAdapter;
import com.example.examen.Adapter.VolumenAdapter;
import com.example.examen.Model.Edicion;
import com.example.examen.Model.Revistas;
import com.example.examen.Model.Volumenes;
import com.example.examen.WebService.Asynchtask;
import com.example.examen.WebService.WebService;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EdicionActivity extends AppCompatActivity implements Asynchtask {

    ArrayList<Edicion> lstEdicion;
    private InfinitePlaceHolderView mLoadMoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.infinityPlceEdi);
        mLoadMoreView.setHasFixedSize(true);
        mLoadMoreView.setLayoutManager(new LinearLayoutManager(this));
        mLoadMoreView.setItemAnimator(new DefaultItemAnimator());

        Bundle bundle = this.getIntent().getExtras();

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id="+bundle.getString("Issue_id"),
                datos, EdicionActivity.this, EdicionActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        lstEdicion = new ArrayList<> ();
        try {
            JSONArray JSONlistaEdicion =  new JSONArray(result);
            lstEdicion = Edicion.JsonObjectsBuild(JSONlistaEdicion);
            EdicionAdapter adapaterEdicion= new EdicionAdapter(this, lstEdicion);
            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                    resId);
            mLoadMoreView.setLayoutAnimation(animation);
            mLoadMoreView.setAdapter(adapaterEdicion);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }

    }
}