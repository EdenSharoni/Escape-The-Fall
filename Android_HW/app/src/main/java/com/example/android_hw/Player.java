package com.example.android_hw;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;

public class Player extends AppCompatImageView {

    private static final String TAG = Player.class.getSimpleName();
    private final int MAX_NUM_OF_LIVES = 3;
    private int num_lives = MAX_NUM_OF_LIVES;
    private GameActivity gameActivity;

    public Player(GameActivity context) {
        super(context);
        setPlayer();
        this.gameActivity = context;
    }

    private void setPlayer() {
        this.setImageResource(R.drawable.player1);
        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        this.setX(Resources.getSystem().getDisplayMetrics().widthPixels / 2 - (getResources().getDrawable(R.drawable.player1).getMinimumWidth() / 2));
        this.setY(Resources.getSystem().getDisplayMetrics().heightPixels - getResources().getDrawable(R.drawable.blue_lego).getMinimumHeight());
    }

    public int getNum_lives() {
        return num_lives;
    }

    public void hit() {
        gameActivity.removeLife();
        --num_lives;
        if (num_lives == 0)
            gameActivity.EndGame();
    }
}
