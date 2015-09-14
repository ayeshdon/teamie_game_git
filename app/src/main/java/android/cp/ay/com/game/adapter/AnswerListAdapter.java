package android.cp.ay.com.game.adapter;


import android.app.Activity;
import android.content.Context;
import android.cp.ay.com.game.R;
import android.cp.ay.com.game.bean.WordBean;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * This class use to do adpt row for answers list view
 */

public class AnswerListAdapter extends BaseAdapter{

	private Activity activity;
	private WordBean[] dataList;
	private WordBean dataBean;



	public AnswerListAdapter(Activity act, WordBean[] arrayList) {

		this.activity      = act;
		this.dataList      = arrayList;

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		try {

			View view = convertView; 

			final ViewHolder holder; 



			if (view == null) {

				LayoutInflater inflater = (LayoutInflater) activity
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.listview_answer, null);

				holder = new ViewHolder();
				view.setTag(holder);

			} else {
				holder = (ViewHolder) view.getTag();
			}

			if ((dataList == null) || ((position + 1) > dataList.length))
				return view;

			dataBean = dataList[position];





			holder.answerListTextView   = (TextView) view.findViewById(R.id.answerListTextView);

			if (holder.answerListTextView != null) {
			
				holder.answerListTextView.setText(dataBean.getWord());
		
			}

			return view;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public class ViewHolder {

		public TextView answerListTextView;


	}

	@Override
	public int getCount() {

		if (dataList!=null) {
			return dataList.length;
		}else{
			return 1;
		}

	}

	@Override
	public Object getItem(int index) {

		if (dataList!=null) {
			return dataList.length;
		}else{
			return null;
		}

	}

	@Override
	public long getItemId(int index) {
		return index;
	}


}