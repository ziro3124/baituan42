package com.example.myapplication.tuan4;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;

import javax.xml.namespace.QName;

public class Tuan41volleyFn {
    String strJSON="";
    public void getJSONArrayOfObject(Context context, TextView textView)
    {
        // tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //url
        String url="https://github.com/hungnttg/ThangLong-FA23-Android/blob/main/a.json";
        // goi Request
        JsonArrayRequest request=new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //chuyen mang
                        for(int i=0; i<response.length();i++)
                        {
                            try {
                                JSONObject person=response.getJSONObject(i);
                                String id= person.getString("id");
                                String name=person.getString("name");
                                String email= person.getString("email");
                                //
                                strJSON += "Id: " + id + "\n";
                                strJSON += "name: " + name + "\n";
                                strJSON += "email: " + email + "\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textView.setText(strJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        //thuc thi Request
        queue.add(request);
    }
}
