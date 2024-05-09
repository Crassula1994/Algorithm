package silver1.num14225;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 수열의 크기를 저장할 변수 size 초기화
	static int size;
	
	// 수열, 각 자연수를 만들 수 있는지 여부를 저장할 각 배열 초기화
	static int[] sequence;
	static boolean[] isGenerated = new boolean[2000001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 수열을 저장할 배열 sequence 초기화
		sequence = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// numberGenerator() 메서드를 사용해 각 숫자의 합으로 만들 수 있는 숫자를 갱신
		numberGenerator(0, 0);
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int n = 1; n < isGenerated.length; n++) {
			
			// 해당 자연수를 만들 수 없는 경우 해당 자연수를 출력 후 반복문 탈출
			if (!isGenerated[n]) {
				out.write(String.valueOf(n));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// numberGenerator() 메서드 정의
	public static void numberGenerator(int element, int sum) {
		
		// 모든 숫자를 확인한 경우
		if (element == size) {
			
			// 숫자의 합이 0이 아닌 경우 부분 수열의 합에 해당하는 자연수를 만들 수 있는 것으로 갱신
			if (sum != 0)
				isGenerated[sum] = true;
			
			// 메서드 종료
			return;
		}
		
		// 각 숫자를 더했을 때와 더하지 않았을 때를 상정해 numberGenerator() 메서드 재귀 호출
		numberGenerator(element + 1, sum);
		numberGenerator(element + 1, sum + sequence[element]);		
	}
}