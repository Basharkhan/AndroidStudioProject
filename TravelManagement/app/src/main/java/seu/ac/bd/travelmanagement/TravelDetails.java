package seu.ac.bd.travelmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class TravelDetails extends AppCompatActivity {

    private TextView tripName, fromWhere, toWhere, date, personName, contactNo;
    private Button deleteTripButton;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_details);
        tripName = findViewById(R.id.tTripName);
        fromWhere = findViewById(R.id.tToFrom);
        toWhere = findViewById(R.id.tToWhere);
        date = findViewById(R.id.tDate);
        personName = findViewById(R.id.tPerson);
        contactNo = findViewById(R.id.tContact);
        deleteTripButton = findViewById(R.id.bTripDeleteButton);

        final String _id = getIntent().getStringExtra("id");
        String _tripName = getIntent().getStringExtra("tripName");
        String _fromWhere = getIntent().getStringExtra("fromWhere");
        String _toWhere = getIntent().getStringExtra("toWhere");
        String _date = getIntent().getStringExtra("date");
        String _personName = getIntent().getStringExtra("personName");
        String _contactNo = getIntent().getStringExtra("contactNo");

        tripName.setText(_tripName);
        fromWhere.setText(_fromWhere);
        toWhere.setText(_toWhere);
        date.setText(_date);
        personName.setText(_personName);
        contactNo.setText(_contactNo);

        deleteTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestQueue = Volley.newRequestQueue(TravelDetails.this);
                String name = tripName.getText().toString();
                final String URL = "http://192.168.1.4:8080/deleteTrip/"+_id+"";
                final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(TravelDetails.this, "Removed", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TravelDetails.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}
