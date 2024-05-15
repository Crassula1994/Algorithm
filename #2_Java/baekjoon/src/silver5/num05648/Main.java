package silver5.num05648;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원소의 개수를 변수 elementNum에 할당
		int elementNum = Integer.parseInt(st.nextToken());
		
		// 입력 받은 원소를 뒤집어 저장할 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// 입력 받은 원소를 뒤집어 저장할 배열 elements 초기화
		long[] elements = new long[elementNum];
		
		// while 반복문을 사용해 모든 원소를 찾을 때까지 순회
		while (index < elementNum) {
			
			// 해당 줄에 원소가 존재하는 경우
			if (st.hasMoreTokens()) {
				
				// nextToken() 및 reverse() 메서드를 사용해 입력 받은 원소를 뒤집어 StringBuilder 객체 sb에 할당
				StringBuilder sb = new StringBuilder(st.nextToken()).reverse();
				
				// toString() 및 parseLong() 메서드를 사용해 해당 원소를 배열 elements에 저장
				elements[index++] = Long.parseLong(sb.toString());
			
			// 해당 줄에 원소가 존재하지 않는 경우 StringTokenizer 객체를 불러와 변수 st에 재할당
			} else {
				st = new StringTokenizer(in.readLine());
			}
		}
		
		// sort() 메서드를 사용해 배열 elements의 원소를 오름차순으로 정렬
		Arrays.sort(elements);
		
		// for 반복문을 사용해 각 원소를 오름차순으로 정렬한 결과를 출력
		for (long element : elements)
			out.write(element + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}