package volodymyr;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyThread extends Thread{

	@Override
	public synchronized void run() {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the quantity of numbers Fibonacci: ");
		int number = scan.nextInt();
		
		System.out.println("Fibonacci thread: ");
//		int[]f = new int [number];
//		f[0] = 0;
//		f[1] = 1;
//		for(int i = 2; i < number + 1; ++i) {
//			f[i] = f[i -1] + f[i - 2];
//		}
		
//		for(int i = 0; i < number; i++) {
//			System.out.print(i);
		
		String collect = Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0]+t[1]})
				.limit(number)
				.map(t -> t[0])
				.map(String::valueOf)
				.collect(Collectors.joining(" "));
		System.out.println(collect);
		
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
