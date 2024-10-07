package silver1.num32160;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 차이가 1이 되도록 선택했을 때 1이 홀수 개 남는지 여부, 1과 1, 0과 0을 선택하는 횟수를 계산해 각 변수에 할당
		boolean isOdd = ((number / 2) & 1) == 1;
		int countOne = number / 4;
		int countZero = number / 4 - 1;
		
		// write() 메서드를 사용해 마지막에 남을 수 있는 가장 큰 정수를 출력
		out.write((isOdd) ? (number - 1) + "\n" : number + "\n");
		
		// for 반복문을 사용해 각 숫자의 차가 1이 되도록 차례로 숫자를 선택하는 방법을 출력
		for (int n = number - 1; n > 1; n -= 2)
			out.write(n + " " + (n - 1) + "\n");
		
		// while 반복문을 사용해 1과 1을 선택하는 횟수만큼의 방법을 출력
		while (countOne-- > 0)
			out.write(1 + " " + 1 + "\n");
		
		// while 반복문을 사용해 0과 0을 선택하는 횟수만큼의 방법을 출력
		while (countZero-- > 0)
			out.write(0 + " " + 0 + "\n");
		
		/* 가장 큰 정수가 3보다 크고, 차이가 1이 되도록 선택했을 때 1이 홀수 개 남는 경우
		1과 0을 한 번 선택하게 되므로 이를 출력 */
		if (number > 3 && isOdd)
			out.write(1 + " " + 0 + "\n");
		
		// write() 메서드를 사용해 마지막으로 가장 큰 수와 1 또는 0을 선택하는 방법을 출력
		out.write((isOdd) ? number + " " + 1 : number + " " + 0);	
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}