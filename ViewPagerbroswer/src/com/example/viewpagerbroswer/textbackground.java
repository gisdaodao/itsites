package com.example.viewpagerbroswer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class textbackground extends BaseAdapter {
	 private String[] texts = {"IT之家","cnbeta","界面网","果壳网","虎嗅","Techweb","stackoverflow","v2ex","segmentfault","安卓网","至顶网","速途网","chinaunix"};
	 private String[] urls = {"http://wap.ithome.com/","http://m.cnbeta.com/","http://m.jiemian.com/","http://m.guokr.com/","http://m.huxiu.com/","http://m.techweb.com.cn/","http://stackoverflow.com/","http://www.v2ex.com/","http://segmentfault.com/" ,"http://m.hiapk.com/" ,"http://m.zdnet.com.cn/","http://www.sootoo.com/","http://www.chinaunix.net/"};
	 private Context context;  
	
	 public textbackground(Context context) {  
	   this.context=context;  
	  } 

	//get the number  
	 @Override  
	 public int getCount() {  
	 return texts.length;  
	 }  
	 
 @Override  
	 public Object getItem(int position) {  
 return texts[position];  
	 }  
//get the current selector's id number  
@Override  
 public long getItemId(int position) {  
 return position;  
 } 

//create view method  
 @Override  
 public View getView(int position, View view, ViewGroup viewgroup) {  
  
   LayoutInflater inflater = LayoutInflater.from(context);  
   view = inflater.inflate(R.layout.textbakround, null);  
 TextView textview=(TextView)  view.findViewById(R.id.textView1);
 textview.setText(texts[position]);
 view.setTag(urls[position]);
 view.setPadding(10, 10, 10, 10);  //每格的间距
  return view;  
 }  
}  



