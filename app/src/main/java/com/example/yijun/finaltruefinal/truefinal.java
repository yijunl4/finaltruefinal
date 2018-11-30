package com.example.yijun.finaltruefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class truefinal extends AppCompatActivity {

    Button tochem;
    Button tomath;
    Button tophy;
    Button tohis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truefinal);

        tochem = (Button) findViewById(R.id.tochem);
        tochem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here start chemistry layout//

                Intent intent = new Intent();
                intent.setClass(truefinal.this, chemistry.class);

                startActivity(intent);
            }
        });

        tomath = (Button) findViewById(R.id.tomath);
        tomath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here start chemistry layout//

                Intent intent1 = new Intent();
                intent1.setClass(truefinal.this, math.class);

                startActivity(intent1);
            }
        });

        tophy = (Button) findViewById(R.id.tophy);
        tophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here start chemistry layout//

                Intent intent2 = new Intent();
                intent2.setClass(truefinal.this, phy.class);

                startActivity(intent2);
            }
        });

        tohis = (Button) findViewById(R.id.tohis);
        tohis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here start chemistry layout//

                Intent intent3 = new Intent();
                intent3.setClass(truefinal.this, his.class);

                startActivity(intent3);
            }
        });
    }
}
