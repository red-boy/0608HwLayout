package com.example.hw.a0608hwlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by HaodaHw on 2017/6/8.
 * <p>
 * 自定义重复的标题栏控件
 */

public class HwTitleBar extends LinearLayout {
    private String titleName;
    private Drawable background;//此处参数值属性不能为int，因为会与xml文件中的@drawable冲突报错

    private ImageView mBackground;
    private TextView mTitleName;

    public HwTitleBar(Context context) {
        this(context, null);
    }

    public HwTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HwTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //从xml的属性中获取到字体、图片等
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HwTitleBar);

        titleName = typedArray.getString(R.styleable.HwTitleBar_titleName);
        background = typedArray.getDrawable(R.styleable.HwTitleBar_backgroundhw);
        typedArray.recycle();

        //加载布局控件
        LayoutInflater.from(context).inflate(R.layout.hwtitlebar_item, this);
        mBackground = (ImageView) findViewById(R.id.leftImage);
        mTitleName = (TextView) findViewById(R.id.titleName);

        //将控件与设置的xml属性关联
        mBackground.setImageDrawable(background);
        mTitleName.setText(titleName);

    }
}
