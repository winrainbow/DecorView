package hgj.rain.demo.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.zip.Inflater;

import hgj.rain.demo.R;

/**
 * Created by hanguojing on 2016/5/30 19:39.
 */
public class SearchBar extends Button {
    // 构造函数
    private LinearLayout mContentView;
    private WeakReference<Activity> mActivity;

    public SearchBar(Context context) {
        this(context,null,0);
    }
    public SearchBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public SearchBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private void initView() {
        this.setText("搜索");
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSearchView();
            }
        });
    }

    /**
     * 弹出全屏搜索界面
     */
    private void gotoSearchView() {
        ViewGroup decorView = (ViewGroup) mActivity.get().getWindow().getDecorView();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.view_search, null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(0,0,0,0);
        view.setPadding(0,getBarHeight(),0,0);
        decorView.setLayoutParams(params);
        //view.setFocusable(true);
        //view.setClickable(true);
        //decorView.setLayoutParams();
        decorView.addView(view);
        this.setVisibility(View.GONE);
    }
    public void setWindow(Activity activity){
        mActivity = new WeakReference<>(activity);
    }

    public int getBarHeight(){
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 38;//默认为38，貌似大部分是这样的

        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = getResources().getDimensionPixelSize(x);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sbar;
    }



}
