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

	private long mExitTime;				//�رճ����ʱ2��
	
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
	
	
//	  ˫�����ؼ��˳�����
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		// TODO �Զ����ɵķ������
		//������ļ� == ���ؼ�
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			if ((System.currentTimeMillis() - mExitTime) > 2000) 
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
