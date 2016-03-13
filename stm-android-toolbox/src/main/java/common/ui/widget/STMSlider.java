package common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by StephenMa on 16/3/12.
 */
public class STMSlider extends SeekBar{
    private final OnSeekBarChangeListener seekBarChangeListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public STMSlider(Context context) {
        this(context, null);
    }

    public STMSlider(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public STMSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init(){
        this.setOnSeekBarChangeListener(this.seekBarChangeListener);
    }
}
