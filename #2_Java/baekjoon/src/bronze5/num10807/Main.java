package bronze5.num10807;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 각 정수를 담을 배열 numbers 초기화
		int[] numbers = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 numbers에 입력 받은 정수를 차례로 저장
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 찾으려는 정수를 변수 targetNum에 할당
		int targetNum = Integer.parseInt(in.readLine());
		
		// 정수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int number : numbers) {
			
			// 해당 원소가 targetNum과 같은 경우 개수를 갱신
			if (number == targetNum)
				count++;
		}

		// valueOf() 및 write() 메서드를 사용해 찾으려는 정수의 개수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}