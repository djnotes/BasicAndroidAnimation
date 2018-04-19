package com.zoodbashcity.animationdrawable;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    ImageView box;
    Button start;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        box = findViewById(R.id.box);
        start = findViewById(R.id.start);


        image.setBackgroundResource(R.drawable.animation);

        AnimationDrawable frameAnimation = (AnimationDrawable) image.getBackground();

        frameAnimation.start();



        //Animate box
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnticipateInterpolator interpolator = new AnticipateInterpolator();
                AnimationSet set = new AnimationSet(MainActivity.this, null);
                set.addAnimation(
                        new ScaleAnimation(0, 2, 0, 2)
                );
                set.addAnimation(
                        new RotateAnimation(0f, -360)
                );
                set.setInterpolator(interpolator);
                set.setDuration(3000);

                box.startAnimation(set);

            }
        });

    }
}
