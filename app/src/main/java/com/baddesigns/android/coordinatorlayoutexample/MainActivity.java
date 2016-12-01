package com.baddesigns.android.coordinatorlayoutexample;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyContract.View, View.OnClickListener {

    private MyContract.Presenter mPresenter;
    private AppBarLayout mAppBarLayout;
    private TextView mClController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(verticalOffset == 0) {
                    mPresenter.onCoordinatorExpanded();
                } else if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    mPresenter.onCoordinatorCollapsed();
                } else {
                    mPresenter.onCoordinatorIdle();
                }
            }
        });
        mClController = (TextView) findViewById(R.id.clController);
        mClController.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> textList = createTextArrayList();
        MyAdapter adapter = new MyAdapter(this, textList);
        recyclerView.setAdapter(adapter);

        mPresenter = new MyPresenter();
        mPresenter.setView(this);
    }

    private List<String> createTextArrayList() {
        List<String> textList = new ArrayList<>();
        textList.add("this is");
        textList.add("a");
        textList.add("few");
        textList.add("words to");
        textList.add("display");
        textList.add("some text");
        textList.add("to");
        textList.add("sohow off");
        textList.add("the");
        textList.add("coordinator");
        textList.add("layout");
        textList.add("and a");
        textList.add("few");
        textList.add("more");
        textList.add("words");
        textList.add("just");
        textList.add("for fun");
        return textList;
    }

    @Override
    public void showCollapsedNotification() {
        Toast.makeText(MainActivity.this, "CL collapsed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showExpandedNotification() {
        Toast.makeText(this, "CL expanded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void expand() {
        mAppBarLayout.setExpanded(true);
    }

    @Override
    public void collapse() {
        mAppBarLayout.setExpanded(false);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == mClController.getId()) {
            mPresenter.onButtonPressed();
        }
    }

    @Override
    public void setTextViewState(boolean collapsed) {
        String text;
        if(!collapsed) {
            text = "Collapse";
        } else {
            text = "Expand";
        }
        mClController.setText(text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public MyContract.Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(MyContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
