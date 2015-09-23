package com.example.viewpagerbroswer;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class Addnewsite extends ActionBarActivity {
Button  btn;
EditText  nameedit;
EditText  nameurl;
EditText  nametags;
EditText  nameownnrname;
EditText  nameemail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addnew);
		nameedit=(EditText)findViewById(R.id.sitename);
		nameurl=(EditText)findViewById(R.id.siteurl);
		nametags=(EditText)findViewById(R.id.tags);
		nameownnrname=(EditText)findViewById(R.id.siteownner);
		nameemail=(EditText)findViewById(R.id.ownemail);
		// 初始化 Bmob SDK
        // 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
        Bmob.initialize(this, "39dfc34280e39b5411c3e450466da0f2");
		btn=(Button)findViewById(R.id.okinput);
		btn.setOnClickListener(new OnClickListener() {
			 
		      @Override
		      public void onClick(View v) {
		        // TODO Auto-generated method stub
		       // Toast tst = Toast.makeText(TestButtonActivity.this, "222222222", Toast.LENGTH_SHORT);
		        //tst.show();
		    	  websiteinfo p2 = new websiteinfo();
		    	  p2.setname(nameedit.getText().toString());
		    	  p2.seturl(nameurl.getText().toString());
		    	p2.settags(nametags.getText().toString());
		    	p2.setownnername(nameownnrname.getText().toString());
		    	p2.setowneremail(nameemail.getText().toString());
		    	  p2.save(Addnewsite.this, new SaveListener() {
		    	      @Override
		    	      public void onSuccess() {
		    	    	  Toast tst = Toast.makeText(Addnewsite.this, "添加数据成功", Toast.LENGTH_SHORT);
		    	    	  tst.show();
		    	          // TODO Auto-generated method stub
		    	          //toast("添加数据成功，返回objectId为："+p2.getObjectId());
		    	      }

		    	      @Override
		    	      public void onFailure(int code, String msg) {
		    	          // TODO Auto-generated method stub
		    	         // toast("创建数据失败：" + msg);
		    	    	  Toast tst = Toast.makeText(Addnewsite.this, "添加数据失败", Toast.LENGTH_SHORT);
		    	    	  tst.show();
		    	      }
		    	  });
		      }
		    });

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		/*getMenuInflater().inflate(R.menu.addnewsite, menu);
		*/
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

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_addnewsite,
					container, false);
			return rootView;
		}
	}

}
