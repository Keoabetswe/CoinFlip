package com.example.keo.coinflip;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Button btnCoin;
    ImageView ivCoin;
    int coinSide; //heads, tails

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCoin = findViewById(R.id.btnCoin);
        ivCoin = findViewById(R.id.ivCoin);

        final Random rand = new Random();

        btnCoin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                coinSide = rand.nextInt(2);

                if(coinSide == 0)
                {
                    ivCoin.setImageResource(R.drawable.tails);
                    Toast.makeText(getApplicationContext(), "Tails!", Toast.LENGTH_SHORT).show();
                }
                else if(coinSide == 1)
                {
                    ivCoin.setImageResource(R.drawable.heads);
                    Toast.makeText(getApplicationContext(), "Heads!", Toast.LENGTH_SHORT).show();
                }

                RotateAnimation rotate = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(1000);
                ivCoin.startAnimation(rotate);
            }
        });
    }
}
