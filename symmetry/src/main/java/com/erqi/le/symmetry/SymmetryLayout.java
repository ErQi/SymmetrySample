package com.erqi.le.symmetry;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 功 能：简单的布局容器,用于左右对对称的排列 <br>
 * 时 间：2016/8/2 15:13 <br>
 */
public class SymmetryLayout extends LinearLayout {
    public static final int LEFT = 0x01;
    public static final int RIGHT = 0x02;
    public static final int CENTER = 0x03;

    public SymmetryLayout(Context context) {
        this(context, null);
    }

    public SymmetryLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SymmetryLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public SymmetryLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
    }

    @IntDef({LEFT, RIGHT, CENTER})
    @Retention(RetentionPolicy.SOURCE)
    @interface GRAVITY {
    }

    private TextView mTvLeft;
    private TextView mTvRight;


    private void init(Context context, AttributeSet attrs) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_symmetry, this);
        mTvLeft = (TextView) inflate.findViewById(R.id.tv_left);
        mTvRight = (TextView) inflate.findViewById(R.id.tv_right);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SymmetryLayout);
            int colorLeft = typedArray.getColor(R.styleable.SymmetryLayout_textColorLeft, 0);
            int colorRight = typedArray.getColor(R.styleable.SymmetryLayout_textColorRight, 0);
            int sizeLeft = typedArray.getDimensionPixelSize(R.styleable.SymmetryLayout_textSizeLeft, 0);
            int sizeRight = typedArray.getDimensionPixelSize(R.styleable.SymmetryLayout_textSizeRight, 0);
            int gravityLeft = typedArray.getInt(R.styleable.SymmetryLayout_gravityLeft, 0);
            int gravityRight = typedArray.getInt(R.styleable.SymmetryLayout_gravityRight, 0);
            int layoutGravityLeft = typedArray.getInt(R.styleable.SymmetryLayout_layout_gravityLeft, 0);
            int layoutGravityRight = typedArray.getInt(R.styleable.SymmetryLayout_layout_gravityRight, 0);
            int gravity = typedArray.getInt(R.styleable.SymmetryLayout_gravity, 0);
            int lines = typedArray.getInt(R.styleable.SymmetryLayout_textLines, 0);
            Drawable drawableLeft = typedArray.getDrawable(R.styleable.SymmetryLayout_backgroundLeft);
            Drawable drawableRight = typedArray.getDrawable(R.styleable.SymmetryLayout_backgroundRight);

            mTvLeft.setText(typedArray.getText(R.styleable.SymmetryLayout_textLeft));
            mTvRight.setText(typedArray.getText(R.styleable.SymmetryLayout_textRight));
            if (colorLeft != 0) mTvLeft.setTextColor(colorLeft);
            if (colorRight != 0) mTvRight.setTextColor(colorRight);
            if (sizeLeft != 0) mTvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizeLeft);
            if (sizeRight != 0) mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizeRight);
            if (gravityLeft != 0) mTvLeft.setGravity(gravityLeft);
            if (gravityRight != 0) mTvRight.setGravity(gravityRight);
            if (layoutGravityLeft != 0)
                ((LayoutParams) mTvLeft.getLayoutParams()).gravity = layoutGravityLeft;
            if (layoutGravityRight != 0)
                ((LayoutParams) mTvRight.getLayoutParams()).gravity = layoutGravityRight;
            if (drawableLeft != null) mTvLeft.setBackground(drawableLeft);
            if (drawableRight != null) mTvRight.setBackground(drawableRight);
            if (gravity != 0) {
                setLayoutGravity(gravity);
            }
            if (lines != 0) {
                mTvLeft.setMaxLines(lines);
                mTvRight.setMaxLines(lines);
            }
            typedArray.recycle();
        }
    }

    /**
     * 功 能：设置布局的对其方式 <br>
     * 时 间：2016/8/5 18:23 <br>
     *
     * @param gravity {@link #LEFT} 左边为对齐基准<br>
     *                {@link #RIGHT} 右边为对齐基准<br>
     *                {@link #CENTER} 左右平分布局<br>
     */
    public void setLayoutGravity(@GRAVITY int gravity) {
        LayoutParams leftParams = (LayoutParams) mTvLeft.getLayoutParams();
        LayoutParams rightParams = (LayoutParams) mTvRight.getLayoutParams();
        switch (gravity) {
            case LEFT:
                leftParams.weight = 0;
                leftParams.width = LayoutParams.WRAP_CONTENT;
                rightParams.weight = 1;
                rightParams.width = 0;
                break;
            case RIGHT:
                leftParams.weight = 1;
                leftParams.width = 0;
                rightParams.weight = 0;
                rightParams.width = LayoutParams.WRAP_CONTENT;
                break;
            case CENTER:
                leftParams.weight = 1;
                leftParams.width = 0;
                rightParams.weight = 1;
                rightParams.width = 0;
                break;
            default:
                break;
        }
    }

    /**
     * 功 能：获取左侧的TextView控件,方便进行各种设置操作 <br>
     * 时 间：2016/8/5 17:14 <br>
     *
     * @return 左侧的TextView
     */
    public TextView getTvLeft() {
        return mTvLeft;
    }

    /**
     * 功 能：获取右侧的TextView控件,各种设置属性实在繁多...直接丢控件 <br>
     * 时 间：2016/8/5 17:15 <br>
     *
     * @return 右侧的TextView
     */
    public TextView getTvRight() {
        return mTvRight;
    }
}
