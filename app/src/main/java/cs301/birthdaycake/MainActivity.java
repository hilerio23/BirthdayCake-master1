package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        final CakeView mCakeView = (CakeView) findViewById(R.id.cakeview);
        final CakeController cakeController = new CakeController(mCakeView);
        Button blowOutButton = (Button) findViewById(R.id.Extinguish);
        Switch candleSwitch = (Switch) findViewById(R.id.switch2);
        SeekBar candleAmount = (SeekBar) findViewById(R.id.seekBar);

        blowOutButton.setOnClickListener(cakeController);

        candleSwitch.setOnCheckedChangeListener(cakeController);

        candleAmount.setOnSeekBarChangeListener(cakeController);

        mCakeView.setOnTouchListener(cakeController);
    }

    public void goodbye(View button) {
        Log.i("button","Goodbye");
    }
}
