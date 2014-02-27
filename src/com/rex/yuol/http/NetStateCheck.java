package com.rex.yuol.http;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rex.yuol.utils.Sql;

public class NetStateCheck {
	private AsyncHttpClient client;

	public NetStateCheck(Context context) {
		client=Net.create_async_http(context);
	}

	public void check_inner_net() {
		this.check_library();
	}

	public void check_jwc() {
		// ����״̬
		client.get("http://jwc.yangtzeu.edu.cn:8080/login.aspx",
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						Sql.kv_set("jwc_state", "true");
					}

					@Override
					public void onFailure(Throwable error, String content) {
						Sql.kv_set("jwc_state", "false");
					}
				});
	}

	public void check_library() {
		// ��ȡͼ��ݵ�ǰ״̬
		client.get("http://10.203.1.110/enter.html",
				new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						Sql.kv_set("inner_net", "true");
						Sql.kv_set("library_state", "true");
					}

					@Override
					public void onFailure(Throwable error, String content) {
						Sql.kv_set("inner_net", "false");
						Sql.kv_set("library_state", "false");
					}
				});
	}
}
