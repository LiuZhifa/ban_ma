package com.itboye.banma.activities;

import com.itboye.banma.R;
import com.itboye.banma.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegistActivity extends Activity {
private 	Button btnNextStep;//��һ����ť
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_regist);
	       initId(this);
	       btnNextStep.setOnClickListener(nextClickListener);
	    }

	private void initId(RegistActivity registActivity) {
		// TODO Auto-generated method stub
		btnNextStep=(Button)findViewById(R.id.btn_next_step);
	}
	
	//���ּ���
	private OnClickListener nextClickListener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent nextIntent=new Intent(RegistActivity.this,RegsitedActivity.class);
				startActivity(nextIntent);
		}
	};
}

