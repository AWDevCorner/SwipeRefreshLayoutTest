package it.androidworld.devcorner.SwipeRefreshLayoutTest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SwishActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener{

    SwipeRefreshLayout layout;
    Button btnStopUpdate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        layout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        layout.setOnRefreshListener(this);
        layout.setColorScheme(android.R.color.holo_green_dark, android.R.color.holo_blue_dark, android.R.color.holo_orange_light, android.R.color.holo_red_dark);

        /**
         * [ENG] This is evil - do not do it at house, kids!
         *
         * [ITA] Questo è IL male! Non fatelo a casa!
         * */
        btnStopUpdate = (Button) findViewById(R.id.btnStopUpdate);
        btnStopUpdate.setOnClickListener(this);
    }


    @Override
    public void onRefresh() {

        /**
         * [ENG] I'm useless and I know it
         *
         * [ITA] Sono inutile, ma mi piace comunicare
         * */
        Toast.makeText(this,"Mi hai swipato!",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        /**
         * [ENG] This is so evil... Remember:
         * Long operations on main thread are bad. And you are evil if you do.
         *
         * [ITA] Quanta malvagità in questa operazione... ricorda:
         * Le operazioni lunghe sul Main Thread non si fanno. Pena il PERMABAN dal DevCorner :-P
         * */
        layout.setRefreshing(false);
    }

}
