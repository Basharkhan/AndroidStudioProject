package seu.ac.bd.travelmanagement.VisitToSylhet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import seu.ac.bd.travelmanagement.MainActivity;
import seu.ac.bd.travelmanagement.R;
import seu.ac.bd.travelmanagement.TravelDetails;

public class PlaceOfSylhet extends AppCompatActivity {
    private ImageView i1, i2, i3, i4, i5, i6;
    private TextView t1, t2, t3, t4, t5, t6;
    private EditText commentField;
    private Button postComment;
    private ListView listView;
    private RequestQueue requestQueue, getRequestQueue;
    private final static String URL = "http://192.168.1.4:8080/addComment";
    private final static String GETURL = "http://192.168.1.4:8080/comments";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_of_sylhet);
        listView = findViewById(R.id.lCommentList);

        i1 = findViewById(R.id.iSustShahidMinar);
        i2 = findViewById(R.id.iMapSust);
        i3 = findViewById(R.id.iLakkatura);
        i4 = findViewById(R.id.iLakkaturaMap);
        i5 = findViewById(R.id.iTilagor);
        i6 = findViewById(R.id.iTilagorMap);


        t1 = findViewById(R.id.tTitleShahidMinar);
        t2 = findViewById(R.id.tShahidMinarFootNote);
        t3 = findViewById(R.id.tTitleLakkatura);
        t4 = findViewById(R.id.tFootNoteLakkatura);
        t5 = findViewById(R.id.tTitleTilagor);
        t6 = findViewById(R.id.tFootNoteTilagor);

        commentField = findViewById(R.id.eCommentPlaceOfSylhet);
        postComment = findViewById(R.id.bPostComment);

        postComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    requestQueue = Volley.newRequestQueue(PlaceOfSylhet.this);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("comment", commentField.getText().toString().trim());
                    final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(getApplicationContext(), "Posted", Toast.LENGTH_LONG).show();
                            commentField.setText("");
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                    requestQueue.add(request);
                }catch (JSONException ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        getInfoFromServer();
    }

    private void getInfoFromServer() {
        getRequestQueue = Volley.newRequestQueue(this);
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                final String comments[] = new String[response.length()];

                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject jsonObject = (JSONObject) response.get(i);
                        comments[i] = jsonObject.getString("comment") + "\n";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                listView.setAdapter(new ArrayAdapter(getApplicationContext(), R.layout.text_view_placeofsylhet, R.id.textViewCommentOnPlaceOfSylhet, comments));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        getRequestQueue.add(jsonArrayRequest);
    }

}
