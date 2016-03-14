package common.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.stmandroidtoolbox.R;

/**
 * Created by StephenMa on 16/3/14.
 */
public class STMTintTextView extends TextView {
    private ColorStateList  mTintList = null;
    private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_ATOP;

    public STMTintTextView(Context context) {
        this(context, null);
    }

    public STMTintTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public STMTintTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.STMTintTextView);
        if (a!=null){
            if (a.hasValue(R.styleable.STMTintTextView_drawableTint)){
                mTintList = a.getColorStateList(R.styleable.STMTintTextView_drawableTint);
                mTintMode = PorterDuff.Mode.SRC_ATOP;
            }
            if (a.hasValue(R.styleable.STMTintTextView_drawableTintMode)){
                mTintMode = parseTintMode(a.getInt(R.styleable.STMTintTextView_drawableTintMode, -1), PorterDuff.Mode.SRC_ATOP);
            }
            a.recycle();
            applyTint();
        }
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mTintList !=null && mTintList.isStateful()){
            applyTint();
        }
    }

    public void setDrawableTintList(ColorStateList tintList){
        mTintList = tintList;
        applyTint();
    }

    public ColorStateList getDrawableTintList(){
        return mTintList;
    }

    public void setDrawableTintMode(PorterDuff.Mode tintMode){
        mTintMode = tintMode;
        applyTint();
    }

    public PorterDuff.Mode getDrawableTintMode(){
        return mTintMode;
    }

    private void applyTint(){
        if (mTintList == null){
            return;
        }

        int color = mTintList.getColorForState(getDrawableState(), Color.WHITE);
        Drawable[] drawables = getCompoundDrawables();
        for (int i = 0; i < drawables.length; i++){
            Drawable drawable = drawables[i];
            if (drawable != null){
                if (color == Color.TRANSPARENT){
                    drawable.mutate().setColorFilter(null);
                }
                else {
                    drawable.mutate().setColorFilter(color, mTintMode);
                }
            }
        }
    }

    private static PorterDuff.Mode parseTintMode(int value, PorterDuff.Mode defaultMode){
        switch (value){
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return defaultMode;
        }
    }
}
