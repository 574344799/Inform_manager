package com.example.inform_manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ForgetActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_forget);
		
		Button btn_back = (Button) findViewById(R.id.forget_back_btn);
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ForgetActivity.this,LoginActivity.class);
				ForgetActivity.this.finish();
				startActivity(intent);	
			}
		});
		
		final Button btn_sent = (Button) findViewById(R.id.forget_sent_btn);
		btn_sent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				btn_sent.setText("重新发送");
			}
		});
}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		// TODO 自动生成的方法存根
		//若点击的键 == 返回键
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			Intent intent = new Intent(ForgetActivity.this,LoginActivity.class);
			ForgetActivity.this.finish();
			startActivity(intent);
		}
		
		return super.onKeyDown(keyCode, event);
	}
}
