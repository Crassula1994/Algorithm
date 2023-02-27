package silver4.num01026;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 정수 배열 A와 B를 저장할 각 배열 초기화
		Integer[] arrayA = new Integer[length];
		Integer[] arrayB = new Integer[length];
		
		// S의 최솟값을 저장할 변수 minS 초기화
		int minS = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 정수 배열 A의 원소를 배열 arrayA에 저장
		for (int idx = 0; idx < length; idx++)
			arrayA[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 정수 배열 B의 원소를 배열 arrayB에 저장
		for (int idx = 0; idx < length; idx++)
			arrayB[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 arrayA를 오름차순으로, 배열 arrayB를 내림차순으로 정렬
		Arrays.sort(arrayA);
		Arrays.sort(arrayB, Collections.reverseOrder());
		
		// for 반복문을 사용해 S의 최솟값을 갱신
		for (int idx = 0; idx < length; idx++)
			minS += arrayA[idx] * arrayB[idx];
		
		// valueOf() 및 write() 메서드를 사용해 S의 최솟값을 출력
		out.write(String.valueOf(minS));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}