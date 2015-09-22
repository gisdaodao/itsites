package com.example.viewurlrbroswer;

public class channel {


		private String text;
		private String url;
		private int begin; // 书签记录页面的结束点位置
		private int count;
		private String time;
		private String bookPath;

		public channel(String text, String url, int count, int begin, String time,
				String bookPath) {
			super();
			this.text = text;
			this.url = url;
			this.count = count;
			this.time = time;
			this.bookPath = bookPath;
			this.begin = begin;
		}
		public channel()
		{
		}
		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
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
