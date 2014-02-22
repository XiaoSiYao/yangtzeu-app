package com.rex.yuol.utils;

import java.io.File;

import com.rex.yuol.config.Path;

import android.content.Context;
import android.database.sqlite.*;

public class Sql {

	public static SQLiteDatabase db_open() {
		// �򿪻򴴽�test.db���ݿ�
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
				Path.check_dir() + "/rex.db", null);

		db.execSQL("DROP TABLE IF EXISTS person");
		// ����person��
		db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");

		// �رյ�ǰ���ݿ�
		db.close();
		return db;

	}

}
