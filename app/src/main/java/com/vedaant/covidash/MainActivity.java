package com.vedaant.covidash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.vedaant.covidash.model.actualdata;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;

    private TextView totalCases, activeCases, recoveredCases, deceasedCases, vaccinatedCases, updatedText;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    private String url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);
        totalCases = findViewById(R.id.total_text);
        activeCases = findViewById(R.id.active_text);
        recoveredCases = findViewById(R.id.recovered_text);
        deceasedCases = findViewById(R.id.deceased_text);
        vaccinatedCases = findViewById(R.id.vaccinated_text);
        updatedText = findViewById(R.id.updated_text);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        date = dateFormat.format(calendar.getTime());
        updatedText.setText(date);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                actualdata data = new actualdata("0", "0", "0", "0");
                try {
                    data.setActiveCases(response.getString("activeCases"));
                    data.setTotalCases(response.getString("totalCases"));
                    data.setRecoveredCases(response.getString("recovered"));
                    data.setDeceasedCases(response.getString("deaths"));
                    Log.d("trial", "onResponse: "+data.getActiveCases()+data.getDeceasedCases()+data.getRecoveredCases()+data.getTotalCases());

                    totalCases.setText(data.getTotalCases());
                    activeCases.setText(data.getActiveCases());
                    recoveredCases.setText(data.getRecoveredCases());
                    deceasedCases.setText(data.getDeceasedCases());
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("fail", "onResponse: fail");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);




    }
}