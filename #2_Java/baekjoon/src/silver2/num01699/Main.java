package silver2.num01699;

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
		
		// parseInt() 및 readLine() 메서드를 사용해 입력 받은 자연수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 각 숫자의 제곱수 항의 최소 개수를 저장할 배열 minTerm 초기화
		int[] minTerm = new int[number + 1];
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int idx = 1; idx <= number; idx++) {
			
			// 해당 자연수의 제곱수 항의 최소 개수를 초기화
			minTerm[idx] = idx;
			
			// for 반복문을 사용해 각 제곱수 항을 순회
			for (int square = 1; square * square <= idx; square++) {
				
				// 해당 제곱 수를 변수 squareNum에 할당
				int squareNum = square * square;
				
				// min() 메서드를 사용해 제곱수 항의 최소 개수를 갱신
				minTerm[idx] = Math.min(minTerm[idx - squareNum] + 1, minTerm[idx]);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 자연수의 제곱수 항의 최소 개수를 출력
		out.write(String.valueOf(minTerm[number]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}