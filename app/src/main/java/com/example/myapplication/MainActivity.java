package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    TextView questionLabel, hintslabel, questionCountLabel, scoreLabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<QuestionModel> questionModelArrayList;


    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionLabel = findViewById(R.id.question);

        hintslabel = findViewById(R.id.hints);

        answerEdt = findViewById(R.id.answer);
        submitButton = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progress);

        questionModelArrayList = new ArrayList<>();

        setUpQuestion();

        setData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer();

            }
        });

    }

    public void checkAnswer(){
        String answerString = answerEdt.getText().toString().trim();

        if(answerString.equalsIgnoreCase(questionModelArrayList.get(currentPosition).getAnswer())) {
            Toast.makeText(getApplicationContext(),"BNERLO",Toast.LENGTH_SHORT).show();
            numberOfCorrectAnswer ++;
            currentPosition ++;
            setData();
            answerEdt.setText("");



        }else {
            Toast.makeText(getApplicationContext(),"PIKIR LAGI",Toast.LENGTH_SHORT).show();

            setData();
            answerEdt.setText("");
        }

        int x = ((currentPosition+1) * 100)/questionModelArrayList.size();
        progressBar.setProgress(x);
    }




    public void setUpQuestion(){

        questionModelArrayList.add(new QuestionModel( "ANTARA CAIR & KERAS", "kental","K#NT#L"));
        questionModelArrayList.add(new QuestionModel( "TEMPAT KERJA", "kantor","k#NT#"));
        questionModelArrayList.add(new QuestionModel( "BERHUBUNGAN", "kontak","kont##"));
        questionModelArrayList.add(new QuestionModel( "KURANG TIDUR", "kantuk","k#nt##"));
        questionModelArrayList.add(new QuestionModel( "BINTIK DIKULIT", "bentol","##ntol"));
        questionModelArrayList.add(new QuestionModel( "BAUNYA TIDAK ENAK", "KENTUT","K#NT##"));
        questionModelArrayList.add(new QuestionModel( "IRING IRINGAN", "KONVOI","KON###"));
        questionModelArrayList.add(new QuestionModel( "UNTUK MEMASAK", "KOMPOR","KO##O#"));
        questionModelArrayList.add(new QuestionModel( "KONTAN/CASH", "KONTAN","KONT##"));
    }

    public void setData(){

        if(questionModelArrayList.size()>currentPosition) {

            questionLabel.setText(questionModelArrayList.get(currentPosition).getQuestionString());
            hintslabel.setText(questionModelArrayList.get(currentPosition).getHints());



        }else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            TextView myMsg = new TextView(this);
            alert.setCancelable(false);
            myMsg.setText(Html.fromHtml("Hati yang bersih dan pikiran yang jernih adalah anugerah yang sungguh istimewa. Berbahagialah mereka yang mendapatkannya. "+"<b>"+"(KH. Ahmad Mustafa Bisri)"+"</b>"));
            myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
            alert.setView(myMsg);
            alert.setPositiveButton("close application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    currentPosition = 0;
                    numberOfCorrectAnswer = 0;
                    progressBar.setProgress(0);
                    setData();
                }
            });

            AlertDialog alertDialog=alert.create();
            alertDialog.show();

        }
    }

}