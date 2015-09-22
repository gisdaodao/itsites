package com.example.viewpagerbroswer;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.example.viewurlrbroswer.channel;

import org.xmlpull.v1.XmlPullParser;  
import org.xmlpull.v1.XmlSerializer;  
  




















import android.util.Xml;

public class MainActivity extends ActionBarActivity {
	 private String[] tabs=new String[]{"��ʵ��"};
	 private DrawerLayout drawerLayout;
	    private ActionBarDrawerToggle toggle;
	    private ListView navList;
	    private FragmentManager fm;
	    private GridView mgrid;
	    private List<Fragment> fragments;
	    private ArrayAdapter<String> adapter;
    private List<View> viewList;
    private List<String> stringList;
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    ListView mListView = null;  
    WebView webview=null;
    List<channel> fullresultlist;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewList=new ArrayList<View>();
        stringList=new ArrayList<String>();
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navList=(ListView)findViewById(R.id.left_drawer);
        
      //  navList.setOnItemClickListener(this);
        initListView();
      
        initDrawerLayout();
        //��ȡview
        View view1=View.inflate(this,R.layout.view1,null);
        View view2=View.inflate(this,R.layout.view2,null);
        View view3=View.inflate(this,R.layout.view3,null);
        View view4=View.inflate(this,R.layout.view4,null);
        mListView=(ListView)view1.findViewById(R.id.listView1);
        webview=(WebView)view2.findViewById(R.id.webview);
        mgrid=(GridView)view3.findViewById(R.id.gridView1);
        mgrid.setOnItemClickListener(new OnItemClickListener() {

        	@Override

        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,

        	long arg3) {
        	   //arg1�ǵ�ǰitem��view��ͨ�������Ի�ø����еĸ�������� 
        	    //arg2�ǵ�ǰitem��ID�����id���������������е�д�������Լ����塣 
        	    //arg3�ǵ�ǰ��item��listView�е����λ�ã� 
View view=(View)arg1;
String str=(String)view.getTag();
Intent iintent = new Intent();
iintent.setAction("android.intent.action.VIEW");
Uri content_url = Uri.parse(str);
iintent.setData(content_url);
startActivity(iintent);

        

        	                 

        	}

        	});
        mgrid.setAdapter(new textbackground(this));
        //��ȡViewPager��ͼ
        viewPager=(ViewPager)findViewById(R.id.pager);
        //��view��ӵ�viewList��
     
        webview.loadUrl("http://gisdaodao.github.io/itsites/");
        WebSettings setting = webview.getSettings();  
        setting.setJavaScriptEnabled(true);//֧��js  
        setting.setDefaultTextEncodingName("GBK");//�����ַ�����  
        webview.setScrollBarStyle(0);//���������Ϊ0ָ��������ռ�ÿռ䣬ֱ�Ӹ�������ҳ�� 
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        //���ҳ������
        stringList.add("ͨ��");
        stringList.add("����Ա");
        stringList.add("�Ƽ�");
      stringList.add("english");
        //ʵ����pagerAdapter
        SnailPagerAdapter pagerAdapter=new SnailPagerAdapter(viewList,stringList);
      
        viewPager.setAdapter(pagerAdapter);

        pagerTabStrip=(PagerTabStrip)findViewById(R.id.tab);
        //pagerTabStrip.setDrawFullUnderline(false);


        //����pagerAdapter
      

        
