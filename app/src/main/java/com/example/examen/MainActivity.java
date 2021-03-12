package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
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
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ArrayList<Revistas> lstResvistas;
    private InfinitePlaceHolderView mLoadMoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLoadMoreView = (InfinitePlaceHolderView)findViewById(R.id.infinityPlce);
        mLoadMoreView.setHasFixedSize(true);
        mLoadMoreView.setLayoutManager(new LinearLayoutManager(this));
        mLoadMoreView.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

       lstResvistas = new ArrayList<> ();
        try {
            JSONArray JSONlistaRevista=  new JSONArray(result);
            lstResvistas = Revistas.JsonObjectsBuild(JSONlistaRevista);
            RevistaAdapter adapaterRevista= new RevistaAdapter(this, lstResvistas);
            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                    resId);
            adapaterRevista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(MainActivity.this,lstResvistas.get(recyclerView.getChildAdapterPosition(v)).getJournal_id(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, VolumenActivity.class);
                    Bundle b = new Bundle();
                    b.putString("journal_id", lstResvistas.get(mLoadMoreView.getChildAdapterPosition(v)).getJournal_id().replace("Journal_id :",""));
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });
            mLoadMoreView.setLayoutAnimation(animation);
            mLoadMoreView.setAdapter(adapaterRevista);

        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }

    }
}