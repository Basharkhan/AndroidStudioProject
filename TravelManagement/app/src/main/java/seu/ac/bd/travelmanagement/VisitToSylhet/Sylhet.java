package seu.ac.bd.travelmanagement.VisitToSylhet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import seu.ac.bd.travelmanagement.AddTrip;
import seu.ac.bd.travelmanagement.R;

public class Sylhet extends AppCompatActivity {
    private TextView t1, t2;
    private ImageView i1, i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylhet);

        t1 = findViewById(R.id.tTitleSylet);
        t2 = findViewById(R.id.tCreateTrip);

        i1 = findViewById(R.id.iWhatToDoSylet);
        i2 = findViewById(R.id.iFoodSylhet);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sylhet.this, AddTrip.class));
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sylhet.this, PlaceOfSylhet.class));
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sylhet.this, FoodOfSylhet.class));
            }
        });
    }
}
