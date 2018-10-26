
public class MyClass extends Thread {
	private String name;
	private MyObject myObj;
	
	public MyClass(String n, MyObject obj) {
		name = n;
		myObj = obj;
	}
	
	@Override
	public void run() {
//		myObj.foo(name);
		if(name.equals("1")) {
			MyObject.foo1(name);
		}
		else if(name.equals("2")){
			MyObject.foo2(name);
		}
	}
	
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		MyClass class1 = new MyClass("1", obj1);
		MyClass class2 = new MyClass("2", obj1);
		class1.start();
		class2.start();
	}
}

class MyObject{
	public synchronized void foo(String name) {
		try {
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo(): ending");
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + ": interrupted.");
		}
	}
	
	public static synchronized void foo1(String name) {
		try {
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo(): ending");
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + ": interrupted.");
		}
	}
	
	public static synchronized void foo2(String name) {
		try {
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo(): ending");
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + ": interrupted.");
		}
	}
}
