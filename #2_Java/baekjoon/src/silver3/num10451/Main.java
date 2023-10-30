package silver3.num10451;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 순열의 값과 해당 순열의 확인 여부를 저장할 각 배열 초기화
	static int[] permutation;
	static boolean[] checked;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 순열의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 순열의 값과 해당 순열의 확인 여부를 저장할 각 배열 초기화
			permutation = new int[size + 1];
			checked = new boolean[size + 1];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 순열의 값을 배열 permutation에 저장
			for (int idx = 1; idx <= size; idx++)
				permutation[idx] = Integer.parseInt(st.nextToken());
			
			// 순열 사이클의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 각 순열을 순회
			for (int idx = 1; idx <= size; idx++) {
				
				// 해당 순열을 확인한 경우 다음 순열을 순회
				if (checked[idx])
					continue;
				
				// cycleFinder() 메서드를 호출해 순열 사이클을 확인
				cycleFinder(idx);
				
				// 순열 사이클의 개수를 갱신
				count++;
			}
			
			// write() 메서드를 사용해 순열 사이클의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// cycleFinder() 메서드 정의
	public static void cycleFinder(int idx) {
		
		// 현재 위치를 확인 처리
		checked[idx] = true;
		
		// 다음 위치를 방문하지 않은 경우 cycleFidner() 메서드 재귀 호출
		if (!checked[permutation[idx]])
			cycleFinder(permutation[idx]);
	}
}