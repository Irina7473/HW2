package space.ten.task3;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout CL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CL = findViewById(R.id.head);

        CheckBox cbRed = (CheckBox) findViewById(R.id.red);
        CheckBox cbGreen = (CheckBox) findViewById(R.id.green);
        CheckBox cbBlue = (CheckBox) findViewById(R.id.blue);

        Button bSelect = (Button) findViewById(R.id.selection);
        bSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbRed.isChecked()) {
                    CL.setBackgroundColor(Color.rgb(255, 0, 0));
                    if (cbGreen.isChecked() && !cbBlue.isChecked())
                        CL.setBackgroundColor(Color.rgb(255, 255, 0));
                    if (!cbGreen.isChecked() && cbBlue.isChecked())
                        CL.setBackgroundColor(Color.rgb(0, 128, 0));
                    if (cbGreen.isChecked() && cbBlue.isChecked())
                        CL.setBackgroundColor(Color.rgb(255, 255, 255));
                } else if (cbGreen.isChecked()) {
                    CL.setBackgroundColor(Color.rgb(0, 128, 0));
                    if (!cbRed.isChecked() && cbBlue.isChecked())
                        CL.setBackgroundColor(Color.rgb(0, 128, 128));
                } else if (cbBlue.isChecked())
                    CL.setBackgroundColor(Color.rgb(0, 0, 255));
                else
                    CL.setBackgroundColor(Color.rgb(255, 255, 255));

            }
        });
    }
}