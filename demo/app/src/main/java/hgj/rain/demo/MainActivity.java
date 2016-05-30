package hgj.rain.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

import hgj.rain.demo.view.SearchBar;

public class MainActivity extends AppCompatActivity {

    private SearchBar mViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getActionBar().hide();
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mViewSearch = (SearchBar) findViewById(R.id.view_search);

        mViewSearch.setWindow(this);

    }

    @Override
    public void onBackPressed() {
        if(mViewSearch.getVisibility() == View.GONE){

        }else{
        super.onBackPressed();}
    }
}
