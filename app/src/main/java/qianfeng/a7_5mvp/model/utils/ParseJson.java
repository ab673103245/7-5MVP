package qianfeng.a7_5mvp.model.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import qianfeng.a7_5mvp.model.Food;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class ParseJson {

    public static List<Food> parseJson(String json)
    {
        List<Food> list = new ArrayList<>();

        try {
            JSONArray tngou = new JSONObject(json).getJSONArray("tngou");
            for (int i = 0; i < tngou.length(); i++) {
                JSONObject data = tngou.getJSONObject(i);
                String descriptions = data.getString("description");
                String keywords = data.getString("keywords");
                String img = "http://tnfs.tngou.net/image"+data.getString("img");
                list.add(new Food(descriptions, keywords, img));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



        return list;
    }
}
