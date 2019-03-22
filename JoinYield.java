public class JoinYield {
	public volatile static int i = 0;

	public static class myThread extends Thread {

		private String threadName;

		public String getThreadName() {
			return threadName;
		}

		public void setThreadName(String threadName) {
			this.threadName = threadName;
		}

		public myThread(String name) {
			// TODO Auto-generated constructor stub
			this.threadName = name;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// super.run();
			for (int j = 0; j <= 1000; j++) {
				i = j;
				System.out.println(this.getThreadName() + " => " + i);

				if (j % 5 == 0) {
					Thread.currentThread().yield(); // 让出资源
					// 或者直接 this.yield();
				}

			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		myThread t1 = new myThread("t1");
		myThread t2 = new myThread("#>t2");
		t1.start();
		t2.start();

		t1.join(); // wait() notifyAll()
		System.out.println("finished."); // 一定会在 t1 结束完才输出
	}

}
