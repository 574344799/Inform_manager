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
	private long mExitTime;				//�رճ����ʱ2��
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

	
	
//	  ˫�����ؼ��˳�����
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		// TODO �Զ����ɵķ������
		//������ļ� == ���ؼ�
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			if(SlidingMenu.isOpen){
				mMenu.toggle();
			}
			
			else if ((System.currentTimeMillis() - mExitTime) > 2000) 
			{
				Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();
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
