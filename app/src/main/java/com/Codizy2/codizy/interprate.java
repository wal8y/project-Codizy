package com.Codizy2.codizy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class interprate extends AppCompatActivity {
    TextView output;
    TextView linenumber;
    EditText code;
    Intent intent;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interprate);
        output=findViewById(R.id.output);
        linenumber=findViewById(R.id.lineNumber);
        code=findViewById(R.id.code);
        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }

        code.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    updateLineNumbers();
                }
                return false;
            }
        });
    }

    public void run(View v){
        Python py = Python.getInstance();
        PyObject pyobj = py.getModule( "script");
        PyObject obj = pyobj.callAttr( "main", code.getText().toString());
        output.setText(obj.toString());
    }

    private void updateLineNumbers() {
        int lineCount = code.getLineCount()+1;
        StringBuilder lineNumbers = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            lineNumbers.append(i).append("\n");
        }
        linenumber.setText(lineNumbers.toString());
    }

    public void sendHome(View v){
        intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
    }
    public void sendRes(View v){
        intent = new Intent(this, Res.class);
        startActivity(intent);
        finish();
    }
    public void sendInfo(View v){
        intent= new Intent(this, info.class);
        startActivity(intent);
        finish();
    }
    public void sendInte(View v){
        Toast toast = Toast.makeText(this, "you are in Compiler already !",Toast.LENGTH_LONG);
        toast.show();
    }
}
