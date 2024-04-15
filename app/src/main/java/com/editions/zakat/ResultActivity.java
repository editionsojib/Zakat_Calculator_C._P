package com.editions.zakat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView showResult, showTotal;
    ImageView ic_home, ic_about;
    LinearLayout result_layout;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.result_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //ToolBar Event Start Here ====================================================================

        result_layout= findViewById(R.id.result_layout);

        ic_home= findViewById(R.id.ic_home);
        ic_about= findViewById(R.id.ic_about);



        ic_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ResultActivity.this, HomeActivity.class));

            }
        });

        ic_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(ResultActivity.this, AboutMe.class));

            }
        });//==================================================================


        //====================================================

        showResult = findViewById(R.id.showResult);
        showTotal = findViewById(R.id.showTotal);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        //====================================================================================

        float data= sharedPreferences.getFloat("result", 0.0f);
        float total= sharedPreferences.getFloat("total", 0.0f);


        showTotal.setText("আপনার মোট সম্পদ: " + String.format("%.2f", total) + " টাকা");
        showResult.setText("আপনার যাকাত যোগ্য সম্পদ: " + String.format("%.2f", data) + " টাকা");







    }
}