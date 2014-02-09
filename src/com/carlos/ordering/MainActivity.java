package com.carlos.ordering;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.carlos.ordering.dao.CaiDao;
import com.carlos.ordering.domain.Cai;

public class MainActivity extends Activity {

	private TextView tv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.Hello);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void Initial(View view) {

		Date today = new Date();
		String publishDate = String.format("%tY-%tm-%td", today, today, today);
		Cai cai = new Cai("1", "白菜", "5斤", "4元", "推荐", publishDate);
		CaiDao dao = new CaiDao(this);
		dao.Add(cai);
	}

	public void FetchData(View view) {
		new Thread() {
			public void run() {
				// http://www.szncpzx.com/todayprice.aspx
				try {
					Document doc = Jsoup.connect(
							"http://www.szncpzx.com/todayprice.aspx").get();

					for (Element tableElement : doc.getElementsByTag("table")) {

						// Element tableElement =
						// doc.getElementsByTag("table").get(4);

						String publishDate = null;

						Element titleElement = tableElement.getElementsByTag(
								"tr").first();
						String title = titleElement.text();
						Pattern titlePattern = Pattern.compile(
								"[0-9]+-[0-9]+-[0-9]+订购清单",
								Pattern.CASE_INSENSITIVE);
						// 2014-1-28订购清单

						// 订购清单

						Matcher matcher = titlePattern.matcher(title);
						if (matcher.matches()) {
							Pattern datePattern = Pattern.compile(
									"[0-9]+-[0-9]+-[0-9]+",
									Pattern.CASE_INSENSITIVE);
							matcher = datePattern.matcher(title);
							Boolean found = matcher.find();
							CaiDao dao = new CaiDao(MainActivity.this);
							if (found) {
								publishDate = matcher.group(0);
								// System.out.println(publishDate);
								found = dao.GetCountbyDate(publishDate) > 0 ? true
										: false;
								if (!found) {
									Element trElement = titleElement
											.nextElementSibling()
											.nextElementSibling();
									while (trElement != null) {
										Elements tdElements = trElement
												.getElementsByTag("td");
										if (tdElements.size() > 1) {
											Cai cai = new Cai(tdElements.get(0)
													.text(), tdElements.get(1)
													.text(), tdElements.get(2)
													.text(), tdElements.get(3)
													.text(), "N", publishDate);
											dao.Add(cai);
										}
										trElement = trElement
												.nextElementSibling();
									}
								} else {
									System.out
											.println("no update data available");
								}
							} else {
								System.out.println("publish date not found");
							}
						}

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			};
		}.start();
	}

	public void ListCai(View view) {
		Intent intent = new Intent();
		intent.setClassName(this, "com.carlos.ordering.ViewCaiActivity");
		startActivity(intent);
	}
	
	public void FetchPage(View view) {
		// AsyncHttpClient client = new AsyncHttpClient();
		//
		// client.get("http://www.google.com", new AsyncHttpResponseHandler() {
		// // @Override
		// // public void onSuccess(String response) {
		// // System.out.println(response);
		// // }
		//
		// @Override
		// public void onSuccess(int statusCode, Header[] headers,
		// byte[] responseBody) {
		// // TODO Auto-generated method stub
		// String source = new String(responseBody);
		// tv.setText(Html.fromHtml(source));
		// // Html.fromHtml(source);
		// // Log.i("Tag",responseBody);
		// }
		//
		// @Override
		// public void onFailure(int statusCode, Header[] headers,
		// byte[] responseBody, Throwable error) {
		// // TODO Auto-generated method stub
		//
		// }
		// });

	}

}
