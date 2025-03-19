package silver4.num20186;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자연수 배열의 크기와 선택해야 하는 수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int targetCount = Integer.parseInt(st.nextToken());
		
		// 전체 점수의 최댓값을 저장할 변수 maxScore 초기화
		int maxScore = -(targetCount - 1) * targetCount / 2;
		
		// 입력 받은 자연수 배열을 저장할 배열 numbers 초기화
		Integer[] numbers = new Integer[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 자연수 배열을 배열 numbers에 저장
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// reverseOrder() 및 sort() 메서드를 사용해 해당 자연수 배열을 내림차순으로 정렬
		Arrays.sort(numbers, Collections.reverseOrder());
		
		// for 반복문을 사용해 전체 점수의 최댓값을 갱신
		for (int idx = 0; idx < targetCount; idx++)
			maxScore += numbers[idx];
		
		// valueOf() 및 write() 메서드를 사용해 전체 점수의 최댓값을 출력
		out.write(String.valueOf(maxScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}