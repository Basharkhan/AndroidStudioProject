package seu.ac.bd.travelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import seu.ac.bd.travelmanagement.VisitToChittagong.Chittagong;
import seu.ac.bd.travelmanagement.VisitToSylhet.Sylhet;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;
    private boolean isSpinnerTouched = false;
    private ListView listView;
    private Button addTripButton;
    private final static String URL = "http://192.168.1.4:8080/trips";
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lListView);
        addTripButton = findViewById(R.id.bAddTrip);
        spinner = findViewById(R.id.spinner);

        //Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.district, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Where do you want to go?");
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });
        //adding trip
        addTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddTrip.class));
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        getInfoFromServer();
    }

    private void getInfoFromServer() {
        requestQueue = Volley.newRequestQueue(this);
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                final String id[] = new String[response.length()];
                final String tripName[] = new String[response.length()];
                final String fromWhere[] = new String[response.length()];
                final String toWhere[] = new String[response.length()];
                final String date[] = new String[response.length()];
                final String personName[] = new String[response.length()];
                final String contactNo[] = new String[response.length()];

                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject jsonObject = (JSONObject) response.get(i);
                        id[i] = jsonObject.getString("id");
                        tripName[i] = jsonObject.getString("tripName") + "\n";
                        fromWhere[i] = jsonObject.getString("fromWhere") + "\n";
                        toWhere[i] = jsonObject.getString("toWhere") + "\n";
                        date[i] = jsonObject.getString("date") + "\n";
                        personName[i] = jsonObject.getString("personName") + "\n";
                        contactNo[i] = jsonObject.getString("contactNo") + "\n";

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                listView.setAdapter(new ArrayAdapter(getApplicationContext(), R.layout.text_view, R.id.textView, tripName));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent intent = new Intent(MainActivity.this, TravelDetails.class);
                        intent.putExtra("id", id[position]);
                        intent.putExtra("tripName", tripName[position]);
                        intent.putExtra("fromWhere", fromWhere[position]);
                        intent.putExtra("toWhere", toWhere[position]);
                        intent.putExtra("date", date[position]);
                        intent.putExtra("personName", personName[position]);
                        intent.putExtra("contactNo", contactNo[position]);
                        startActivity(intent);
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if (isSpinnerTouched == false)
            return;
        else{
            String text = adapterView.getItemAtPosition(position).toString();
            System.out.println("Text " + text);
            if(text.equals("Chittagong")) {
                startActivity(new Intent(MainActivity.this, Chittagong.class));
                Toast.makeText(this, text + " is selected.", Toast.LENGTH_SHORT).show();
            }
            else if (text.equals("Dhaka")){
                Toast.makeText(this, text + " is selected.", Toast.LENGTH_SHORT).show();
            }
            else if (text.equals("Sylhet")){
                startActivity(new Intent(MainActivity.this, Sylhet.class));
                Toast.makeText(this, text + " is selected.", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
