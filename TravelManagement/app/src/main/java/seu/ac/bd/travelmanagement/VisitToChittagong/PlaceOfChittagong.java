package seu.ac.bd.travelmanagement.VisitToChittagong;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import seu.ac.bd.travelmanagement.R;

public class PlaceOfChittagong extends AppCompatActivity {
    private TextView t1, t2, t3, t4, t5, t6, t7, t8;
    private ImageView i1, i2, i3, i4, i5, i6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_of_chittagong);

        t1 = findViewById(R.id.tPatengaTitle);
        t2 = findViewById(R.id.tPatengaDescription);
        t3 = findViewById(R.id.tPatengaFootNote);
        t4 = findViewById(R.id.tFoysTitle);
        t5 = findViewById(R.id.tFoysDescription);
        t6 = findViewById(R.id.tTitleBayezidBostami);
        t7 = findViewById(R.id.tBayezidDescription);
        t8 = findViewById(R.id.tBayazidFootNote);

        i1 = findViewById(R.id.iPatenga);
        i2 = findViewById(R.id.iPatengaMap);
        i3 = findViewById(R.id.iFoysLake);
        i4 = findViewById(R.id.iMapFoysLake);
        i5 = findViewById(R.id.iBayezidBostami);
        i6 = findViewById(R.id.iMapBayezidBostami);
    }
}
