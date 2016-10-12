package qianfeng.a7_5mvp.model.utils;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class OkhttpUtils  {

    // OkHttpClient：并不是单例的，要注意，要自己把它做成单例。有new的都不是单例啦！
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    public static OkHttpClient getOkHttpClient()
    {
        return okHttpClient;
    }
}
