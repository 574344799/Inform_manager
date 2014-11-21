package com.example.inform_manager;

import java.io.File;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.inform_manager.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;


public class LoginActivity extends Activity {
	private ImageLoader mImageLoader;
	private long mExitTime;				//�رճ����ʱ2��
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		
		mImageLoader = initImageLoader(this, mImageLoader, "test");   //testΪ����ͼƬ���ļ���
		RoundImageView networkImage = (RoundImageView) findViewById(R.id.roundImage_two_border);
//		RoundImageView twoBorderImage = (RoundImageView) findViewById(R.id.roundImage_two_border);
		mImageLoader
		.displayImage("http://c.hiphotos.baidu.com/image/w%3D2048/sign=744a86ae0d3387449cc5287c6537d8f9/ac345982b2b7d0a28e9adc63caef76094a369af9.jpg",
				networkImage);
//		twoBorderImage.setImageResource(R.drawable.girl);
		
		//ע�ᰴť��ת
		Button btn_register = (Button) findViewById(R.id.btn_register);
		btn_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
				LoginActivity.this.finish();
				startActivity(intent);				
				
			}
		});

		//�������밴ť��ת
		Button btn_forget = (Button) findViewById(R.id.btn_forgetpsw);
		btn_forget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(LoginActivity.this,ForgetActivity.class);
				LoginActivity.this.finish();
				startActivity(intent);				
				
			}
		});
		
		//��¼��ť��ת
		Button btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
				LoginActivity.this.finish();
				startActivity(intent);				
				
			}
		});
		
	}

	/**
	 * ��ʼ��ͼƬ��������ͼƬ�����ַ<i>("/Android/data/[app_package_name]/cache/dirName")</i>
	 */
	public ImageLoader initImageLoader(Context context,
			ImageLoader imageLoader, String dirName) {
		imageLoader = ImageLoader.getInstance();
		if (imageLoader.isInited()) {
			// ���³�ʼ��ImageLoaderʱ,��Ҫ�ͷ���Դ.
			imageLoader.destroy();
		}
		imageLoader.init(initImageLoaderConfig(context, dirName));
		return imageLoader;
	}

	/**
	 * ����ͼƬ������
	 * 
	 * @param dirName
	 *            �ļ���
	 */
	private ImageLoaderConfiguration initImageLoaderConfig(Context context,
			String dirName) {
		
		DisplayImageOptions   options = new DisplayImageOptions.Builder()  
        .cacheInMemory(true)                        // �������ص�ͼƬ�Ƿ񻺴����ڴ���  
        .cacheOnDisc(true)                          // �������ص�ͼƬ�Ƿ񻺴���SD����  
        .build();                                   // �������ù���DisplayImageOption
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.threadPoolSize(3).memoryCacheSize(getMemoryCacheSize(context))
				.denyCacheImageMultipleSizesInMemory()
				.defaultDisplayImageOptions(options)    //�򿪻������
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.discCache(new UnlimitedDiscCache(new File(dirName)))
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();
		return config;
	}

	private int getMemoryCacheSize(Context context) {
		int memoryCacheSize;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
			int memClass = ((ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE))
					.getMemoryClass();
			memoryCacheSize = (memClass / 8) * 1024 * 1024; // 1/8 of app memory
															// limit
		} else {
			memoryCacheSize = 2 * 1024 * 1024;
		}
		return memoryCacheSize;
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
