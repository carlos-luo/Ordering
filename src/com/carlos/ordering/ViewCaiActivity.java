package com.carlos.ordering;

import java.util.List;

import com.carlos.ordering.dao.CaiDao;
import com.carlos.ordering.domain.Cai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCaiActivity extends Activity {

	ListView lvCai;
	List<Cai> cais;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewcai);
		
		CaiDao caiDao = new CaiDao(this);
		cais = caiDao.FindbyDate("2014-1-28");
		
		lvCai = (ListView) findViewById(R.id.lv_Cai);
		lvCai.setAdapter(new MyAdapter());
		
//		Toast.makeText(this, cais.size(), Toast.LENGTH_SHORT).show();
	}
	
	public class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return cais.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = new TextView(getApplicationContext());
			tv.setText(cais.get(position).toString());
			return tv;
		}
		
	}

	
	
}
