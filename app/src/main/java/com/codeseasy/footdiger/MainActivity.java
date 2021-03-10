package com.codeseasy.footdiger;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codeseasy.footdiger.adapter.AllMenuAdapter;
import com.codeseasy.footdiger.adapter.CategoryAdapter;
import com.codeseasy.footdiger.adapter.RecommendedAdapter;
import com.codeseasy.footdiger.model.Allmenu;
import com.codeseasy.footdiger.model.Category;
import com.codeseasy.footdiger.model.Recommended;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecyclerView, recommendedRecyclerView, allMenuRecyclerView;
    CategoryAdapter categoryAdapter;
    RecommendedAdapter recommendedAdapter;
    AllMenuAdapter allMenuAdapter;
    private List<Recommended> recomendObject;
    private List<Allmenu> AllMenuObject;
    private List<Category> CategoryObject;
    private RecyclerView.LayoutManager manager1,manager2,manager3;
    private static  final String BASE_URL1 = "http://192.168.0.137/Android/foodtiger/showDataFood.php";
    private static  final String BASE_URL2 = "http://192.168.0.137/Android/foodtiger/showDataCategory.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRecommend();
        recommendedRecyclerView= findViewById(R.id.recommended_recycler);
        manager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(manager1);
        recomendObject = new ArrayList<>();

        getAllmenu();
        allMenuRecyclerView= findViewById(R.id.all_menu_recycler);
        manager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(manager2);
        AllMenuObject = new ArrayList<>();

        getCategory();
        categoryRecyclerView= findViewById(R.id.category_recycler);
        manager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(manager3);
        CategoryObject = new ArrayList<>();

    }
    private void getRecommend(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);
                                String name = object.getString("nameFood");
                                String imageUrl = object.getString("imageUrl");
                                String rating = object.getString("rate");
                                String description = object.getString("description");
                                String id = object.getString("f_id");
                                String cart_id = object.getString("cart_id");
                                String price = object.getString("price");

                                Recommended recomend = new Recommended(name,imageUrl,rating,description,id,cart_id,price);
                                recomendObject.add(recomend);
                            }

                        }catch (Exception e){

                        }

                        recommendedAdapter = new RecommendedAdapter(MainActivity.this, recomendObject);
                        recommendedRecyclerView.setAdapter(recommendedAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(),Toast.LENGTH_LONG).show();

            }
        });
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }

    private void getAllmenu(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);
                                String name = object.getString("nameFood");
                                String imageUrl = object.getString("imageUrl");
                                String rating = object.getString("rate");
                                String description = object.getString("description");
                                String id = object.getString("f_id");
                                String cart_id = object.getString("cart_id");
                                String price = object.getString("price");

                                Allmenu allm = new Allmenu(name,imageUrl,rating,description,id,cart_id,price);
                                AllMenuObject.add(allm);
                            }

                        }catch (Exception e){

                        }
                        allMenuAdapter = new AllMenuAdapter(MainActivity.this, AllMenuObject);
                        allMenuRecyclerView.setAdapter(allMenuAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }

    private void getCategory(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);
                                String name = object.getString("name");
                                String imageUrl = object.getString("imageUrl");
                                String description = object.getString("description");
                                String id = object.getString("c_id");

                                Category categorym = new Category(name,imageUrl,description,id);
                                CategoryObject.add(categorym);
                            }

                        }catch (Exception e){

                        }
                        categoryAdapter = new CategoryAdapter(MainActivity.this, CategoryObject);
                        categoryRecyclerView.setAdapter(categoryAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }
    }
