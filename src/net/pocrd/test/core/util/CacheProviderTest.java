package net.pocrd.test.core.util;

import net.pocrd.test.core.util.DemoDao.Test;
import net.pocrd.util.CacheProvider;

public class CacheProviderTest extends Thread {
	private String name;

	public CacheProviderTest(String name) {
		this.name = "Threa" + name;
	}

	@SuppressWarnings("unchecked")
	public void run() {
		for (int j = 0; j < 10; j++) {
			long start = System.currentTimeMillis();
			DemoDao<?> d = CacheProvider.getSingleton(DemoDao.class);
			int[] i = new int[2];
			d.getDemoEntity(i, null, Test.a, 0);
			d.getDemoEntity(0);
			d.getDemoEntity(0, 0);
			d.getDemoEntity(0, null, true, (byte) 0, (short) 0, '0', 0, 0, 0);
			d.getDemoEntity(null);
			System.out.println(this.name + " DemoDao: " + j + " cost time:"
					+ (System.currentTimeMillis() - start));
		}
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, Exception {
		CacheProviderTest[] thread = new CacheProviderTest[5];
		thread[0] = new CacheProviderTest("1");
		thread[1] = new CacheProviderTest("2");
		thread[2] = new CacheProviderTest("3");
		thread[3] = new CacheProviderTest("4");
		thread[4] = new CacheProviderTest("5");
		thread[0].start();
		thread[1].start();
		thread[2].start();
		thread[3].start();
		thread[4].start();
	}
}
