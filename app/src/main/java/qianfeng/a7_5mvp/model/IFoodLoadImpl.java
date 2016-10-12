package qianfeng.a7_5mvp.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import qianfeng.a7_5mvp.model.utils.OkhttpUtils;
import qianfeng.a7_5mvp.model.utils.ParseJson;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class IFoodLoadImpl implements IFoodLoad {



    @Override
    public void getData(final OnDataListener onDataListener) {

        // 在这里开启okhttp连接
        Request request = new Request.Builder().url("http://www.tngou.net/api/cook/list").build(); // 注意url是在这里传的，与数据操作有关的所有的东西，都只能在model包中完成
        OkhttpUtils.getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onDataListener.onFailed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful())
                {
                    onDataListener.onSuccessful(ParseJson.parseJson(response.body().string()));
                }
            }
        });
    } // 因为IFoodLoad是接口，只能自己来找个实现类
}
