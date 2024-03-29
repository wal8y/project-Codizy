package com.Codizy2.codizy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
public class question extends AppCompatActivity {
    TextView info,step,cong,output;
    EditText example;
    SharedPrefs sharedPrefs;
    Button done,next,prev,run;
    qus[] q=new qus[3];
    private int i=0;
    private int thisLvl;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        info = findViewById(R.id.info);
        example = findViewById(R.id.example);
        step = findViewById(R.id.level);
        done = findViewById(R.id.done);
        next =findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        cong=findViewById(R.id.cong);
        output = findViewById(R.id.exampleOutput);
        run=findViewById(R.id.run);
        sharedPrefs = new SharedPrefs(this);

        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }

        Bundle b = getIntent().getExtras();
        callLvl(b.getInt("lvl"));
        setQuestion(q[i]);
    }

    public void run(View v){
        Python py = Python.getInstance();
        PyObject pyobj = py.getModule( "script");
        PyObject obj = pyobj.callAttr( "main", example.getText().toString());
        output.setText(obj.toString());
    }

    public void callLvl(int lvl){
        switch (lvl) {
            case 1:
                lvl1();
                thisLvl =0;
                break;
            case 2:
                lvl2();
                thisLvl=1;
                break;
            case 3:
                lvl3();
                thisLvl=2;
                break;
            case 4:
                lvl4();
                thisLvl=3;
                break;
            case 5:
                lvl5();
                thisLvl=4;
                break;
            default:
                lvl1();
                thisLvl=0;
                break;
        }
    }
    public void lvl1(){
        i=0;
        q[0] = new qus("Welcome to the exciting world of coding! Coding, also known as programming, is the process of designing and building executable computer programs to accomplish a specific task. It's a powerful skill that enables you to create software, websites, apps, and much more. Whether you're interested in building your own projects, solving problems, or pursuing a career in technology, learning to code is a valuable and rewarding endeavor.","0",1);
        q[1] = new qus("In coding we always start counting from 0 so any coding element you see is one number away from its real number \nso lets say e[3] is an element the real number for this element is 4 \nNow always remember i is actually i+1 and the other way around","array = [1,2,3] #array in size  \narray[0] = 5\nprint(array)",2);
        q[2] = new qus("Now in the world of coding we have something called comments witch is when you want to leave a littel notes in your code \n Lets say reminders and those notes are diffrent in each programing languages but for python its # mark \nEvery time you want to leave a message in python just add a Hash and type your comment", "#hello there!",3);
    }
    public void lvl2() {
        i=0;
        q[0] = new qus("Welcome to Level 2: Types and Values!\nIn this level, you'll dive into the fundamental concepts of data types and values in coding.", "0", 1);
        q[1] = new qus("In coding, data types define the type of values that variables can hold. Common data types include integers, floats, strings, and booleans.\nFor example, let's add 5 and 3 using variables", "x = 5\ny = 3\nz = x+y\nprint(z)", 2);
        q[2] = new qus("Understanding the difference between primitive and reference types is crucial. Primitive types store the actual value, while reference types store a reference to the value.\n", "num = 10\nname = \"Codizy\"\nprint(name)", 3);
    }
    public void lvl3() {
        i=0;
        q[0] = new qus("Welcome to Level  3: Print.\nIn this level, you'll explore the fundamental concept of printing in programming. Printing allows you to display information to the user or debug your code by outputting values. Let's dive in!", "0", 1);
        q[1] = new qus("In programming, the 'print' statement is commonly used to display information. It's a way to communicate with the user or provide feedback during the execution of a program.\nIn many programming languages, including Python, you can use 'print' followed by the content you want to display. For example:", "print('Hello, World!')", 2);
        q[2] = new qus("Now, let's enhance your printing skills! In addition to plain text, you can print variables and expressions.\nFor example, if you have a variable 'x' with the value 10, you can print its value like this:\n\n", "x = 10\n\nprint('The value of x is:', x)", 3);
    }

    public void lvl4() {
        i=0;
        q[0] = new qus("Welcome to Level 4 - Loops!\n\nIn programming, loops are powerful structures that allow you to repeat a block of code multiple times. They help in automating repetitive tasks and are essential for efficient coding.", "0", 1);
        q[1] = new qus("There are different types of loops, but two common ones are 'for' and 'while' loops.\n\n1. For Loop:\n   - Used for iterating over a sequence (like an array or range)\n   - Has a predefined number of iterations\n\n2. While Loop:\n   - Repeats a block of code as long as a specified condition is true\n   - Useful when the number of iterations is unknown beforehand", "for i in range (5): \n   print('hi')\n\nwhile(False):\n   print('will not be printed')", 2);
        q[2] = new qus("Now, let's apply loops to solve real-world problems!\n\nConsider a scenario where you need to print numbers from 1 to 10.\nUsing a loop, you can achieve this without writing the same code for each number. It simplifies the task and makes your code more efficient.", "for i in range (10):#0-9\n        print(i)", 3);
    }

    public void lvl5() {
        i=0;
        q[0] = new qus("Welcome to the advanced topic of functions in coding! Functions are blocks of reusable code that perform a specific task. They allow you to organize your code, make it more modular, and avoid repetitive tasks. Understanding functions is a key skill in programming.", "0", 1);
        q[1] = new qus("In functions, we often encounter the concept of parameters. Parameters are variables that you define in a function's declaration. They act as placeholders for values that will be passed into the function when it is called. Parameters help make functions more flexible and adaptable.", "def greet(name):\n    print('hey '+name)\n\ngreet('"+sharedPrefs.getUserName()+"') #'"+sharedPrefs.getUserName()+"' is a parameter", 2);
        q[2] = new qus("Another important aspect of functions is the return statement. A return statement is used to send a value back from the function to the code that called it. It allows functions to produce results that can be used elsewhere in your program.", "def add_numbers(a, b):  \n      sum = a + b  \n      return sum\nprint(add_numbers(2,3))", 3);
    }

    private void setQuestion(qus q){
        info.setText(q.info);
        if(q.example.equals("0")){
            example.setVisibility(View.INVISIBLE);
            output.setVisibility(View.INVISIBLE);
            run.setVisibility(View.INVISIBLE);
        }else{
            example.setText(q.example);
        }
        step.setText("level "+q.lvl);
    }

    public void setVisibleQ() {
        info.setVisibility(View.VISIBLE);
        example.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        prev.setVisibility(View.VISIBLE);
        output.setVisibility(View.VISIBLE);
        run.setVisibility(View.VISIBLE);
        cong.setVisibility(View.INVISIBLE);
        done.setVisibility(View.INVISIBLE);
    }

    public void setVisibleF() {
        info.setVisibility(View.INVISIBLE);
        example.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        run.setVisibility(View.INVISIBLE);
        output.setVisibility(View.INVISIBLE);
        prev.setVisibility(View.INVISIBLE);
        cong.setVisibility(View.VISIBLE);
        done.setVisibility(View.VISIBLE);
    }

    public void done(View view) {
        int newlvl = sharedPrefs.getLevel() + 1;
        if (thisLvl == newlvl - 1){
            sharedPrefs.setLevel(newlvl);
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(question.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void next(View view) {
        if (i < 2) {
            i++;
            setQuestion(q[i]);
            setVisibleQ();
        } else {
            setVisibleF();
        }
    }

    public void previous(View view) {
        if (i > 0) {
            i--;
            setQuestion(q[i]);
        }else {
            finish();
        }
    }
}