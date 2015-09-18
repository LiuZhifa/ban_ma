package com.itboye.banma.activities;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.itboye.banma.R;
public class LoginActivity extends Activity {
	TextView tvRegist;//ע��view
	Button btnLogin;//��½��ť
	RequestQueue requestQueue;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initId(this);
		tvRegist.setOnClickListener(new RegistListener());
		btnLogin.setOnClickListener(new LoginListener());
	}
	private void initId(LoginActivity loginActivity) {
		// TODO Auto-generated method stub
		tvRegist=(TextView)findViewById(R.id.tv_regist);
		btnLogin=(Button)findViewById(R.id.btn_login);
	}
	
	//���ּ���
	class LoginListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 requestQueue = Volley.newRequestQueue(LoginActivity.this);
			String urlString= "http://banma.itboye.com/api.php/Token/index";
			JSONObject jsonObject=new JSONObject();
			try {
				jsonObject.put("client_secret", "aedd16f80c192661016eebe3ac35a6e7");
				jsonObject.put("grant_type", "client_credentials");  
				jsonObject.put("client_id", "by559a8de1c325c1");
				Log.v("gsonת���ɹ�", "�ɹ�");
				System.out.println("java--->json \n" + jsonObject.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			Map<String, String> map = new HashMap<String, String>();  
//			map.put("grant_type", "client_credentials");  
//			map.put("client_id", "by55bec42a8e5431");  
//			map.put("client_secret", "aedd16f80c192661016eebe3ac35a6e7");
//			JSONObject jsonObject = new JSONObject(map);
			JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Method.POST,urlString, jsonObject,
			    new Response.Listener<JSONObject>() {
			        @Override
			        public void onResponse(JSONObject response) {
			            Log.d("token����", "response -> " + response.toString());
			            try {
							
							JSONObject data= response.getJSONObject("data");
							 Log.d("token����", data.getString("access_token"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			    }, new Response.ErrorListener() {
			        @Override
			        public void onErrorResponse(VolleyError error) {
			            Log.e("token����", error.getMessage(), error);
			    }
			    })
			    {
			    //ע��˴�override��getParams()����,�ڴ˴�����post��Ҫ�ύ�Ĳ���������������
			    //��������������,����JSONObject����ʵ�δ���JsonObjectRequest������
			    //������������ڴ˴��ǲ���Ҫ��
//			    @Override
//			    protected Map<String, String> getParams() {                
//			          Map<String, String> map = new HashMap<String, String>();  
//			            map.put("name1", "value1");  
//			            map.put("name2", "value2");  
			                 
//			        return params;
//			    }
			//    @Override
//			    public Map<String, String> getHeaders() {
//			        HashMap<String, String> headers = new HashMap<String, String>();
//			        headers.put("Accept", "application/json");
//			        headers.put("Content-Type", "application/json; charset=UTF-8");
//			        return headers;
//			    }
			};
			requestQueue.add(jsonRequest);
		}
		
	}
	
	class RegistListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intentRegist=new Intent(LoginActivity.this,RegistActivity.class);
			LoginActivity.this.startActivity(intentRegist);
		}
	}
}
