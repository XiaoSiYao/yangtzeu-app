package com.rex.yuol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class News extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);

		String[] news_cata_items = this.getResources().getStringArray(
				R.array.news);

		List<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < news_cata_items.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list_item_title", news_cata_items[i]);
			map.put("list_item_title_notice", "");
			contents.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, contents,
				R.layout.news_cata_item,
				new String[] { "list_item_title", "list_item_title_notice" }, new int[] {
						R.id.list_item_title, R.id.list_item_title_notice });

		ListView listview = (ListView) findViewById(R.id.news_cata_list);
		listview.setAdapter(adapter);
	}

	/**
	 * �����¼�
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// ���˶���
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			overridePendingTransition(R.anim.back_left_in,
					R.anim.back_right_out);

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
