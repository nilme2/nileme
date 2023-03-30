package me.nilme.exercise.java.concurrent;

/**
 * @author ThrilleR 
 * 必须要加上 -server才能生效，因为在-server下程序运行速度很快做过优化，才会出现stop不了的情况。在Object上加上volatile就可见了。
 * 
 */
public class VolatileObjectTest implements Runnable {
	private volatile Object[] a; // 加上volatile 就可以正常结束While循环了

	public VolatileObjectTest(Object[] a) {
		this.a = a;
	}

	public Object[] getA() {
		return a;
	}

	public void setA(Object[] a) {
		this.a = a;
	}

	@Override
	public void run() {
		long i = 0;
		while ((boolean)a[1]) {
			i++;
		}
		System.out.println("stop My Thread " + i);
	}

	public void stop() {
		a[1] = false;
	}

	public static void main(String[] args) throws InterruptedException {
		 // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
		System.out.println(System.getProperty("java.vm.name"));
		Object[] a = new Object[10];
		a[1] = Boolean.TRUE;

		VolatileObjectTest test = new VolatileObjectTest(a);
		new Thread(test).start();

		Thread.sleep(1000);
		test.stop();
		Thread.sleep(1000);
		System.out.println("Main Thread " + test.getA()[1]);
	}

	static class ObjectA {
		private boolean flag = true;

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}

	}
}

