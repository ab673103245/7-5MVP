package qianfeng.a7_5mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import qianfeng.a7_5mvp.R;
import qianfeng.a7_5mvp.presenter.FoodShow;

public class MainActivity extends AppCompatActivity implements IFoodView {

    private ListView lv;
    private ProgressBar pb;

    private FoodShow foodShow = new FoodShow(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        foodShow.initData();
    }

    private void init() {
        lv = ((ListView) findViewById(R.id.lv));
        pb = ((ProgressBar) findViewById(R.id.pb));
    }


    @Override
    public void showPb() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePb() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void showListView(MyAdapter adapter) {
        lv.setAdapter(adapter);
    }

    @Override
    public void showErr(String msg) {
        Toast.makeText(MainActivity.this,msg , Toast.LENGTH_SHORT).show();
    }
}
