package com.inid.sil.geektest;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by Guan at 2018/3/7 0007 上午 10:14
 * description:
 */
public class HorizontalCardAdapter2 extends RecyclerView.Adapter<HorizontalCardAdapter2.ViewHolder> {

    private List<Integer> bgColors;
    private List<Integer> bgColors2;

    public void refreshBgColor(){
        bgColors.clear();
        bgColors2.clear();
        initColors(5);
        this.notifyDataSetChanged();
    }

    public void addMoreBgColor(){
        initColors(3);
        this.notifyDataSetChanged();
    }

    public HorizontalCardAdapter2() {
        bgColors = new ArrayList<>();
        bgColors2 = new ArrayList<>();
        initColors(5);
    }

    private void initColors(int size){
        for (int i = 0; i < size; i++) {
            int r = new Random().nextInt(185);
            int g = new Random().nextInt(185);
            int b = new Random().nextInt(185);

            bgColors.add(Color.rgb(r, g, b));
            bgColors2.add(Color.rgb(r+70, g+70, b+70));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_horizontal_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ScreenUtils.getScreenWidth()- SizeUtils.dp2px(40), AbsListView.LayoutParams.MATCH_PARENT);
//        holder.itemView.setLayoutParams(params);


        int colors[] = { bgColors.get(position), bgColors2.get(position) };
        GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.text.setBackground(bg);
        }else {
            holder.text.setBackgroundDrawable(bg);
        }
        holder.text.setText(""+(position+1));
    }

    @Override
    public int getItemCount() {
        return bgColors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView.findViewById(R.id.itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
