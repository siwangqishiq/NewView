package com.xinlan.newview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.xinlan.newview.animation.SlideScaleInOutRightItemAnimator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mList;
    private List<String> datas;
    private ListAdapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        datas = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            datas.add(i + "");
        }//end for i
    }

    private void initView() {
        //init RecyclerView
        mList = (RecyclerView) findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//垂直布局
        //mList.setItemAnimator(new DefaultItemAnimator());
        mList.setItemAnimator(new SlideScaleInOutRightItemAnimator(mList));
        //setAdapter
        adpter = new ListAdapter(this, datas);
        mList.setAdapter(adpter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_layout_grid) {
            mList.setLayoutManager(new GridLayoutManager(this,4));
            return true;
        }

        if (id == R.id.action_add) {//增加数据项
            adpter.addItem();
            return true;
        }

        if (id == R.id.action_remove) {//删除数据项
            adpter.removeItem();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
