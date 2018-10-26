package com.codebakery.joan.trywidget1026;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText,ageEditText;
    private RadioGroup genderRadioGroup,occupationRadioGruop;
    private Button resultButton,submitButton;
    private TextView resultTextView;

    public static final int REQUEST_CODE = 2000;

    private String text,name,age,gender,occupation;

    private Person person = new Person();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.name_editText);
        ageEditText = (EditText) findViewById(R.id.age_editText);
        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_radioGroup);
        occupationRadioGruop = (RadioGroup) findViewById(R.id.occupation_radioGroup);
        resultButton = (Button) findViewById(R.id.show_result);
        submitButton = (Button) findViewById(R.id.show_submit);
        resultTextView = (TextView) findViewById(R.id.result_textView);

        //버튼 이벤트리스너 달기
        resultButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_result:
                //결과보기 버튼 클릭.하면

                person.setName(nameEditText.getText().toString());
                person.setAge(ageEditText.getText().toString());


                RadioButton selRbtn= (RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId());
                person.setGender(selRbtn.getText().toString());
                selRbtn = (RadioButton)findViewById(occupationRadioGruop.getCheckedRadioButtonId());
                person.setOccupation(selRbtn.getText().toString());
                resultTextView.setText(person.toString());
                break;
            case R.id.show_submit:
                //
                resultTextView.setText("아직이야~");
                break;
            default: break;
        }
    }

}
