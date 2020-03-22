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
    EditText et1,et2,et3;
    int n1,n2,w,sum,sum1,success;
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

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);

        start();
    }

    private void start() {
        n1=rnd.nextInt(90)+10;
        n2=rnd.nextInt(90)+10;
        tv11.setText("Number:  "+n1);
        tv12.setText("Number:  "+n2);
        tv21.setText("0");
        tv22.setText("0");
        tv31.setText("0");
        tv32.setText("0");
        et1.getText().clear();
        et2.getText().clear();
        et3.getText().clear();
        iv1.setImageDrawable(null);
        iv2.setImageDrawable(null);
        iv3.setImageDrawable(null);
        w=sum1=success=0;
    }

    public void level1(View view) {
        sum= n1+n2;
        String s1= et1.getText().toString();
        if(s1.equals(""))
            Toast.makeText(this,"please enter number",Toast.LENGTH_SHORT).show();
        else {
            sum1 = Integer.parseInt(s1);
            if (sum == sum1) {
                iv1.setImageResource(R.drawable.mark1);
            } else {
                iv1.setImageResource(R.drawable.mark0);
                w++;
            }
            tv21.setText("" + sum);
            n2 = rnd.nextInt(90) + 10;
            tv22.setText("" + n2);
        }
    }

    public void level2(View view){
        sum=sum+n2;
        String s1=et2.getText().toString();
        if(s1.equals(""))
            Toast.makeText(this,"please enter number",Toast.LENGTH_SHORT).show();
        else {
            sum1 = Integer.parseInt(s1);
            if (sum == sum1)
                iv2.setImageResource(R.drawable.mark1);

            else {
                iv2.setImageResource(R.drawable.mark0);
                w++;
            }
            tv31.setText("" + sum);
            n2 = rnd.nextInt(90) + 10;
            tv32.setText("" + n2);
        }
    }


    public void level3(View view){
        sum=sum+n2;
        String s1=et3.getText().toString();
        if(s1.equals(""))
            Toast.makeText(this,"please enter number",Toast.LENGTH_SHORT).show();
        else {
            sum1 = Integer.parseInt(s1);
            if (sum == sum1) {
                iv3.setImageResource(R.drawable.mark1);
            } else {
                iv3.setImageResource(R.drawable.mark0);
                w++;
            }
            success = ((3 - w) * 100) / 3;
            if (success == 0)
                Toast.makeText(this, "Success:100%  3/3", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Success:" + success + "%    " + "3/" + (3 - w), Toast.LENGTH_SHORT).show();
        }
    }

    public void start(View view) {
        start();
    }
}
