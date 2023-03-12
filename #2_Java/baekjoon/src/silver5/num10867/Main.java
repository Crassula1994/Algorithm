package silver5.num10867;

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
		
		// 각 숫자의 존재 여부를 저장할 배열 numbers 초기화
		boolean[] numbers = new boolean[2001];
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 numCnt에 할당
		int numCnt = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자를 순회하며 입력 받은 숫자의 존재 여부를 배열 numbers에 갱신
		for (int num = 0; num < numCnt; num++)
			numbers[Integer.parseInt(st.nextToken()) + 1000] = true;

		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int idx = 0; idx < numbers.length; idx++) {
			
			// 해당 숫자가 존재하는 경우 출력
			if (numbers[idx])
				out.write((idx - 1000) + " ");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}