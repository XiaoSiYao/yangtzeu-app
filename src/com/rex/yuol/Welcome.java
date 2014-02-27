package com.rex.yuol;

import java.util.Map;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.rex.yuol.config.Path;
import com.rex.yuol.config.Urls;
import com.rex.yuol.http.Net;
import com.rex.yuol.http.NetStateCheck;
import com.rex.yuol.regex.JwcRegex;
import com.rex.yuol.utils.Sql;
import com.rex.yuol.utils.Timetable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		final View view = View.inflate(this, R.layout.welcome, null);
		setContentView(view);
		// ����չʾ������
		AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
		aa.setDuration(2000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation arg0) {
				redirectTo();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationStart(Animation animation) {
			}

		});
	}

	/**
	 * ��ת��Mainҳ��
	 */
	private void redirectTo() {

		// ����
		NetStateCheck nsc = new NetStateCheck(this.getApplicationContext());
		nsc.check_jwc();
		nsc.check_library();
		// �ж��û���¼״̬
		Net.create_async_http(getApplicationContext()).get(Urls.jwc_cjcx_page,
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						try {
							if (JwcRegex.is_not_login(response)) {
								Sql.kv_set("login_state", "false");
							} else {
								Sql.kv_set("login_state", "true");
							}
							;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void onFailure(Throwable error, String content) {
						// TODO Auto-generated catch block
					}
				});
		Path.save_file(Path.testfile, "��Ĳ���");
		// ���Խ���

		Intent intent = new Intent(this, Main.class);
		startActivity(intent);
		finish();
	}

	/**
	 * �����¼�
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
