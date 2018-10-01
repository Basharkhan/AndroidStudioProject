package seu.ac.bd.travelmanagement;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;


public class AddTrip extends AppCompatActivity {

    private EditText tripNameField, fromWhereField, dateField, toWhereField, nameField, contactField;

    private Button postButton, datePickerButton;
    private RequestQueue requestQueue;
    private final static String URL = "http://192.168.1.4:8080/addTrip";
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        tripNameField = findViewById(R.id.eTripName);
        fromWhereField = findViewById(R.id.eFrom);
        toWhereField = findViewById(R.id.eTo);
        nameField = findViewById(R.id.eName);
        contactField = findViewById(R.id.eContact);
        postButton = findViewById(R.id.bPost);
        datePickerButton = findViewById(R.id.bDatePickerButton);
        dateField = findViewById(R.id.eDateField);


        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(AddTrip.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        dateField.setText(mDay + "/" + mMonth + "/" + mYear);
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                requestQueue = Volley.newRequestQueue(AddTrip.this);
                try {
                    JSONObject jsonObject = new JSONObject();

                    if(TextUtils.isEmpty(tripNameField.getText())){
                        tripNameField.setError("Trip name is required.");
                        return;
                    }

                    jsonObject.put("tripName", tripNameField.getText().toString().trim());
                    jsonObject.put("fromWhere", fromWhereField.getText().toString().trim());
                    jsonObject.put("toWhere", toWhereField.getText().toString().trim());
                    jsonObject.put("date", dateField.getText().toString().trim());
                    jsonObject.put("personName", nameField.getText().toString().trim());
                    jsonObject.put("contactNo", contactField.getText().toString().trim());

                    final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(AddTrip.this, "Posted", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AddTrip.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                    requestQueue.add(request);
                } catch (JSONException ex){
                    ex.printStackTrace();
                }
            }
        });

    }
}
