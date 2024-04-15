package com.editions.zakat;

import static android.icu.text.Normalizer.NO;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class CalculateActivity extends AppCompatActivity {

    EditText NetGold, NetRupa, NetMoney;
    Button AlertBtn, CalculateBtn;

    LottieAnimationView animationView;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        NetGold= findViewById(R.id.ed_NetGold);
        NetRupa= findViewById(R.id.ed_NetRupa);
        NetMoney= findViewById(R.id.ed_NetMONey);
        AlertBtn= findViewById(R.id.AlertBtn);
        CalculateBtn= findViewById(R.id.calculate);
        animationView= findViewById(R.id.animationView);
        //========================================================================================


        sharedPreferences = getSharedPreferences(""+getString(R.string.app_name), MODE_PRIVATE);
        editor= sharedPreferences.edit();
        //======================================================


        //=============================================================


        CalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // custom Toast Start her ===================================
                LayoutInflater layoutInflater= getLayoutInflater();
                View animation= layoutInflater.inflate(R.layout.animation, (ViewGroup) findViewById(R.id.animation_layout));


                animation.setBackground(getDrawable(R.drawable.animation_backround));

                Toast toast= new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
                toast.setView(animation);
                toast.show();


                // custom Toast End her ===================================

                // Handler Start Here==================================

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Calculate();

                    }
                },4000);

                // Handler Start Here==================================




            }
        });

        //calculate button end here========================================================

        //============================================================


        AlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //=============
                Scollalert();

            }
        });







    }// onClick end here===========================================================


    //AlertDialog Start here================================================
    private void Scollalert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("যাকাত হিসাবের নিয়ম");
        builder.setMessage("'যে পরিমাণ ধনসম্পদ থাকলে যাকাত ফরজ হয়', \n\n" +
                " ইসলামি পরিভাষায় তাকে বলা হয় নিসাব। যাকাত ফরজ হওয়ার জন্য অন্তত নিসাব পরিমাণ সম্পদ পূর্ণ এক বছর থাকতে হবে। সম্পদের নিসাব হলো সোনা সাড়ে সাত ভরি, রুপা সাড়ে বায়ান্ন ভরি অথবা এর কোনো একটির সমমূল্যের নগদ টাকা বা ব্যবসার পণ্য। "+"\n \n"+
                "অর্থসম্পদ যেদিন নিসাব পর্যায়ে পৌঁছাবে, সেদিন থেকেই জাকাতের বর্ষগণনা শুরু হবে। নিসাব পরিমাণ এবং এর বেশি সম্পদের মালিককে তার যাকাতযোগ্য সব সম্পদের হিসাব অনুযায়ী প্রতিবছর আড়াই শতাংশ (৪০ ভাগের ১ ভাগ) হারে দিতে হয়। সামর্থ্যবান মুসলমানের পক্ষে যাাকাত দেওয়া ফরজ।"+"\n \n"+
                " 'যে যে সম্পদ এর যাকাত দিতে '"+"\n\n"+
                "সোনা, রুপা, নগদ টাকা ও ব্যবসায়িক পণ্য—এই তিন খাতে জাকাতের বর্ষপূর্তি বা জাকাতের হিসাব সমাপনী দিনে যত সম্পদ থাকবে, তার পুরোটারই জাকাত দিতে হবে। বছরের মধ্যে যেকোনো সময় সম্পদপ্রাপ্তি ঘটলে, বছর শেষে যাকাত দিতে হবে। প্রতি বছর একই তারিখে যাকাতের হিসাব করতে হয়।\n\n"+
                "ফেরত পাওয়ার যোগ্য প্রদত্ত ঋণ, ব্যবসার পণ্য ও মূল্যবান শোপিস বা মূল্যবান পাথর হীরা-জহরত, মণি-মাণিক্য, মুক্তা ইত্যাদি সম্পদের আওতায় পড়বে। \n" +
                "ব্যবসায়িক নার্সারি, হর্টিকালচার, বীজ উৎপাদন খামার, কৃষি খামার, বনজ বৃক্ষ খামার, ফলদ বৃক্ষ খামার, ঔষধি গাছের খামার, চা-বাগান, রাবার বাগান, তুলাবাগান, রেশম বাগান, আগরগাছের বাগান, অর্কিড নার্সারি ও ফুল বাগান, মুরগির খামার, মাছের খামার ইত্যাদি এবং প্রয়োজনের অতিরিক্ত সামগ্রী ইত্যাদিকে বর্তমান বাজারের বিক্রয়মূল্যের হিসাবে ধরতে হবে।\n\n"+
                "বিক্রির জন্য না রাখা স্থাবর সম্পদ, জায়গাজমি, বাড়ি ও গাড়ি যাকাত হিসাবে পড়বে না। বিক্রির জন্য রাখা গাড়ি, বাড়ি, ফ্ল্যাট, প্লট ও জমি বর্তমান বাজারদরে যাকাতের হিসাবে আসবে। সে দাম হিসাব করে প্রতিবছর যাকাত দিতে হবে।");


// একটি ScrollView তৈরি করুন
        ScrollView scrollView = new ScrollView(this);

// একটি LinearLayout তৈরি করুন যাতে আপনি ম্যাসেজ যোগ করতে পারেন
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

// LinearLayout কে ScrollView এ যোগ করুন
        scrollView.addView(linearLayout);

// ScrollView কে AlertDialog এ যোগ করুন
        builder.setView(scrollView);

// ডায়ালগ প্রদর্শন করুন
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }//AlertDialog End here====================================================================


    //==========================================================================================
    private void Calculate(){

        String S_gold = NetGold.getText().toString();
        String S_rupa = NetRupa.getText().toString();
        String S_money = NetMoney.getText().toString();

        if (!S_gold.isEmpty() && !S_rupa.isEmpty() && !S_money.isEmpty()){

            float num1= Float.parseFloat(S_gold);
            float num2= Float.parseFloat(S_rupa);
            float num3= Float.parseFloat(S_money);


            float sum= num1+ num2+ num3;
            float result= sum / 40;


            editor.putFloat("result", Float.parseFloat(""+result));
            editor.putFloat("total", Float.parseFloat(""+sum));
            editor.apply();

            startActivity(new Intent(CalculateActivity.this, ResultActivity.class));


        }else {
            Toast.makeText(CalculateActivity.this, "Input the number", Toast.LENGTH_SHORT).show();
            NetGold.setText("0");
            NetRupa.setText("0");
            NetMoney.setText("0");
        }
    }//onClick Start Here ======================================================


    // onBackPress Mathord Start Here==========================================

    public void onBackPressed() {

        //super.onBackPressed(); Use Device Function//

        new AlertDialog.Builder(CalculateActivity.this)
                .setTitle("You Want To Exit?")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finishAffinity();

                    }
                })
                .setCancelable(false)
                .show();
    }// onBackPress End Here====================================================





}