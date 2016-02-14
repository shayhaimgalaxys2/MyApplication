package com.shayhaim.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shayhaim.myapplication.Deal;
import com.shayhaim.myapplication.R;
import com.shayhaim.myapplication.adapters.DealsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView dealsLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListView();

    }



    private void initViews() {
        dealsLv = (ListView) findViewById(R.id.dealsLv);

    }

    private void initListView() {


        final ArrayList<Deal> deals=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            deals.add(new Deal(i));
        }


        DealsListAdapter dealsListAdapter=new DealsListAdapter(MainActivity.this,deals);

        dealsLv.setAdapter(dealsListAdapter);

        dealsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Deal deal=deals.get(position);
                Bundle bundle=new Bundle();
                bundle.putSerializable(DealActivity.DEAL_KEY,deal);

                Intent intent=new Intent(MainActivity.this,DealActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);



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

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();


    }
}
