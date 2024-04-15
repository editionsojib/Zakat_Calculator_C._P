package com.editions.zakat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView showResult, showTotal;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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