package qianfeng.a7_5mvp.model;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public interface OnDataListener {
    // OnDataListener是监听下载数据成功或失败的接口,成功或失败时回调
    void onSuccessful(List<Food> list);
    void onFailed(String msg);
}
