package com.waynechen.recyclerviewusage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "WayneC_RVU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);

        /**
         * LinearLayoutManager
          */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration
                = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        /**
         * GridLayoutManager, span count: 2
          */
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        GridSpacingItemDecoration itemDecoration = new GridSpacingItemDecoration(2, 4, false);

        /**
         * GridLayoutManager, span count: 3
          */
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
//        GridSpacingItemDecoration itemDecoration
//                = new GridSpacingItemDecoration(2, 4, false);

        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastVisibleItemPosition;
            private int firstVisibleItemPosition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                int visibleItemCount = layoutManager.getChildCount();

                int totalItemCount = layoutManager.getItemCount();

                if (newState == RecyclerView.SCROLL_STATE_IDLE && visibleItemCount > 0) {

                    if (lastVisibleItemPosition == totalItemCount - 1) {
                        Log.d(TAG, "Scroll to bottom");


                    } else if (firstVisibleItemPosition == 0) {
                        Log.d(TAG, "Scroll to top");

                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                if (layoutManager instanceof LinearLayoutManager) {

                    lastVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                            .findLastVisibleItemPosition();

                    firstVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                            .findFirstVisibleItemPosition();

                } else if (layoutManager instanceof GridLayoutManager) {

                    lastVisibleItemPosition = ((GridLayoutManager) layoutManager)
                            .findLastVisibleItemPosition();

                    firstVisibleItemPosition = ((GridLayoutManager) layoutManager)
                            .findFirstVisibleItemPosition();
                }
            }
        });

        MainAdapter adapter = new MainAdapter(new ModelMain().getUsageItems());
        recyclerView.setAdapter(adapter);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
