package com.quanlt.vietcomicclean.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.quanlt.vietcomicclean.R;
import com.quanlt.vietcomicclean.presentation.di.HasComponent;
import com.quanlt.vietcomicclean.presentation.di.component.ComicComponent;
import com.quanlt.vietcomicclean.presentation.di.component.DaggerComicComponent;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;
import com.quanlt.vietcomicclean.presentation.view.fragment.ComicListFragment;
import com.quanlt.vietcomicclean.presentation.view.util.ComicSelectedListener;

public class ComicListActivity extends BaseActivity implements HasComponent<ComicComponent>,
        ComicSelectedListener {
    private ComicComponent comicComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.comicComponent = DaggerComicComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        if (savedInstanceState == null)
            addFragment(R.id.content_main, new ComicListFragment());
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

    @Override
    public ComicComponent getComponent() {
        return comicComponent;
    }

    @Override
    public void onComicSelected(ComicModel comic) {
        navigator.navigateToComicDetails(this, comic);
    }
}
