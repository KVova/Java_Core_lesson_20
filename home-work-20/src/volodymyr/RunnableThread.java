package volodymyr;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.sampled.ReverbType;

public class RunnableThread implements Runnable{

	private int delay;

	public RunnableThread(int delay) {
			super();
			this.delay = delay;
		}



	@Override
	public void run() {

		Scanner scan = new Scanner(System.in);
			
		System.out.println("Enter the quantity of numbers Fibonacci: ");
		int number = scan.nextInt();
			
		System.out.println("Fibonacci runnable: ");
		
//		int[]f = new int [number];
//		f[0] = 0;
//		f[1] = 1;
//		for(int i = 2; i < number + 1; ++i) {
//			f[i] = f[i -1] + f[i - 2];
//		}
//		for(int i = number; i >0; --i) {
//			System.out.print(f[i]);
		
		String collect = Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0]+t[1]})
				.limit(number)
				.map(t -> t[0])
				.map(String::valueOf)
				.collect(Collectors.joining(" "));
			
			String collectReverse = new StringBuffer(collect).reverse().toString();
			System.out.println(collectReverse);
		
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
//}