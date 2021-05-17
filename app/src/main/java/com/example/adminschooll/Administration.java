package com.example.adminschooll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class Administration extends AppCompatActivity {

    EditText etFName,etLName,etFaName,etMName,etMobile,etAadhar,etDob,etcity,etState,etTongue,etRel,etCas,etCat,etSchname,etsta,etAdrs,etPin,etBld,etMark,etPrblm;
    AwesomeValidation awesomeValidation;
    Button btApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);
        etFName = findViewById(R.id.et_firstname);
        etLName = findViewById(R.id.et_lastname);
        etFaName = findViewById(R.id.et_fathername);
        etMName = findViewById(R.id.et_mothername);
        etMobile = findViewById(R.id.et_mobile);
        etAadhar = findViewById(R.id.et_aadharno);
        etDob = findViewById(R.id.et_dob);
        etcity = findViewById(R.id.et_city);
        etState = findViewById(R.id.et_state);
        etTongue = findViewById(R.id.et_mothertongue);
        etRel = findViewById(R.id.et_religion);
        etCas = findViewById(R.id.et_caste);
        etCat = findViewById(R.id.et_category);
        etSchname = findViewById(R.id.et_lastSchool);
        etsta = findViewById(R.id.et_standard);
        etAdrs = findViewById(R.id.et_address);
        etPin = findViewById(R.id.et_pincode);
        etBld = findViewById(R.id.et_bloodgrp);
        etMark = findViewById(R.id.et_identimark);
        etPrblm = findViewById(R.id.et_phyprblm);

        btApply = findViewById(R.id.bt_apply);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.et_firstname, RegexTemplate.NOT_EMPTY, R.string.invalid_fname);
        awesomeValidation.addValidation(this, R.id.et_lastname, RegexTemplate.NOT_EMPTY, R.string.invalid_lname);
        awesomeValidation.addValidation(this, R.id.et_fathername, RegexTemplate.NOT_EMPTY, R.string.invalid_faname);
        awesomeValidation.addValidation(this, R.id.et_mothername, RegexTemplate.NOT_EMPTY, R.string.invalid_mname);
        awesomeValidation.addValidation(this, R.id.et_mobile, "[5-9]{1}[0-9]{9}$", R.string.invalid_mobile);
        awesomeValidation.addValidation(this, R.id.et_aadharno, "[0-9]{12}$", R.string.invalid_aadharno);
        awesomeValidation.addValidation(this, R.id.et_dob, RegexTemplate.NOT_EMPTY, R.string.invalid_date);
        awesomeValidation.addValidation(this, R.id.et_caste, RegexTemplate.NOT_EMPTY, R.string.invalid_caste);
        awesomeValidation.addValidation(this, R.id.et_category, RegexTemplate.NOT_EMPTY, R.string.invalid_category);
        awesomeValidation.addValidation(this, R.id.et_religion, RegexTemplate.NOT_EMPTY, R.string.invalid_religion);
        awesomeValidation.addValidation(this, R.id.et_bloodgrp, RegexTemplate.NOT_EMPTY, R.string.invalid_blood);
        awesomeValidation.addValidation(this, R.id.et_address, RegexTemplate.NOT_EMPTY, R.string.invalid_address);
        awesomeValidation.addValidation(this, R.id.et_pincode, "[0-9]{6}", R.string.invalid_pin);
        awesomeValidation.addValidation(this, R.id.et_email, Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        awesomeValidation.addValidation(this, R.id.et_standard, RegexTemplate.NOT_EMPTY, R.string.invalid_standard);
        awesomeValidation.addValidation(this, R.id.et_lastSchool, RegexTemplate.NOT_EMPTY, R.string.invalid_shl);
        awesomeValidation.addValidation(this, R.id.et_city, RegexTemplate.NOT_EMPTY, R.string.invalid_city);
        awesomeValidation.addValidation(this, R.id.et_state, RegexTemplate.NOT_EMPTY, R.string.invalid_state);
        awesomeValidation.addValidation(this, R.id.et_mothertongue, RegexTemplate.NOT_EMPTY, R.string.invalid_tongue);

        btApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(view == btApply){
                        submitForm();
                    }
        }
        });

    }
    public void submitForm(){
        if(awesomeValidation.validate()){
            Toast.makeText(this, "Admission Successfully Applied", Toast.LENGTH_LONG).show();
        }
    }

    }
