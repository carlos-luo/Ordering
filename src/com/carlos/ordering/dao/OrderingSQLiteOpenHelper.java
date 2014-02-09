package com.carlos.ordering.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderingSQLiteOpenHelper extends SQLiteOpenHelper {

	/**
	 * Create a helper object to create, open, and/or manage a database. This
	 * method always returns very quickly. The database is not actually created
	 * or opened until one of {@link #getWritableDatabase} or
	 * {@link #getReadableDatabase} is called.
	 * 
	 * @param context
	 *            to use to open or create the database
	 * @param name
	 *            of the database file, or null for an in-memory database
	 * @param factory
	 *            to use for creating cursor objects, or null for the default
	 * @param version
	 *            number of the database (starting at 1); if the database is
	 *            older, {@link #onUpgrade} will be used to upgrade the
	 *            database; if the database is newer, {@link #onDowngrade} will
	 *            be used to downgrade the database
	 */
	public OrderingSQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE Cai (id integer primary key autoincrement, caiID varchar(20), name varchar(20), amount varchar(32), price varchar(32), recommanded varchar(10), publishDate varchar(32))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
