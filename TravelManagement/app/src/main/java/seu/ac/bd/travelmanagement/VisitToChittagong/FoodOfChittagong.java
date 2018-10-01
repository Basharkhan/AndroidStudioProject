package seu.ac.bd.travelmanagement.VisitToChittagong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import seu.ac.bd.travelmanagement.R;

public class FoodOfChittagong extends AppCompatActivity {
    private ImageView i1, i2, i3, i4, i5, i6;
    private TextView t1, t2, t3, t4, t5, t6, t7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_of_chittagong);

        i1 = findViewById(R.id.iFancyKitchen);
        i2 = findViewById(R.id.iMapFancy);
        i3 = findViewById(R.id.iCafeMilano);
        i4 = findViewById(R.id.iMapMilano);

        t1 = findViewById(R.id.tFancyTitle);
        t2 = findViewById(R.id.tFancyDescription);
        t3 = findViewById(R.id.tFancyFootNote);
        t3 = findViewById(R.id.tMilanoDescription);


    }
}
