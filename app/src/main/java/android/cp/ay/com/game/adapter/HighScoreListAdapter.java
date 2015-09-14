package android.cp.ay.com.game.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.cp.ay.com.game.R;
import android.cp.ay.com.game.bean.ScoreBean;
import android.cp.ay.com.game.bean.WordBean;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ayesh on 9/14/15.
 */
public class HighScoreListAdapter  extends BaseAdapter {

    private Activity activity;
    private ArrayList<ScoreBean> dataList;
    private ScoreBean dataBean;



    public HighScoreListAdapter(Activity act, ArrayList<ScoreBean> arrayList) {

        this.activity      = act;
        this.dataList      = arrayList;

    }

    @SuppressLint("NewApi")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        try {

            View view = convertView;

            final ViewHolder holder;



            if (view == null) {

                LayoutInflater inflater = (LayoutInflater) activity
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.listview_high_score, null);

                holder = new ViewHolder();
                view.setTag(holder);

            } else {
                holder = (ViewHolder) view.getTag();
            }

            if ((dataList == null) || ((position + 1) > dataList.size()))
                return view;

            dataBean = dataList.get(position);





            holder.highScoreRankTextView    = (TextView) view.findViewById(R.id.highScoreRankTextView);
            holder.highScoreNameTextView    = (TextView) view.findViewById(R.id.highScoreNameTextView);
            holder.highScoreScoreTextView   = (TextView) view.findViewById(R.id.highScoreScoreTextView);
            holder.highScoreLevelTextView   = (TextView) view.findViewById(R.id.highScoreLevelTextView);

            if (holder.highScoreRankTextView != null) {

                holder.highScoreRankTextView.setText(String.valueOf(dataBean.getRank()));

            }
            if (holder.highScoreScoreTextView != null) {

                holder.highScoreScoreTextView.setText(String.valueOf(dataBean.getScore()));

            }if (holder.highScoreLevelTextView != null) {

                holder.highScoreLevelTextView.setText(String.valueOf(dataBean.getLevel()));

            }
            if (holder.highScoreNameTextView != null) {

                holder.highScoreNameTextView.setText(dataBean.getName());

            }

            return view;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public class ViewHolder {

        public TextView highScoreRankTextView,highScoreNameTextView,highScoreScoreTextView,highScoreLevelTextView;


    }

    @Override
    public int getCount() {

        if (dataList!=null) {
            return dataList.size();
        }else{
            return 1;
        }

    }

    @Override
    public Object getItem(int index) {

        if (dataList!=null) {
            return dataList.size();
        }else{
            return null;
        }

    }

    @Override
    public long getItemId(int index) {
        return index;
    }


}