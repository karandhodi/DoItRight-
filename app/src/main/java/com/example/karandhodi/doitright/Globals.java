package com.example.karandhodi.doitright;


import android.app.Application;
import android.content.Intent;
import android.widget.Switch;

public class Globals extends Application {
    private Switch g_camera_switch, g_sms_switch, g_silent_switch, g_reminder_switch;
    private String g_sms_message, g_sms_contact, g_reminder_message, g_radius;
    private int g_sms_flag, g_reminder_flag;

    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, backgroundService.class));
    }

    public Switch getGlobalCamVarValue() {
        return g_camera_switch;
    }

    public void setGlobalCamVarValue(Switch str1) {
        g_camera_switch = str1;
    }

    public Switch getGlobalSmsVarValue() {
        return g_sms_switch;
    }

    public void setGlobalSmsVarValue(Switch str2) {
        g_sms_switch = str2;
    }

    public void setSMSContactValue(String s) {
        g_sms_contact = s;
    }

    public String getSMSContactValue() {
        return g_sms_contact;
    }

    public void setSMSMessageValue(String s) {
        g_sms_message = s;
    }

    public String getSMSMessageValue() {
        return g_sms_message;
    }

    public void setGlobalSilentValue(Switch str3) {
        g_silent_switch = str3;
    }

    public Switch getGlobalSilentValue() {
        return g_silent_switch;
    }

    public void setGlobalReminderValue(Switch str4) {
        g_reminder_switch = str4;
    }

    public Switch getGlobalReminderValue() {
        return g_reminder_switch;
    }

    public void setReminderMessageValue(String s) {
        g_reminder_message = s;
    }

    public String getReminderMessageValue() {
        return g_reminder_message;
    }

    public int getGlobalSMSFlagValue() {
        return g_sms_flag;
    }

    public void setGlobalSMSFlagValue(int s) {
        g_sms_flag = s;
    }

    public int getGlobalReminderFlagValue() {
        return g_reminder_flag;
    }

    public void setGlobalReminderFlagValue(int s) {
        g_reminder_flag = s;
    }
    public void setGlobalRadius(String s)
    {
        g_radius = s;
    }
    public String getGlobalRadius()
    {
        return g_radius;
    }
}
