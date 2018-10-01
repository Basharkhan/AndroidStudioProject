package seu.ac.bd.travelmanagement.VisitToChittagong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import seu.ac.bd.travelmanagement.AddTrip;
import seu.ac.bd.travelmanagement.R;

public class Chittagong extends AppCompatActivity {
    private ImageView imageView, imageWhatToDo, imageFood;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagong);

        t1 = findViewById(R.id.tCreateTrip);

        imageView = findViewById(R.id.iChittagong);
        imageWhatToDo = findViewById(R.id.iWhatToDo);
        imageFood = findViewById(R.id.iFood);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chittagong.this, AddTrip.class));
            }
        });


        imageWhatToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chittagong.this, PlaceOfChittagong.class));
            }
        });

        imageFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chittagong.this, FoodOfChittagong.class));
            }
        });

    }
}
