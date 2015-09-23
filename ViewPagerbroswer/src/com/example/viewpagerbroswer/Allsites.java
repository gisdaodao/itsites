package com.example.viewpagerbroswer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.viewurlrbroswer.channel;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class Allsites extends ActionBarActivity {
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_allsites);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.allsites, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		 private ListView navList;
		 private Context mcon;
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_allsites,
					container, false);
			 navList=(ListView)rootView.findViewById(R.id.listView1);
		        
		       
		      
			BmobQuery<websiteinfo> query = new BmobQuery<websiteinfo>();
			//��ѯplayerName�С���Ŀ��������
			//query.addWhereEqualTo("playerName", "��Ŀ");
			//����50�����ݣ����������������䣬Ĭ�Ϸ���10������
			query.setLimit(100);
			mcon=this.getActivity();
			//ִ�в�ѯ����
			query.findObjects(this.getActivity(), new FindListener<websiteinfo>() {
			        @Override
			        public void onSuccess(List<websiteinfo> object) {
			            // TODO Auto-generated method stub
			          //  toast("��ѯ�ɹ�����"+object.size()+"�����ݡ�");
			        	  initListView(object);
			           
			        }
			        private void initListView(List<websiteinfo> object) {
						// TODO Auto-generated method stub
			        	  final ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,     Object>>();/*�������д������*/
			        	  for (websiteinfo book1 : object) {  
			                  Log.i("kkkkdddd", book1.toString());  
			                  HashMap<String, Object> map = new HashMap<String, Object>();  
			                  
			                  map.put("texts", book1.getname());  
			                  map.put("urls", book1.geturl());  
			                  listItem.add(map);  
			              } 
			              
			            
			              SimpleAdapter adapter = new SimpleAdapter(mcon,listItem,android.R.layout.simple_list_item_2,new String[]{"texts","urls"},new int[]{android.R.id.text1,android.R.id.text2}); 

			              navList.setAdapter(adapter);//ΪL
			              navList.setOnItemClickListener(new OnItemClickListener() {
					        	@Override

					        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,

					        	long arg3) {
					        		HashMap<String,Object> str=listItem.get(arg2);
					        		Object obj=  str.get("texts");
					        		String url=(String) str.get("urls");
					        		Intent iintent = new Intent();
					        		iintent.setAction("android.intent.action.VIEW");
					        		Uri content_url = Uri.parse(url);
					        		iintent.setData(content_url);
					        		startActivity(iintent);
					        	}
					     
					        }
					        );
			        	/* for (websiteinfo gameScore : object) {
				               //���playerName����Ϣ
				            
				            }*/
					}
					@Override
			        public void onError(int code, String msg) {
			            // TODO Auto-generated method stub
			            //toast("��ѯʧ�ܣ�"+msg);
			        }
			});
			return rootView;
		}
	}

}
