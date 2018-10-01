package seu.ac.bd.travelmanagement.VisitToSylhet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import seu.ac.bd.travelmanagement.R;

public class FoodOfSylhet extends AppCompatActivity {
    private ImageView i1, i2, i3, i4;
    private TextView t1, t2, t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_of_sylhet);

        i1 = findViewById(R.id.iStreetBurger);
        i2 = findViewById(R.id.iStreetBurgerMap);
        i3 = findViewById(R.id.icpFiveStar);
        i4 = findViewById(R.id.iMapCp);


        t1 = findViewById(R.id.tTitleStreet);
        t2 = findViewById(R.id.tStreetBurgerFootNote);
        t3 = findViewById(R.id.tTitleCp);
        t4 = findViewById(R.id.tFootNoteCp);

    }
}
