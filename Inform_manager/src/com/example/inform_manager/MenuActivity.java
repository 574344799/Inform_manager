package com.example.inform_manager;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MenuActivity extends Activity{
	private SlidingMenu mMenu;
	private long mExitTime;				//关闭程序计时2秒
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mMenu = (SlidingMenu) findViewById(R.id.id_menu);

	}

	public void toggleMenu(View view) {
		mMenu.toggle();
	}

	
	
//	  双击返回键退出程序
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		// TODO 自动生成的方法存根
		//若点击的键 == 返回键
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			if(SlidingMenu.isOpen){
				mMenu.toggle();
			}
			
			else if ((System.currentTimeMillis() - mExitTime) > 2000) 
			{
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();
			}
			else
			{
				finish();
			}
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}

}
