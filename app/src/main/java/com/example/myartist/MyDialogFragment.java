package com.example.myartist;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myartist.model.Question;

public class MyDialogFragment extends androidx.fragment.app.DialogFragment {
    Question question;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    Button button;
    AlertDialog dialog;
    TextView txtQuestion;

    int pos;

    public MyDialogFragment(Question question, int pos) {
        this.question = question;
        this.pos = pos;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getLayoutInflater().inflate(R.layout.dialog_fragment, null);

         //String s = getArguments().getString("question");

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
                txtQuestion.setText("");
                dialog.dismiss();
            }
        });
        return dialog;
    }


    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        switch (pos) {
            case 1:
                txtQuestion.setText(R.string.que1p1);
            case 2:
                txtQuestion.setText(R.string.que2p1);
            case 3:
                txtQuestion.setText(R.string.que3p1);
            case 4:
                txtQuestion.setText(R.string.que4p1);
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onDestroy() {
        dialog.dismiss();
        super.onDestroy();

    }
}
