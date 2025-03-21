package silver3.num02548;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 입력 받은 자연수를 저장할 배열 numbers 초기화
		int[] numbers = new int[numberCnt];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 자연수를 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 입력 받은 자연수를 오름차순으로 정렬
		Arrays.sort(numbers);
		
		// valueOf() 및 write() 메서드를 사용해 대표 자연수를 출력
		out.write(((numberCnt & 1) == 1)
				? String.valueOf(numbers[numberCnt / 2]) : String.valueOf(numbers[numberCnt / 2 - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}