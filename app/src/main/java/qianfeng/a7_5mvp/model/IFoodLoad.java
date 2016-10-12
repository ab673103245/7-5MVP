package qianfeng.a7_5mvp.model;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public interface IFoodLoad  {
    // 请求网络数据，并在这里把下载解析成功后的数据传出去，通过接口回调

    void getData(OnDataListener onDataListener);// OnDataListener是监听下载数据成功或失败的接口,成功或失败时回调
}
