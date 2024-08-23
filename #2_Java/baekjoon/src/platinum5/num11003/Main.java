package platinum5.num11003;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Number 클래스 정의
	static class Number {
		
		// 해당 숫자의 입력 순서와 그 값을 저장할 각 변수 초기화
		int order;
		int value;
		
		// 매개변수를 입력 받는 생성자 정의
		public Number(int order, int value) {
			this.order = order;
			this.value = value;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수와 최솟값을 찾을 범위를 저장할 각 변수 초기화
		int numberCnt = Integer.parseInt(st.nextToken());
		int targetRange = Integer.parseInt(st.nextToken());
		
		// 현재 최솟값인 숫자와 다음으로 작은 숫자를 저장할 Deque 객체 minNumbers 초기화
		Deque<Number> minNumbers = new ArrayDeque<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int order = 1; order <= numberCnt; order++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 minNumbers가 비어 있거나 저장된 마지막 숫자보다 더 작거나 같은 경우 저장된 마지막 숫자를 제거
			while (!minNumbers.isEmpty() && minNumbers.peekLast().value > number)
				minNumbers.pollLast();
			
			// offerLast() 메서드를 사용해 해당 숫자를 minNumbers에 저장
			minNumbers.offerLast(new Number(order, number));
			
			// 최솟값이 범위를 벗어난 경우 해당 최솟값을 제거
			if (minNumbers.peekFirst().order < order - targetRange + 1)
				minNumbers.pollFirst();
			
			// peekFirst() 및 write() 메서드를 사용해 현재 범위의 최솟값을 출력
			out.write(minNumbers.peekFirst().value + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}