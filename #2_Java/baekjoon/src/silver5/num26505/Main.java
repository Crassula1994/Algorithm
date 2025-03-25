package silver5.num26505;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 운이 좋은 숫자와 덜 운이 좋은 숫자를 저장할 각 배열 초기화
	static int[] fortunates = {0, 0, 5, 7, 13, 23, 17, 19, 23, 37, 61, 67, 61, 71, 47};
	static int[] lessFortunates = {0, 0, 3, 7, 11, 13, 17, 29, 23, 43, 41, 73, 59, 47, 89};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 소수의 개수를 순회
		while (st.hasMoreTokens()) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소수의 개수를 변수 numberCnt에 할당
			int numberCnt = Integer.parseInt(st.nextToken());
			
			// format() 및 write() 메서드를 사용해 정해진 형식대로 해당하는 운이 좋은 숫자와 덜 운이 좋은 숫자를 출력
			out.write(String.format("N = %d FORTUNATE = %d LESS = %d\n", numberCnt,
					fortunates[numberCnt], lessFortunates[numberCnt]));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}