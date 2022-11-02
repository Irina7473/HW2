package space.ten.task2;

import static android.graphics.Color.rgb;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout CL;
    private FrameLayout fl1,fl2;
    private LinearLayout ll;
    private GridLayout gl1, gl2;
    private GridLayout.LayoutParams LPg;
    private Button B;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LPg = new GridLayout.LayoutParams();
        LPg.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        LPg.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        LPg.setGravity(Gravity.CENTER);

        gl1=new GridLayout(this);
        gl1.setLayoutParams(LPg);
        gl1.setColumnCount(2);
        gl1.setRowCount(2);
        for (int i = 1; i <= 4; i++)
        {
            B = new Button(this);
            B.setText("Button"+i);
            gl1.addView(B);
        }

        gl2=new GridLayout(this);
        gl2.setLayoutParams(LPg);
        gl2.setColumnCount(2);
        gl2.setRowCount(2);
        for (int i = 1; i <= 4; i++)
        {
            B = new Button(this);
            B.setText("Button"+i);
            gl2.addView(B);
        }

        fl1=new FrameLayout(this);
        fl1.setBackgroundColor(Color.rgb(0,250,154));
        fl1.setForegroundGravity(Gravity.CENTER);
        fl1.addView(gl1);

        fl2=new FrameLayout(this);
        fl2.setBackgroundColor(Color.rgb(255,105,180));
        fl2.setForegroundGravity(Gravity.CENTER);
        fl2.addView(gl2);

        LinearLayout.LayoutParams LP_FL = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1.0f
        );

        fl1.setLayoutParams(LP_FL);
        fl2.setLayoutParams(LP_FL);

        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setPadding(20,20,20,20);

        ll.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        ll.addView(fl1);
        ll.addView(fl2);

        CL=new ConstraintLayout(this);
        CL.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        CL.addView(ll);
        setContentView(CL);

    }
}
