package silver2.num06603;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 로또 번호를 선택할 숫자의 개수를 저장할 변수 numbers 초기화
	static int numbers;
	
	// 로또 번호를 선택할 숫자를 저장할 배열 sequence 초기화
	static int[] sequence;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 로또 번호를 선택할 숫자의 개수를 변수 numbers에 할당
			numbers = Integer.parseInt(st.nextToken());
			
			// 숫자의 개수가 0인 경우 반복문 탈출
			if (numbers == 0)
				break;
			
			// 로또 번호를 선택할 숫자, 로또 번호로 선택한 숫자를 저장할 각 배열 초기화
			sequence = new int[numbers];
			int[] result = new int[6];
			
			// for 반복문을 사용해 입력 받은 숫자를 배열 sequence에 저장
			for (int idx = 0; idx < numbers; idx++)
				sequence[idx] = Integer.parseInt(st.nextToken());
			
			// numberSelector() 메서드를 호출해 숫자를 고르는 방법을 출력
			numberSelector(0, 0, result, out);
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// numberSelector() 메서드 정의
	public static void numberSelector(int selectedNum, int startIdx, int[] result, BufferedWriter out) throws IOException {
		
		// 6개의 번호를 모두 뽑은 경우
		if (selectedNum == 6) {
			
			// for 반복문을 사용해 선택한 숫자를 출력
			for (int idx = 0; idx < result.length; idx++)
				out.write(result[idx] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 배열 sequence 각 원소를 순회
		for (int idx = startIdx; idx < numbers; idx++) {
			
			// 해당 숫자를 선택 처리
			result[selectedNum] = sequence[idx];
			
			// numberSelector() 메서드 재귀 호출
			numberSelector(selectedNum + 1, idx + 1, result, out);
			
			// 해당 숫자의 선택을 원상 복구
			result[selectedNum] = 0;
		}
	}
}