package com.example.viewpagerbroswer;

import cn.bmob.v3.BmobObject;

public class websiteinfo extends BmobObject {
	private String name;
	private String url;
	private String ownnername;
	private String keyword;
	private String tags;
	private String owneremail;
	private String flags;
	private String kind;
	private int begin; // 书签记录页面的结束点位置
	private int count;
	private String time;
	private String bookPath;

	public websiteinfo(String name, String url, int count, int begin, String time,
			String bookPath) {
		super();
		this.name = name;
		this.url = url;
		this.count = count;
		this.time = time;
		this.bookPath = bookPath;
		this.begin = begin;
	}
	public websiteinfo()
	{
	}
	public String getowneremail() {
		return owneremail;
	}

	public void setowneremail(String owneremail) {
		this.owneremail = owneremail;
	}
	public String getflags() {
		return flags;
	}

	public void setflags(String flags) {
		this.flags = flags;
	}
	public String getkind() {
		return kind;
	}

	public void setkind(String kind) {
		this.kind = kind;
	}
	
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public String getkeyword() {
		return keyword;
	}

	public void setkeyword(String keyword) {
		this.keyword = keyword;
	}
	public String gettags() {
		return tags;
	}

	public void settags(String tags) {
		this.tags = tags;
	}
	public String getownnername() {
		return ownnername;
	}

	public void setownnername(String ownnername) {
		this.ownnername = ownnername;
	}

	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
	}

	public long getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBookPath() {
		return bookPath;
	}

	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}





}
