package com.zhiyuan3g.androidfirstmoudle.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhiyuan3g.androidfirstmoudle.R;
import com.zhiyuan3g.androidfirstmoudle.db.ProvinceDB;
import com.zhiyuan3g.androidfirstmoudle.entity.ProvinceEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/8/23.
 */

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder>{

    private Context context;
    private List<ProvinceDB> provinceDBs;

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick{
        void itemClick(int position);
    }

    public ProvinceAdapter(Context context, List<ProvinceDB> provinceDBs) {
        this.context = context;
        this.provinceDBs = provinceDBs;
    }

    @Override
    public ProvinceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_public_name, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClick != null){
                    onItemClick.itemClick(viewHolder.getAdapterPosition());
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProvinceAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(provinceDBs.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return provinceDBs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_public_name)
        TextView tv_name;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            view = itemView;
        }
    }
}
