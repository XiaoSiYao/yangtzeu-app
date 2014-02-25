package com.rex.yuol.utils;

import java.util.Calendar;
import java.util.Date;

import android.text.format.Time;
import android.util.Log;

/**
 * ��Ϣʱ������
 * 
 * @author rex
 * 
 */
public class Timetable {
	Time client_now = new Time();

	public Timetable() {
		client_now.setToNow();
	}

	/**
	 * ʱ���
	 * @return
	 */
	public static long now() {
		return System.currentTimeMillis();
	}
	
	/**
	 * ��
	 * @return
	 */
	public static int year() {
		Timetable tt=new Timetable();
		return tt.client_now.YEAR;
	}
	
	/**
	 * ��
	 * @return
	 */
	public static int month() {
		Timetable tt=new Timetable();
		return tt.client_now.MONTH;
	}
	
	/**
	 * ��
	 * @return
	 */
	public static int day() {
		Timetable tt=new Timetable();
		return tt.client_now.monthDay;
	}
	
	/**
	 * ����
	 * @return
	 */
	public static int week() {
		Timetable tt=new Timetable();
		return tt.client_now.weekDay;
	}
	
	/**
	 * ʱ
	 * @return
	 */
	public static int hour() {
		Timetable tt=new Timetable();
		return tt.client_now.hour;
	}
	
	/**
	 * ��
	 * @return
	 */
	public static int minute() {
		Timetable tt=new Timetable();
		return tt.client_now.minute;
	}
	
	/**
	 * ��
	 * @return
	 */
	public static int second() {
		Timetable tt=new Timetable();
		return tt.client_now.second;
	}

	public static void test() {
		Timetable tt = new Timetable();

	}
}
