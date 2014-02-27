package com.rex.yuol.utils;

import java.util.Calendar;
import java.util.Date;

import com.rex.yuol.R;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

/**
 * ��Ϣʱ������
 * 
 * @author rex
 * 
 */
public class Timetable {
	Time client_now = new Time();
	private static int[] time_table = {
			// Morning
			73000, 80000, 93500, 100500, 114000,
			// Noon
			140000, 153500, 160500, 174000,
			// Night
			190000, 203500, 235900 };

	private static String[] timetable_tips = new String[] {
			// Morning
			"���Ϻ�", "8:00�ϵ�һ�ڿ�", "9:35�µ�һ�ڿ�", "10:05�ϵڶ��ڿ�", "11:40�µڶ��ڿ�",
			// Noon
			"14:00�ϵ����ڿ�", "15:35�µ����ڿ�", "16:05�ϵ��Ľڿ�", "17:40�µ��Ľڿ�",
			// Night
			"19:00������ϰ", "20:35������ϰ",
			//
			"��"

	};

	public Timetable() {
		client_now.setToNow();
	}

	/**
	 * ʱ���
	 * 
	 * @return
	 */
	public static long timestamp() {
		return System.currentTimeMillis();
	}

	/**
	 * ��
	 * 
	 * @return
	 */
	public static int year() {
		Timetable tt = new Timetable();
		return tt.client_now.YEAR;
	}

	/**
	 * ��
	 * 
	 * @return
	 */
	public static int month() {
		Timetable tt = new Timetable();
		return tt.client_now.MONTH;
	}

	/**
	 * ��
	 * 
	 * @return
	 */
	public static int day() {
		Timetable tt = new Timetable();
		return tt.client_now.monthDay;
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public static int week() {
		Timetable tt = new Timetable();
		return tt.client_now.weekDay;
	}

	/**
	 * ʱ[24Сʱ��]
	 * 
	 * @return
	 */
	public static int hour() {
		Timetable tt = new Timetable();
		return tt.client_now.hour;
	}

	/**
	 * ��
	 * 
	 * @return
	 */
	public static int minute() {
		Timetable tt = new Timetable();
		return tt.client_now.minute;
	}

	/**
	 * ��
	 * 
	 * @return
	 */
	public static int second() {
		Timetable tt = new Timetable();
		return tt.client_now.second;
	}

	/**
	 * ��ǰ�Ͽ�״̬
	 * 
	 * @return
	 */
	public static String now_state() {
		String tip = "";
		int now = Timetable.hour() * 10000 + Timetable.minute() * 100
				+ Timetable.second();
		for (int i = 0; i < time_table.length; ++i) {
			if (time_table[i] > now) {
				tip = timetable_tips[i];
				break;
			}
		}
		return tip;
	}

	public static void test() {
		// Timetable tt = new Timetable();
		Log.i("welcome", "hour:" + Timetable.hour());
	}
}
