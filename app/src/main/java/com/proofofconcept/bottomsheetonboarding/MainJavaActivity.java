package com.proofofconcept.bottomsheetonboarding;

import android.os.Bundle;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainJavaActivity extends AppCompatActivity {

    private LinearLayout linearLayoutBottomSheet;
    private Handler animationHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutBottomSheet = findViewById(R.id.linearLayoutBottomSheet);
        animationHandler = new Handler();

        animationHandler.post(new Runnable() {
            @Override
            public void run() {

                ViewPropertyAnimator viewPropertyAnimator =
                        linearLayoutBottomSheet.animate().translationYBy(-40f).setDuration(200);

                viewPropertyAnimator.withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        linearLayoutBottomSheet.animate().translationYBy(40f).setDuration(200);
                    }
                });

                animationHandler.postDelayed(this, 1000);
            }
        });


    }
}
