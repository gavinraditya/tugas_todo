package com.pam.demo_rest2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url = "https://mgm.ub.ac.id/todo.php";
    ArrayList<Data> dataList = new ArrayList<>();
    RecyclerView rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = this.findViewById(R.id.rvData);
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Proses respons JSONArray
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                Data data = new Data(jsonObject.getInt("id"), jsonObject.getString("what"),
                                        jsonObject.getString("time"));

                                dataList.add(data);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        DataAdapter adapter = new DataAdapter(MainActivity.this, dataList);
                        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);

                        rvData.setLayoutManager(lm);
                        rvData.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Process error...
                Log.e("example error", error.getMessage(), error);
            }
        });

        queue.add(jsonArrayRequest);


    }
}
