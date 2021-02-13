package com.vedaant.covidash.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.vedaant.covidash.model.actualdata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class databank {
    ArrayList<actualdata> dataList = new ArrayList<actualdata>();
    private String url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
    public List<actualdata> getData(final DataListAsyncResponse callBack) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                actualdata data = new actualdata("0", "0", "0", "0");
                try {
                    data.setActiveCases(response.getString("activeCases"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return dataList;
    }
}
