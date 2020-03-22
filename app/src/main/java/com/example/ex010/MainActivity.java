package com.example.ex010;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static Random rnd= new Random();
    TextView tv11,tv12,tv21,tv22,tv31,tv32;
    Button btn,btn1,btn2,btn3;
    ImageView iv1,iv2,iv3;
    EditText ed1,ed2,ed3;
    int n1,n2,w,sum,sum1,success;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv11=(TextView) findViewById(R.id.tv11);
        tv12=(TextView) findViewById(R.id.tv12);
        tv21=(TextView) findViewById(R.id.tv21);
        tv22=(TextView) findViewById(R.id.tv22);
        tv31=(TextView) findViewById(R.id.tv31);
        tv32=(TextView) findViewById(R.id.tv32);

        btn=(Button) findViewById(R.id.btn);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);

        iv1=(ImageView) findViewById(R.id.iv1);
        iv2=(ImageView) findViewById(R.id.iv2);
        iv3=(ImageView) findViewById(R.id.iv3);

        ed1=(EditText) findViewById(R.id.et1);
        ed2=(EditText) findViewById(R.id.et2);
        ed3=(EditText) findViewById(R.id.et3);

    }

    public void start(View view) {
        n1=rnd.nextInt(11)+88;
        n2=rnd.nextInt(11)+88;
        tv11.setText("Number:  "+n1);
        tv12.setText("Number:  "+n2);
        tv21.setText("0");
        tv22.setText("0");
        tv31.setText("0");
        tv32.setText("0");
        w=sum=sum1=success=0;
    }
    public void level1(View view) {
        sum=n1+n2;
        s1= ed1.getText().toString();
        if (s1.equals(""))
            Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show();
        sum1=Integer.parseInt(s1);
        if(sum==sum1) {
            iv1.setImageResource(R.drawable.good);
            tv21.setText(sum1);
        }
        else {
            iv1.setImageResource(R.drawable.notgood);
            w++;
            tv21.setText(sum);
        }
    }

    public void level2(View view) {
        n2=rnd.nextInt();
        tv22.setText(n2);
        sum=sum+n2;
        s1= ed2.getText().toString();
        if (s1.equals(""))
            Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show();
        sum1=Integer.parseInt(s1);
        if(sum==sum1) {
            iv2.setImageResource(R.drawable.good);
            tv31.setText(sum1);
        }
        else {
            iv2.setImageResource(R.drawable.notgood);
            w++;
            tv31.setText(sum);
        }
    }

    public void level3(View view) {
        n2=rnd.nextInt();
        tv32.setText(n2);
        sum=sum+n2;
        s1= ed3.getText().toString();
        if (s1.equals(""))
            Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show();
        sum1=Integer.parseInt(s1);
        if(sum==sum1) {
            iv1.setImageResource(R.drawable.good);
        }
        else {
            iv1.setImageResource(R.drawable.notgood);
            w++;
        }
        success=((3-w)*100)/3;
        if(success==0)
            Toast.makeText(this, "Success:100%  3/3", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Success:"+success+"%"+"3/"+(3-w), Toast.LENGTH_SHORT).show();
    }

}
