package com.example.inform_manager;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private long mExitTime;				//关闭程序计时2秒
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		
		Button btn_back = (Button) findViewById(R.id.back_btn);
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
				RegisterActivity.this.finish();
				startActivity(intent);	
			}
		});
	}
	
	
//	  双击返回键退出程序
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		// TODO 自动生成的方法存根
		//若点击的键 == 返回键
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			if ((System.currentTimeMillis() - mExitTime) > 2000) 
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
