package qianfeng.a7_5mvp.view;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public interface IFoodView {

    void showPb();

    void hidePb();

    void showListView(MyAdapter adapter); // ，直接显示ListView的数据啦！

    void showErr(String msg);  // 弹个Toast

}
