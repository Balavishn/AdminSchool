package com.example.adminschooll;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class AdminEvent extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    EditText Title,Date,Desc;
    TextView Time;
    Button button;
    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;
    private String format = "";
    final Calendar myCalendar = Calendar.getInstance ();
    private int  mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event);
        Title=findViewById(R.id.title);
        Date=findViewById(R.id.date);
        Desc=findViewById(R.id.desc);

        button=findViewById(R.id.button1);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        Time = (TextView) findViewById(R.id.textView1);
        calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);
        Date.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                final DatePickerDialog.OnDateSetListener datetime = new DatePickerDialog.OnDateSetListener () {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        myCalendar.set ( Calendar.YEAR, year );
                        myCalendar.set ( Calendar.MONTH, monthOfYear );
                        myCalendar.set ( Calendar.DAY_OF_MONTH, dayOfMonth );
                        updateLabel ();
                    }

                };

                Date.setOnClickListener ( new View.OnClickListener () {

                    @Override
                    public void onClick(View v) {

                        new DatePickerDialog ( AdminEvent.this, datetime, myCalendar.get ( Calendar.YEAR ), myCalendar.get ( Calendar.MONTH ), myCalendar.get ( Calendar.DAY_OF_MONTH ) ).show ();

                    }
                } );

            }

            private void updateLabel() {

                String myFormat = "dd-MM-yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat ( myFormat, Locale.US );

                Date.setText ( sdf.format ( myCalendar.getTime () ) );
            }

        } );




        reference=FirebaseDatabase.getInstance().getReference("Events");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title,date,desc,time;
                title=Title.getText().toString();
                date=Date.getText().toString();
                desc=Desc.getText().toString();
                time=Time.getText().toString();
                HashMap<String, String> map = new HashMap<>();
                if(!title.isEmpty()&&!date.isEmpty()&&!desc.isEmpty())

                {

                    map.put("Title", title);
                    map.put("Date", date);
                    map.put("Description", desc);
                    map.put("Time", time);
                    reference.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                              //  sendNotifiy(title,date);
                                finish();
                            }
                            else
                                Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
                        }

                    });
                }
                else
                    Toast.makeText(getApplicationContext(), "Enter all Fields", Toast.LENGTH_SHORT).show();



            }
        });





    }
  /*  private void sendNotifiy(String title,String message) {
        sendNotification("/topics/event",title,message);
    }

    private void sendNotification(String deviceId,String title,String message)
    {  FirebaseApi apiService =
            FirebaseClient.getClient().create(FirebaseApi.class);
        NotifyData notifydata = new NotifyData(title,message);
        Call<FirebaseMessage> call = apiService.sendMessage(new
                FirebaseMessage(deviceId, notifydata));
        call.enqueue(new Callback<FirebaseMessage>() {

            @Override
            public void onResponse(Call<FirebaseMessage> call,
                                   Response<FirebaseMessage> response) {
                Log.e("Message Response","Send");
            }
            @Override
            public void onFailure(Call<FirebaseMessage> call, Throwable t) {
                Log.e("Message Response","Fail");
            }
        });
    }*/
    public void setTime(View view) {
        int hour = timePicker1.getCurrentHour();
        int min = timePicker1.getCurrentMinute();
        showTime(hour, min);
    }

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        Time.setText(new StringBuilder().append(hour).append(" : ").append(min)
                .append(" ").append(format));
    }
}