try{
        DownloadFilesTask download=new DownloadFilesTask();
        String path="http://files.cnblogs.com/files/gisbeginner/recommendwebsite.xml";
       URL urol=new URL(path);
   download.execute(urol);
}
catch(Exception e)
{
	
}
 finally {
 
}

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // TODO Auto-generated method stub

        if (((keyCode == KeyEvent.KEYCODE_BACK) ||

(keyCode == KeyEvent.KEYCODE_HOME))

&& event.getRepeatCount() == 0) {

               dialog_Exit(MainActivity.this);

        }

        return false;

       

        //end onKeyDown

 }



 public static void dialog_Exit(Context context) {

  AlertDialog.Builder builder = new Builder(context);

  builder.setMessage("ȷ��Ҫ�˳���?");

  builder.setTitle("��ʾ");

  builder.setIcon(android.R.drawable.ic_dialog_alert);

  builder.setPositiveButton("ȷ��",

          new DialogInterface.OnClickListener() {

              public void onClick(DialogInterface dialog, int which) {

                  dialog.dismiss();

                  android.os.Process.killProcess(android.os.Process

                          .myPid());

              }

          });

 

  builder.setNegativeButton("ȡ��",

          new android.content.DialogInterface.OnClickListener() {

              public void onClick(DialogInterface dialog, int which) {

                  dialog.dismiss();

              }

          });

 

  builder.create().show();

}

    private void initDrawerLayout(){
        toggle=new ActionBarDrawerToggle(this, drawerLayout, 
                R.drawable.ic_launcher, R.string.app_name,
                R.string.app_name){
                    /** ��drawer������ȫ�رյ�״̬ʱ���� */
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }
                       /** ��drawer������ȫ�򿪵�״̬ʱ���� */
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }
            
        };
        // ����drawer������ΪDrawerListener
        drawerLayout.setDrawerListener(toggle);
    }
    /**
    ��ʼ��drawer��item�б���Ҫ�������app��������������һ��navigation drawerͨ����һ��ListView��ɣ������б�Ӧ��ͨ��һ��Adapter���롣
*/
    private void initListView(){
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                tabs);
        navList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.suilan) {
//        	listView1.
        	this.mListView.getAdapter().getCount();
        int j=	(int) (Math.random() * this.mListView.getAdapter().getCount());
        Object objiu=this.mListView.getAdapter().getItem(j);
        HashMap<String,Object> str=( HashMap<String,Object>)objiu;
        Object obj=  str.get("texts");
        String url=(String) str.get("urls");
      
        	Intent iintent = new Intent();
        	iintent.setAction("android.intent.action.VIEW");
        	Uri content_url = Uri.parse(url);
        	iintent.setData(content_url);
        	startActivity(iintent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public class SAXPraserHelper extends DefaultHandler {

        final int ITEM = 0x0005;
        private String tagName; 
        List<channel> list;
        channel chann;
        int currentState = 0;

        public List<channel> getList() {
            return list;
        }

        /*
         * �ӿ��ַ���֪ͨ
    */
        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // TODO Auto-generated method stub
    // super.characters(ch, start, length);
            String theString = String.valueOf(ch, start, length);
            Log.e("SAXXmlContentHandler", "��ȡ��ǩ");  
             
               if(this.tagName.equals("item")){  
            	  
            	//   chann.setText(text);;  
               }  
               else if(this.tagName.equals("url"))
               {
            	   chann.seturl(theString);
               }
               else
               {
            	   
               }
           /* if (currentState != 0) {
                chann.setText(theString);
                currentState = 0;
            }*/
            return;
        }

        /*
         * �����ĵ�����֪ͨ
    */
        @Override
        public void endDocument() throws SAXException {
            // TODO Auto-generated method stub
            super.endDocument();
        }

        /*
         * ���ձ�ǩ����֪ͨ
    */
        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // TODO Auto-generated method stub
            if (localName.equals("item"))
                list.add(chann);
        }

        /*
         * �ĵ���ʼ֪ͨ
    */
        @Override
        public void startDocument() throws SAXException {
            // TODO Auto-generated method stub
            list = new ArrayList<channel>();
        }

        /*
         * ��ǩ��ʼ֪ͨ
    */
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            // TODO Auto-generated method stub
            chann = new channel();
            if (localName.equals("item")) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    if (attributes.getLocalName(i).equals("text")) {
                       chann.setText(attributes.getValue(i));
                    } else if (attributes.getLocalName(i).equals("url")) {
                        chann.seturl(attributes.getValue(i));
                    }
                }
                currentState = ITEM;
                return;
            }
            currentState = 0;
            return;
        }
    }
    private class DownloadFilesTask extends AsyncTask<URL, Integer, List<channel>> {
        protected List<channel> doInBackground(URL... urls) {
            long totalSize = 0;
          List<channel> resultlist=new ArrayList<channel>();
            
            try {
            	HttpURLConnection urlConnection = (HttpURLConnection) urls[0].openConnection();
              InputStream in = new BufferedInputStream(urlConnection.getInputStream());
              resultlist=   readStream(in);
              fullresultlist=readStream(in);
              urlConnection.disconnect();
            }
            catch(Exception e)
            {
            	
            }
             finally {
             
            }
            return resultlist;
        }

        private List<channel> readStream(InputStream in)throws Exception{
			// TODO Auto-generated method stub
        	//ʵ����һ��SAXParserFactory����
          /*  SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser;
            //ʵ����SAXParser���󣬴���XMLReader���󣬽�����
            parser=factory.newSAXParser();
            XMLReader xmlReader=parser.getXMLReader();
            //ʵ����handler���¼�������
            SAXPraserHelper helperHandler=new SAXPraserHelper();
            //������ע���¼�
            xmlReader.setContentHandler(helperHandler);
            //��ȡ�ļ���
           // InputStream stream=getResources().openRawResource(R.raw.channels);
            InputSource is=new InputSource(in);
            //�����ļ�
            xmlReader.parse(is);
            List<channel>  results=helperHandler.getList();
            Log.d("gg",Integer.toString(results.size()));
            return helperHandler.getList();*/
        	List<channel> books = null;  
        	channel book = null;  
              
//          XmlPullParserFactory factory = XmlPullParserFactory.newInstance();  
//          XmlPullParser parser = factory.newPullParser();  
              
            XmlPullParser parser = Xml.newPullParser(); //��android.util.Xml����һ��XmlPullParserʵ��  
            parser.setInput(in, "UTF-8");               //���������� ��ָ�����뷽ʽ  
      
            int eventType = parser.getEventType();  
            while (eventType != XmlPullParser.END_DOCUMENT) {  
                switch (eventType) {  
                case XmlPullParser.START_DOCUMENT:  
                    books = new ArrayList<channel>();  
                    break;  
                case XmlPullParser.START_TAG:  
                    if (parser.getName().equals("item")) {  
                        book = new channel();  
                        book.setText(parser.getAttributeValue(null, "text"));
                    } else if (parser.getName().equals("text")) {  
                        eventType = parser.next();  
                        book.setText(parser.getText());  
                    } else if (parser.getName().equals("url")) {  
                        eventType = parser.next();  
                        book.seturl(parser.getText());
                    } 
                    break;  
                case XmlPullParser.END_TAG:  
                    if (parser.getName().equals("item")) {  
                        books.add(book);  
                        book = null;      
                    }  
                    break;  
                }  
                eventType = parser.next();  
            }  
           
           
          
            return books;  
		}

		protected void onProgressUpdate(Integer... progress) {
           
        }

		/**  
	     * �����String������ӦAsyncTask�еĵ�����������Ҳ���ǽ���doInBackground�ķ���ֵ��  
	     * ��doInBackground����ִ�н���֮�������У�����������UI�̵߳��� ���Զ�UI�ռ��������  
	     */  
	   @Override  
	    protected void onPostExecute(List<channel> result) {  
	       // textView.setText("�첽����ִ�н���" + result);  
		   super.onPostExecute(result);
		   final ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,     Object>>();/*�������д������*/
           for (channel book1 : result) {  
               Log.i("kkkkdddd", book1.toString());  
               HashMap<String, Object> map = new HashMap<String, Object>();  
               
               map.put("texts", book1.getText());  
               map.put("urls", book1.geturl());  
               listItem.add(map);  
           } 
           
         
           SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,listItem,android.R.layout.simple_list_item_2,new String[]{"texts","urls"},new int[]{android.R.id.text1,android.R.id.text2}); 

           mListView.setAdapter(adapter);//ΪListView�������� lv.setOnItemClickListener(new 
           mListView.setOnItemClickListener (new OnItemClickListener(){
        	            @Override
        	            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        	            {

        	                // TODO Auto-generated method stub
HashMap<String,Object> str=listItem.get(arg2);
Object obj=  str.get("texts");
String url=(String) str.get("urls");
Intent iintent = new Intent();
iintent.setAction("android.intent.action.VIEW");
Uri content_url = Uri.parse(url);
iintent.setData(content_url);
startActivity(iintent);

        	                /*if(listItem.get(arg2).equals("LinearLayout"))

        	                {

        	                    Intent tintent = new Intent("com.wps.android.LINEARLAYOUT");

        	                    startActivity(tintent);

        	                }

        	                if(listItem.get(arg2).equals("AbsoluteLayout"))

        	                {

        	                    Intent intent = new Intent("com.wps.android.ABSOLUTELAYOUT");

        	                    startActivity(intent);

        	                }

        	                if(listItem.get(arg2).equals("TableLayout"))

        	                {

        	                    Intent intent = new Intent("com.wps.android.TABLELAYOUT");

        	                    startActivity(intent);

        	                }

        	                if(listItem.get(arg2).equals("RelativeLayout"))

        	                {

        	                    Intent intent = new Intent("com.wps.android.RELATIVELAYOUT");

        	                    startActivity(intent);

        	                }

        	                if(listItem.get(arg2).equals("FrameLayout"))

        	                {

        	                    Intent intent = new Intent("com.wps.android.FRAMELAYOUT");

        	                    startActivity(intent);

        	                }

        	         

        	             
*/
        	            }
        	        });
	    }  

		private void showDialog(String string) {
			// TODO Auto-generated method stub
			
		}
    }
}
