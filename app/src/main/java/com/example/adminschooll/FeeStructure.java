package com.example.adminschooll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FeeStructure extends AppCompatActivity {

    TextView classs,tutionfee,busfee,hostelfee,canteen,labfee,dance,sapw;
    EditText Etutionfee,Ebusfee,Ehostelfee,Ecanteen,Elabfee,Edance,Esapw;
    Button submit;
    DatabaseReference reference;
    Spinner class_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_structure);
        classs=findViewById(R.id.classs);
        tutionfee=findViewById(R.id.tutionfee);
        busfee=findViewById(R.id.busfee);
        hostelfee=findViewById(R.id.hostelfee);
        canteen=findViewById(R.id.canteen);
        labfee=findViewById(R.id.labfee);
        dance=findViewById(R.id.dance);
        sapw=findViewById(R.id.sapw);

        class_spinner=findViewById(R.id.editclass);
        Etutionfee=findViewById(R.id.edittutionfee);
        Ebusfee=findViewById(R.id.editbusfee);
        Ehostelfee=findViewById(R.id.edithostelfee);
        Ecanteen=findViewById(R.id.editcanteen);
        Elabfee=findViewById(R.id.editlabfee);
        Edance=findViewById(R.id.editdance);
        Esapw=findViewById(R.id.editsapw);

        submit=findViewById(R.id.Submit);
        reference= FirebaseDatabase.getInstance().getReference("FeeStructure");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                String classs1,tutionfee1,busfee1,hostelfee1,canteen1,labfee1,dance1,sapw1;
                classs1=class_spinner.getSelectedItem().toString();
                tutionfee1=Etutionfee.getText().toString();
                busfee1=Ebusfee.getText().toString();
                hostelfee1=Ehostelfee.getText().toString();
                canteen1=Ecanteen.getText().toString();
                labfee1=Elabfee.getText().toString();
                dance1=Edance.getText().toString();
                sapw1=Esapw.getText().toString();



                if(!TextUtils.isEmpty(classs1)&&!TextUtils.isEmpty(tutionfee1)&&!TextUtils.isEmpty(busfee1)&&!TextUtils.isEmpty(hostelfee1)&&
                        !TextUtils.isEmpty(canteen1)&&!TextUtils.isEmpty(labfee1)&&!TextUtils.isEmpty(dance1)&&!TextUtils.isEmpty(sapw1))
                {

                    HashMap<CharSequence, String> map=new HashMap<>();
                    map.put(classs.getText(),classs1);
                    map.put(tutionfee.getText(),tutionfee1);
                    map.put(busfee.getText(),busfee1);
                    map.put(hostelfee.getText(),hostelfee1);
                    map.put(canteen.getText(),canteen1);
                    map.put(labfee.getText(),labfee1);
                    map.put(dance.getText(),dance1);
                    map.put(sapw.getText(),sapw1);
                    reference.child(classs1).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                                Toast.makeText(FeeStructure.this, "Added", Toast.LENGTH_SHORT).show();
                            else Toast.makeText(FeeStructure.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    });



                }


                else {
                    Toast.makeText(FeeStructure.this, "Enter all fields", Toast.LENGTH_SHORT).show();

                }





            }
        });

    }
}