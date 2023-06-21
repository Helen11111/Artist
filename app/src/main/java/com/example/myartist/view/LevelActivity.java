package com.example.myartist.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myartist.MyDialogFragment;
import com.example.myartist.R;
import com.example.myartist.databinding.ActivityLevelBinding;
import com.example.myartist.model.Answer;
import com.example.myartist.model.Picture;
import com.example.myartist.model.Piece;
import com.example.myartist.model.Question;

public class LevelActivity extends AppCompatActivity implements View.OnClickListener {
    /*TextView tvNamePicture;
    ImageView imgPicture;
    ImageButton button1, button2, button3, button4;
    ImageView imgFrag1, imgFrag2, imgFrag3, imgFrag4, imgFrag5;*/

    private int currentIndex = 0;
    int points;
    CountDownTimer timer;
    long millisUntilFinished;

    ActivityLevelBinding binding;
    Bundle args;

    MediaPlayer mediaPlayer;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    Button button;
    AlertDialog dialog;
    TextView txtQuestion;

    private Answer[] answersBank = {
            new Answer(R.string.ans1q1p1, R.string.ans2q1p1, R.string.ans3q1p1, R.string.ans4q1p1,
                    R.string.incorrect_toast, R.string.incorrect_toast, R.string.correct_toast, R.string.incorrect_toast),
            new Answer(R.string.ans1q2p1, R.string.ans2q2p1, R.string.ans3q2p1, R.string.ans4q2p1,
                    R.string.incorrect_toast, R.string.incorrect_toast, R.string.incorrect_toast, R.string.correct_toast),
            new Answer(R.string.ans1q3p1, R.string.ans2q3p1, R.string.ans3q3p1, R.string.ans4q3p1,
                    R.string.incorrect_toast, R.string.correct_toast, R.string.incorrect_toast, R.string.incorrect_toast),
            new Answer(R.string.ans1q4p1, R.string.ans2q4p1, R.string.ans3q4p1, R.string.ans4q4p1,
                    R.string.incorrect_toast, R.string.incorrect_toast, R.string.incorrect_toast, R.string.correct_toast),


            new Answer(R.string.ans1q1p2, R.string.ans2q1p2, R.string.ans3q1p2, R.string.ans4q1p2,
                    R.string.incorrect_toast, R.string.incorrect_toast, R.string.correct_toast, R.string.incorrect_toast),
            new Answer(R.string.ans1q2p2, R.string.ans2q2p2, R.string.ans3q2p2, R.string.ans4q2p2,
                    R.string.correct_toast, R.string.incorrect_toast, R.string.incorrect_toast, R.string.incorrect_toast),
            new Answer(R.string.ans1q3p2, R.string.ans2q3p2, R.string.ans3q3p2, R.string.ans4q3p2,
                    R.string.incorrect_toast, R.string.incorrect_toast, R.string.correct_toast, R.string.incorrect_toast),
            new Answer(R.string.ans1q4p2, R.string.ans2q4p2, R.string.ans3q4p2, R.string.ans4q4p2,
                    R.string.incorrect_toast, R.string.incorrect_toast, R.string.incorrect_toast, R.string.correct_toast),
    };

    private Question[] questionsBank = {
            new Question(R.string.que1p1, answersBank[0]),
            new Question(R.string.que2p1, answersBank[1]),
            new Question(R.string.que3p1, answersBank[2]),
            new Question(R.string.que4p1, answersBank[3]),

            new Question(R.string.que1p2, answersBank[4]),
            new Question(R.string.que2p2, answersBank[5]),
            new Question(R.string.que3p2, answersBank[6]),
            new Question(R.string.que4p2, answersBank[7]),
    };


    private Picture[] picturesBank = {
            new Picture(R.drawable.pic1, false, questionsBank[0], questionsBank[1], questionsBank[2], questionsBank[3]
                    , new Piece(R.drawable.piece1_pict1, R.drawable.piece2_pict1, R.drawable.piece3_pict1
                    , R.drawable.piece4_pict1, R.drawable.piece5_pict1)),
            new Picture(R.drawable.pic1, false, questionsBank[4], questionsBank[5], questionsBank[6], questionsBank[7]
                    , new Piece(R.drawable.piece1_pict2, R.drawable.piece2_pict2, R.drawable.piece3_pict2
                    , R.drawable.piece4_pict2, R.drawable.piece5_pict2)),
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.fon_artist);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }


        binding.answ1.setOnClickListener(this);
        binding.answ2.setOnClickListener(this);
        binding.answ3.setOnClickListener(this);
        binding.answ4.setOnClickListener(this);

        //createDialog();

        binding.imgFragm1.setOnClickListener(this);
        binding.imgFragm2.setOnClickListener(this);
        binding.imgFragm3.setOnClickListener(this);
        binding.imgFragm4.setOnClickListener(this);

        binding.btnNext.setOnClickListener(this);

    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_fragment, null);

        radioGroup = view.findViewById(R.id.radioGroup);
        radioButton1 = view.findViewById(R.id.radioBtn1);
        radioButton2 = view.findViewById(R.id.radioBtn2);
        radioButton3 = view.findViewById(R.id.radioBtn3);
        radioButton4 = view.findViewById(R.id.radioBtn4);
        txtQuestion = view.findViewById(R.id.tv_question_dialog);

        button = view.findViewById(R.id.add_button);

        builder.setView(view);
        dialog = builder.create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }


    @Override
    public void onClick(View v) {
        String s = "";
        switch (v.getId()){
            case R.id.answ1:
                MyDialogFragment dialogFragment = new MyDialogFragment(picturesBank[0].getQuestion1(), 1);
                dialogFragment.show(getSupportFragmentManager(), "MyDialogFragment1");

                /*s = this.getResources().getString(R.string.que1p1);
                args.putString("question", s);
                dialogFragment.setArguments(args);*/
                break;
            case R.id.answ2:
                MyDialogFragment dialogFragment2 = new MyDialogFragment(picturesBank[0].getQuestion2(), 2);
                dialogFragment2.show(getSupportFragmentManager(), "MyDialogFragment2");
                /*s = this.getResources().getString(R.string.que2p1);
                args.putString("question", s);
                dialogFragment.setArguments(args);*/
                break;
            case R.id.answ3:
                MyDialogFragment dialogFragment3 = new MyDialogFragment(picturesBank[0].getQuestion3(), 3);
                dialogFragment3.show(getSupportFragmentManager(), "MyDialogFragment3");
                /*s = this.getString(picturesBank[0].getQuestion3().getQuestionId());
                args.putString("question", s);
                dialogFragment.setArguments(args);*/
                break;
            case R.id.answ4:
                MyDialogFragment dialogFragment4 = new MyDialogFragment(picturesBank[0].getQuestion4(), 4);
                dialogFragment4.show(getSupportFragmentManager(), "MyDialogFragment4");
                /*s = this.getString(picturesBank[0].getQuestion4().getQuestionId());
                args.putString("question", s);
                dialogFragment.setArguments(args);*/
                break;

            case R.id.imgFragm1:

                break;
            case R.id.imgFragm2:

                break;
            case R.id.imgFragm3:

                break;
            case R.id.imgFragm4:

                break;
            case R.id.imgFragm5:

                break;

            case R.id.btnNext:
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
                finish();
                break;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }


}