package qianfeng.a7_5mvp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import qianfeng.a7_5mvp.R;
import qianfeng.a7_5mvp.model.Food;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class MyAdapter extends BaseAdapter {

    private List<Food> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<Food> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.listview_item,parent,false);
            holder = new ViewHolder();
            holder.description = (TextView) convertView.findViewById(R.id.description);
            holder.keywords = (TextView) convertView.findViewById(R.id.keywords);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        Food food = list.get(position);
        holder.description.setText(food.getDescription());
        holder.keywords.setText(food.getKeywords());
        Picasso.with(context).load(food.getImg()).into(holder.iv);

        return convertView;
    }

    class ViewHolder{
        TextView description,keywords;
        ImageView iv;

    }
}
