package android.cp.ay.com.game.db.table;


import android.content.ContentValues;
import android.content.Context;
import android.cp.ay.com.game.bean.ScoreBean;
import android.cp.ay.com.game.db.DatabaseHelper;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * this class use to maintain all db calls regrading ro score info
 */


public class ScoresTable {

	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;

	public ScoresTable(Context context){
		if(dbHelper == null)
			dbHelper = new DatabaseHelper(context);
	}

	/**
	 * open db  connection
	 * @throws SQLException
	 */
	private void open() throws SQLException {
		database = dbHelper.getWritableDatabase();

	}

	/**
	 * close db connection
	 */
	private void close() {
		dbHelper.close();
		database.close();
	}

	/**
	 * delete all rows
	 * @throws Exception
	 */
	public void deleteALL() throws Exception {

		try {

			open();
			database.delete(DatabaseHelper.SCORE_TABLE, null,null);


		} catch (Exception e) {
			throw e;
		}finally{
			close();
		}

	}

	/**
	 * insert score details to local database
	 * @param dataBean - data model
	 * @throws Exception
	 */
	public void insertContact(ScoreBean dataBean) throws Exception{

		try {
			open();

			ContentValues values = new ContentValues();

			values.put(DatabaseHelper.NAME, dataBean.getName());
			values.put(DatabaseHelper.SCORE, dataBean.getScore());
			values.put(DatabaseHelper.LEVEL, dataBean.getLevel());

			database.insert(DatabaseHelper.SCORE_TABLE, null, values);

		} catch (Exception e) {
			throw e;
		}finally{
			close();
		}


	}



	/**
	 * get top 5  Score details ascending order by score
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ScoreBean> getTopScoreList() throws Exception {

		Cursor cursor = null;
		try {
			ArrayList<ScoreBean> dataList=new  ArrayList<ScoreBean>();

			open();



			String query = "SELECT " +
					" con."+DatabaseHelper.KEY_ID        +" AS " + DatabaseHelper.KEY_ID  +", " +
					" con."+DatabaseHelper.NAME          +" AS " + DatabaseHelper.NAME    +", " +
					" con."+DatabaseHelper.LEVEL         +" AS " + DatabaseHelper.LEVEL    +", " +
					" con."+DatabaseHelper.SCORE         +" AS " + DatabaseHelper.SCORE  +" " +
					" FROM "+DatabaseHelper.SCORE_TABLE+ " AS con ORDER BY "+DatabaseHelper.SCORE+" DESC LIMIT 5 " ;


			cursor = database.rawQuery(query,null);

             int rank = 1;

			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

				ScoreBean dataBean = new ScoreBean();

				dataBean.setRank(rank);
				rank++;
				dataBean.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAME)));
				dataBean.setLevel(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.LEVEL)));
				dataBean.setScore(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.SCORE)));


				dataList.add(dataBean);

			}

			return dataList;
		} catch (Exception e) {
			throw e;
		}finally{
			close();
			if (cursor!=null) {
				cursor.close();
			}
		}

	}
	/**
	 * get top Score
	 * @return
	 * @throws Exception
	 */
	public int getTopScore() throws Exception {

		Cursor cursor = null;
		try {

			open();



			String query = "SELECT " +
					"MAX( con."+DatabaseHelper.SCORE         +" ) AS " + DatabaseHelper.SCORE  +" " +
					" FROM "+DatabaseHelper.SCORE_TABLE+ " AS con  " ;


			cursor = database.rawQuery(query,null);

			int value = 0;

			if(cursor.getCount() > 0) {

				cursor.moveToFirst();
				value = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.SCORE));


			}


			return value;


		} catch (Exception e) {
			throw e;
		}finally{
			close();
			if (cursor!=null) {
				cursor.close();
			}
		}

	}

}
