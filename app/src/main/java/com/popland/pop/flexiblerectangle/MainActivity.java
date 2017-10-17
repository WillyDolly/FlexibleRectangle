package com.popland.pop.flexiblerectangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);//Display exclude system decor, include bottom task bar
        int width = dm.widthPixels;//1440
        int height = dm.heightPixels;//2392
        setContentView(new Rectangle(this,width,height));
        Toast.makeText(this,width+"--"+height,Toast.LENGTH_SHORT).show();
    }
}
