package qianfeng.a7_5mvp.presenter;

import android.content.Context;
import android.os.Handler;

import java.util.List;

import qianfeng.a7_5mvp.model.Food;
import qianfeng.a7_5mvp.model.IFoodLoadImpl;
import qianfeng.a7_5mvp.model.OnDataListener;
import qianfeng.a7_5mvp.view.IFoodView;
import qianfeng.a7_5mvp.view.MainActivity;
import qianfeng.a7_5mvp.view.MyAdapter;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class FoodShow {  // 这个类负责将view和数据（model）连接起来，起到显示的作用
    private IFoodView iFoodView;
    private IFoodLoadImpl iFoodLoadImpl;
    private Context context;
    private Handler mHandler = new Handler();

    public FoodShow(IFoodView iFoodView) {
        this.iFoodView = iFoodView;
        iFoodLoadImpl = new IFoodLoadImpl();
        this.context = ((MainActivity) iFoodView);
    }

    public void initData(){
        iFoodLoadImpl.getData(new OnDataListener() {
            @Override
            public void onSuccessful(final List<Food> list) { // 注意okHttp里面的方法都是在子线程中运行的，卧槽！

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        ((MainActivity) iFoodView).showListView(new MyAdapter(list,context));// context:Activity实例就是一个Context

                    }
                });
            }

            @Override
            public void onFailed(final String msg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        ((MainActivity) iFoodView).showErr(msg);
                    }
                });
            }
        });
    }
}
