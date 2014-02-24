package com.rex.yuol.utils;

import com.rex.yuol.config.Path;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

public class Sql {
	private SQLiteDatabase db;

	public Sql() {
		// �򿪻򴴽�test.db���ݿ�
		db = SQLiteDatabase.openOrCreateDatabase(Path.check_dir() + "/yuol.db",
				null);
		this.db_open();
	}

	/**
	 * �򿪲��������ݱ�
	 * @return ���ݿ�
	 */
	public SQLiteDatabase db_open() {
		String check_exist_kv = "SELECT count(*) as c FROM sqlite_master WHERE type='table' AND name='kv'";
		Cursor cursor1= db.rawQuery(check_exist_kv, null);
		int count1=0;
		if(cursor1.moveToFirst()){  
            count1=cursor1.getInt(cursor1.getColumnIndex("c"));  
        }
		if(count1==0){
			// ����kv��
			db.execSQL("CREATE TABLE [kv] ([key] VARCHAR(20) UNIQUE NOT NULL PRIMARY KEY,[value] TEXT NOT NULL)");
		}
		
		/////////////////////
		
		String check_exist_jwc_notice = "SELECT count(*) as c FROM sqlite_master WHERE type='table' AND name='jwc_notice_list'";
		Cursor cursor2= db.rawQuery(check_exist_jwc_notice, null);
		int count2=0;
		if(cursor2.moveToFirst()){  
            count2=cursor2.getInt(cursor2.getColumnIndex("c"));  
        }
		if(count2==0){
			// ����jwc_notice_list��
			db.execSQL("CREATE TABLE [jwc_notice_list] ([url] NVARCHAR(512) UNIQUE NOT NULL PRIMARY KEY,[time] DATE NOT NULL, [title] NVARCHAR(512) NOT NULL )");
		}
		
		/////////////////////
		
		String check_exist_jwc_news = "SELECT count(*) as c FROM sqlite_master WHERE type='table' AND name='jwc_news_list'";
		Cursor cursor3= db.rawQuery(check_exist_jwc_news, null);
		int count3=0;
		if(cursor3.moveToFirst()){  
            count3=cursor3.getInt(cursor3.getColumnIndex("c"));  
        }
		if(count3==0){
			// ����jwc_news_list��
			db.execSQL("CREATE TABLE [jwc_news_list] ([url] NVARCHAR(512) UNIQUE NOT NULL PRIMARY KEY, [time] DATE NOT NULL,[title] NVARCHAR(512) NOT NULL)");
		}

		return db;
	}
	
	/**
	 * ��ȡ��Ӧkey��value
	 * @param key
	 * @return ����value
	 */
	static public String kv_get(String key){
		Cursor cursor;
		String value="";

		SQLiteDatabase db=new Sql().db;
		String table = "kv";
		String[] columns = new String[] { "key", "value" };
		String selection = "key=?";
		String[] selectionArgs = new String[] { key };
		String groupBy = null;
		String having = null;
		String orderBy = null;
		String limit = "1";

		cursor = db.query(table,columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		
		if(cursor.moveToFirst()){
            value=cursor.getString(cursor.getColumnIndex("value"));  
        }
		db.close();
		return value;
	}
	
	/**
	 * ���ö�Ӧkey��value
	 * @param key
	 * @param value
	 * @return ״̬��falseʧ�ܣ�true�ɹ�
	 */
	static public Boolean kv_set(String key,String value){
		SQLiteDatabase db=new Sql().db;
		
		ContentValues values = new ContentValues();
		values.put("key", key);
		values.put("value", value);
		long rowid = db.insert("kv", null, values);
		
		if(rowid>0){
			return true;
		}else{
			ContentValues values_update = new ContentValues();
			values_update.put("value", value);
			int i = db.update("kv", values_update, "key=?",new String[]{key});
			if(i>0){
				return true;
			}
		}
		
		db.close();
		return false;
	}

}
