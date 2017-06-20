package vidur.codeclan.projectx.Activities;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;

import vidur.codeclan.projectx.POJO.Posts;
import vidur.codeclan.projectx.R;
import vidur.codeclan.projectx.Adapters.TabsPagerAdapter;

import static vidur.codeclan.projectx.POJO.GlobalAccess.URL_POST;
import static vidur.codeclan.projectx.POJO.GlobalAccess.currPosts;

public class TabbedActivity extends FragmentActivity implements android.app.ActionBar.TabListener {

    private static final String TAG = "TabbedActivity";
    ViewPager viewPager;
    TabsPagerAdapter adapter;
    android.app.ActionBar actionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchPosts();

        setContentView(R.layout.activity_tabbed);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


        actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setStackedBackgroundDrawable(getResources().getDrawable(R.color.black));

        String[] tabs = { "Videos", "Articles", "Podcasts" };
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }


        viewPager.setCurrentItem(1);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_bookmarks :
                break;

            case R.id.nav_settings:
                break;

            case R.id.nav_feedback:
                break;

            case R.id.nav_aboutus:
                break;
        }

        return true;
    }

    @Override
    public void onTabSelected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {
            viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {

    }

    public void fetchPosts() {
        Volley.newRequestQueue(this).add(new StringRequest(URL_POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        currPosts = new GsonBuilder().create().fromJson(response, Posts.class);
                        Log.d(TAG, "onResponse: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TabbedActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }));
    }
}