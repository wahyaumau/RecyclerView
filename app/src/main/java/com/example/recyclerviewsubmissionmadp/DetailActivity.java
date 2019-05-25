package com.example.recyclerviewsubmissionmadp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {
    TextView tVDetailName, tVDetailDescription, tVDetailPrice, tVDetailType;
    ImageView iVDetailImage;
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_PRICE = "extra_price";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        String type = getIntent().getStringExtra(EXTRA_TYPE);
        Float price = getIntent().getFloatExtra(EXTRA_PRICE,0);

        tVDetailName = findViewById(R.id.tV_item_detail_name);
        tVDetailDescription = findViewById(R.id.tV_item_detail_description);
        tVDetailPrice = findViewById(R.id.tV_item_detail_price);
        tVDetailType = findViewById(R.id.tV_item_detail_type);
        iVDetailImage = findViewById(R.id.img_item_photo_detail);

        tVDetailName.setText(name);
        tVDetailDescription.setText(description);
        tVDetailPrice.setText("Rp. "+String.valueOf(price));
        tVDetailType.setText(type);

        iVDetailImage.setImageResource(getImageFromDrawableByName(photo));





    }

    public int getImageFromDrawableByName(String imageName){
        int drawableResId = getApplicationContext().getResources().getIdentifier(imageName, "drawable", getApplicationContext().getPackageName());
        return drawableResId;
    }

}
