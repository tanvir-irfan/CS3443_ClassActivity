package edu.utsa.cs3443.lab1;

public class Window {
	// elegant way to represent the state properties.
	// however, not necessary as I didn't cover it in class.
	// public enum State {MAXIMIZED, MINIMIZED, RESTORED}
	
	public static final int MAXIMIZED = 0;
	public static final int MINIMIZED = MAXIMIZED + 1;
	public static final int RESTORED = MINIMIZED + 1;
	
	public static final int FULL_WIDTH = 800;
	public static final int FULL_HEIGHT = 600;
	
	private String name;
	private int left, top, height, width;
	private int state;
	
	public Window(String name) {
		this(name, 0, 0, 0, 0);
	}
	
	public Window(String name, int left, int top, int height, int width) {
		super();
		this.name = name;
//		this.left = left;
//		this.top = top;
		this.setPosition(left, top);
//		this.height = height;
//		this.width = width;
		this.setSize(width, height);
		
		this.state = MINIMIZED;
	}

	public void setSize(int w, int h) {
		// previous value is retained in case of invalid input
		this.width = w >= 0 ? w : this.width;
		this.height = h >= 0 ? h : this.height;
	}
	
	public void setPosition(int l, int t) {
		this.left = l;
		this.top = t;
	}
	
	public void moveBy (int x, int y) {
		this.left += x;
		this.top += y;
	}
	
	public void maximize() {
		this.state = MAXIMIZED;
	}
	
	public void minimize() {
		this.state = MINIMIZED;
	}
	
	public void restore() {
		this.state = RESTORED;
	}
	
	public void show() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.name).append(" ").append("is").append(" ");
		
		int l = this.left;
		int t = this.top;
		int w = this.width;
		int h = this.height;
		switch(this.state) {
		
		case MINIMIZED:
			sb.append("minimized.");
			return sb.toString();
		case MAXIMIZED:
			sb.append("maximized.");
			l = 0;
			t = 0;
			w = 800;
			h = 600;
			break;
		case RESTORED:
			sb.append("restored.");
			break;
			default:
				sb.append("in UNKNOWN state.");
		}
		
		sb.append(" ");
		
		String properties = String.format("[ l = %d, t = %d, w = %d, h = %d ]", l, t, w, h);
		
		sb.append(properties);
		
		return sb.toString();
	}
	/////////////////////////////////////////////////////////////////////////
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getLeft() {
		return left;
	}


	public void setLeft(int left) {
		this.left = left;
	}


	public int getTop() {
		return top;
	}


	public void setTop(int top) {
		this.top = top;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public static void main(String[] args) {
		Window w1 = new Window( "First" ) ;
		Window w2 = new Window( "Second" , 10 , 10 , 300 , 200 ) ;
		w2.show ( ) ;
		w1.restore();
		w1.show ( ) ;
		w2.maximize ( ) ;
		w2.setPosition(50 , 50) ;
		w2.setSize(100,  100);
		w2.show ( ) ;
		w2.restore();
		w2.show ( );
		w1.setPosition(100 , 10) ;
		w1.moveBy ( 5 , -5);
		w1.show ( ) ;
	}

}