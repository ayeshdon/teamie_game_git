package android.cp.ay.com.game.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION                 = 01;
	private static final String DATABASE_NAME              	  = "DEMO_SCORE";
	
	//------ Feild name --
	public static final String KEY_ID               		  = "_id";
	public static final String NAME                 		  = "Name";
	public static final String SCORE                		  = "score";
	public static final String LEVEL                		  = "level";

	//---------Table name --
	public static final String SCORE_TABLE               	  = "SCORE";

	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		
		try {
			

			
		
			String CREATE_SCORE_TABLE = "CREATE TABLE "
					+ SCORE_TABLE + "("
					+ KEY_ID        + " INTEGER PRIMARY KEY  ,"
					+ SCORE       + " INTEGER ,"
					+ LEVEL       + " INTEGER ,"
					+ NAME        + " TEXT"
					+ ")";
			

			
			
			db.execSQL(CREATE_SCORE_TABLE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
}
