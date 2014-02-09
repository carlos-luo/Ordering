package com.carlos.ordering.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.carlos.ordering.domain.Cai;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CaiDao {
	private OrderingSQLiteOpenHelper dbHelper;
	public static final String DBNAME = "ordering.db";

	public CaiDao(Context context) {
		dbHelper = new OrderingSQLiteOpenHelper(context, DBNAME, null, 1);

	}

	public long Add(Cai cai) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put("caiID", cai.getCaiID());
		values.put("name", cai.getName());
		values.put("amount", cai.getAmount());
		values.put("price", cai.getPrice());
		values.put("recommanded", cai.getRecommanded());
		values.put("publishDate", cai.getPublishDate());

		long id = db.insert("Cai", null, values);

		db.close();
		return id;
	}

	public List<Cai> FindbyDate(String publishDate) {
		List<Cai> cais = new ArrayList<Cai>();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query("Cai", new String[] { "caiID", "name",
				"amount", "price", "recommanded" }, "publishDate=?",
				new String[] { publishDate }, null, null, null);

		while (cursor.moveToNext()) {
			Cai cai = new Cai();
			cai.setCaiID(cursor.getString(cursor.getColumnIndex("caiID")));
			cai.setName(cursor.getString(cursor.getColumnIndex("name")));
			cai.setAmount(cursor.getString(cursor.getColumnIndex("amount")));
			cai.setPrice(cursor.getString(cursor.getColumnIndex("price")));
			cai.setRecommanded(cursor.getString(cursor
					.getColumnIndex("recommanded")));
			cais.add(cai);
		}

		db.close();
		return cais;

	}

	public int GetCountbyDate(String publishDate) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db
				.query("Cai", new String[] { "caiID" }, "publishDate=?",
						new String[] { publishDate }, null, null, null);
		return cursor.getCount();
	}

}
