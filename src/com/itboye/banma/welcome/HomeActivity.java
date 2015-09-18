package com.itboye.banma.welcome;

import com.itboye.banma.R;
import com.itboye.banma.activities.CenterActivity;
import com.itboye.banma.utils.SharedConfigs;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class HomeActivity extends Activity {
	Button btnEnter;//���������水ť
	Button btnClear;//������صĵ�һ�μ��صļ�¼
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		btnEnter=(Button)findViewById(R.id.btn_enter);
		btnClear=(Button) findViewById(R.id.btn_clear);
		
		btnClear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new SharedConfigs(getApplicationContext()).ClearConfig();
			}
		});
		btnEnter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(HomeActivity.this,CenterActivity.class));
			}
		});
	}
}
