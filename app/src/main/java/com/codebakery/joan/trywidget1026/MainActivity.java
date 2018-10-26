package com.codebakery.joan.trywidget1026;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText,ageEditText;
    private RadioGroup genderRGroup,occupationRGruop;
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
        genderRGroup = (RadioGroup) findViewById(R.id.gender_radioGroup);
        occupationRGruop = (RadioGroup) findViewById(R.id.occupation_radioGroup);
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
                //결과보기 버튼 클릭 하면
                if(setPerson()) {
                    resultTextView.setText(person.toString());
                }else {
                    Toast.makeText(v.getContext(),"공백이 있어요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.show_submit:

                break;
            default: break;
        }
    }

    private boolean setPerson(){
        //RadioGroup에서 선택값이 없으면 checkedId 값이 -1로 리턴되고,
        //selRbtn 은 null이 셋팅된다.
        RadioButton selRbtn1= (RadioButton) findViewById(genderRGroup.getCheckedRadioButtonId());
        RadioButton selRbtn2= (RadioButton) findViewById(occupationRGruop.getCheckedRadioButtonId());

        //"".equals(객체)비교해 준다.
        if("".equals(nameEditText.getText().toString()) | "".equals(ageEditText.getText().toString()) | selRbtn1 == null | selRbtn2 == null){
            return false;
        }
        person.setName(nameEditText.getText().toString());
        person.setAge(ageEditText.getText().toString());
        person.setGender(selRbtn1.getText().toString());
        person.setOccupation(selRbtn2.getText().toString());
        return true;
    }



}
