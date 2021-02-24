package cs301.birthdaycake;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener{
    private CakeView mView;
    private CakeModel mCakeModel;

    public CakeController(CakeView cakeView){
        mView = cakeView;
        mCakeModel = cakeView.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        Log.d("button", "pressed");
        mCakeModel.lit = false;
        mView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        mCakeModel.candles = b;
        mView.invalidate();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekBar.setMax(5);
        if(fromUser){
            mCakeModel.candleNumber = progress;
        }
        mView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mCakeModel.touch = true;
        mCakeModel.cx = motionEvent.getX() - 50f;
        mCakeModel.cy = motionEvent.getY() - 75f;

        mView.invalidate();
        return mCakeModel.touch;
    }
}
