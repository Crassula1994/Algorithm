package silver5.num11728;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열 A와 배열 B의 크기를 각 변수에 할당
		int lengthA = Integer.parseInt(st.nextToken());
		int lengthB = Integer.parseInt(st.nextToken());
		
		// 배열 A와 배열 B를 나타낼 각 배열 초기화
		int[] arrayA = new int[lengthA];
		int[] arrayB = new int[lengthB];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열 A의 원소를 배열 arrayA에 저장
		for (int idx = 0; idx < lengthA; idx++)
			arrayA[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열 B의 원소를 배열 arrayB에 저장
		for (int idx = 0; idx < lengthB; idx++)
			arrayB[idx] = Integer.parseInt(st.nextToken());
		
		// 각 배열의 원소를 정렬하여 출력하기 위해 필요한 각 인덱스 변수 초기화
		int idxA = 0;
		int idxB = 0;
		
		// while 반복문을 사용해 두 인덱스 중 하나가 끝에 도달할 때까지 순회
		while (idxA < lengthA && idxB < lengthB) {
		
			// 배열 A의 원소가 배열 B의 원소보다 작거나 같은 경우 배열 A의 원소를 출력
			if (arrayA[idxA] <= arrayB[idxB]) {
				out.write(arrayA[idxA++] + " ");
				
			// 배열 A의 원소가 배열 B의 원소보다 큰 경우 배열 B의 원소를 출력
			} else {
				out.write(arrayB[idxB++] + " ");
			}
		}
		
		// 배열 A의 인덱스가 남아 있는 경우
		if (idxA < lengthA) {
			
			// for 반복문을 사용해 남은 원소를 모두 출력
			for (int idx = idxA; idx < lengthA; idx++)
				out.write(arrayA[idx] + " ");
		}
		
		// 배열 B의 인덱스가 남아 있는 경우
		if (idxB < lengthB) {
			
			// for 반복문을 사용해 남은 원소를 모두 출력
			for (int idx = idxB; idx < lengthB; idx++)
				out.write(arrayB[idx] + " ");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}