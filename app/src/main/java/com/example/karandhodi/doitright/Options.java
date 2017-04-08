package com.example.karandhodi.doitright;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Options extends AppCompatActivity{

    private static final String TAG = Options.class.getSimpleName();
    public static final String PREFS = "examplePrefs";
    public static final String PREFS1 = "examplePrefs1";
    public static final String PREFS2 = "examplePrefs2";
    public static final String PREFS3 = "examplePrefs3";
    Switch sms_switch, camera_switch, silent_switch, reminder_switch;
    Button go_back;
    Globals gApp;
    String message,contact,reminderMessage;
    int sms_flag, reminder_flag;
    boolean isSMSChecked, isCameraChecked, isSilentChecked, isReminderChecked;


    public void onCreate(Bundle savedInstanceState){

     super.onCreate(savedInstanceState);
     setContentView(R.layout.options_layout);

     Log.d(TAG, "Entering options menu");

     sms_switch = (Switch)findViewById(R.id.toggle_sms);
     camera_switch = (Switch)findViewById(R.id.toggle_camera);
     silent_switch = (Switch)findViewById(R.id.toggle_silent);
     reminder_switch = (Switch)findViewById(R.id.toggle_reminder);
     go_back = (Button)findViewById(R.id.b_go_back);
     gApp = ((Globals)getApplicationContext());
     sms_flag = gApp.getGlobalSMSFlagValue();
     reminder_flag = gApp.getGlobalReminderFlagValue();

     getSupportActionBar().setTitle("Options");

     final SharedPreferences examplePrefs = getSharedPreferences(PREFS,0);
     final SharedPreferences.Editor editor = examplePrefs.edit();
     sms_switch.setChecked(examplePrefs.getBoolean("your_key", false));

        final SharedPreferences examplePrefs1 = getSharedPreferences(PREFS1,0);
        final SharedPreferences.Editor editor1 = examplePrefs1.edit();
        camera_switch.setChecked(examplePrefs1.getBoolean("your_key1", false));

        final SharedPreferences examplePrefs2 = getSharedPreferences(PREFS2,0);
        final SharedPreferences.Editor editor2 = examplePrefs2.edit();
        silent_switch.setChecked(examplePrefs2.getBoolean("your_key2", false));

        final SharedPreferences examplePrefs3 = getSharedPreferences(PREFS3,0);
        final SharedPreferences.Editor editor3 = examplePrefs3.edit();
        reminder_switch.setChecked(examplePrefs3.getBoolean("your_key3", false));

        sms_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


             editor.putBoolean("your_key", isChecked);
             editor.commit();

             System.out.println(isSMSChecked + " is sms checked");


             if(sms_flag == 0) {


                 AlertDialog.Builder builder = new AlertDialog.Builder(Options.this);
                 builder.setTitle("Enter Contact Details");
                 final EditText messageET = new EditText(Options.this);
                 final EditText contactET = new EditText(Options.this);
                 messageET.setInputType(InputType.TYPE_CLASS_TEXT);
                 contactET.setInputType(InputType.TYPE_CLASS_PHONE);
                 builder.setView(contactET);
                 builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         contact = contactET.getText().toString();
                         gApp.setSMSContactValue(contact);
                     }
                 });
                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
                 });

                 builder.show();
                 AlertDialog.Builder builder1 = new AlertDialog.Builder(Options.this);
                 builder1.setTitle("Enter Message to be sent");
                 builder1.setView(messageET);
                 builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         message = messageET.getText().toString();
                         gApp.setSMSMessageValue(message);

                     }
                 });
                 builder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
                 });

                 builder1.show();
             }
             //Toast.makeText(getApplicationContext(),"Hello", Toast.LENGTH_SHORT).show();
             if(sms_flag == 0)
                 sms_flag = 1;
             else
                 sms_flag = 0;
             gApp.setGlobalSMSFlagValue(sms_flag);

         }
     });

     camera_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor1.putBoolean("your_key1", isChecked);
                editor1.commit();

                System.out.println(isCameraChecked + " is camera checked");
            }
        });
     silent_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor2.putBoolean("your_key2", isChecked);
                editor2.commit();

                System.out.println(isSilentChecked + " is silent checked");
            }
        });



     go_back.setOnClickListener(new View.OnClickListener(){

         @Override
         public void onClick(View v) {
             gApp.setGlobalCamVarValue(camera_switch);
             gApp.setGlobalSmsVarValue(sms_switch);
             gApp.setGlobalSilentValue(silent_switch);
             gApp.setGlobalReminderValue(reminder_switch);
             finish();
         }
     });
     reminder_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override


            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor3.putBoolean("your_key3", isChecked);
                editor3.commit();

                System.out.println(isReminderChecked + " is reminder checked");

             if(reminder_flag == 0) {

                 AlertDialog.Builder builder = new AlertDialog.Builder(Options.this);
                 builder.setTitle("Enter the reminder message");
                 final EditText messageET = new EditText(Options.this);
                 messageET.setInputType(InputType.TYPE_CLASS_TEXT);
                 builder.setView(messageET);
                 builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         reminderMessage = messageET.getText().toString();
                         gApp.setReminderMessageValue(reminderMessage);
                     }
                 });
                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
                 });

                 builder.show();

             }
             if(reminder_flag == 0)
                 reminder_flag=1;
             else
                 reminder_flag=0;
             gApp.setGlobalReminderFlagValue(reminder_flag);
         }
     });
    }
}
