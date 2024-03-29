package com.Codizy2.codizy;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    SharedPreferences sharedRefs;
    public SharedPrefs(Context context){
        sharedRefs=context.getSharedPreferences("myRefs",Context.MODE_PRIVATE);
    }
    public void SaveFirstlog(String Name, int age,int level){
        SharedPreferences.Editor editor = sharedRefs.edit();
        editor.putString("userName",Name);
        editor.putInt("userAge",age);
        editor.putInt("level",level);
        editor.commit();
    }
    public String getUserName(){
        return sharedRefs.getString("userName","");
    }
    public int getLevel(){
        int level = sharedRefs.getInt("level",0);
        return level;
    }
    public void setLevel(int newLevel){
        sharedRefs.edit().putInt("level",newLevel).apply();
    }
}