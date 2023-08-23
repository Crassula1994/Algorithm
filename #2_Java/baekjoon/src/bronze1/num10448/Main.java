package bronze1.num10448;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 삼각수의 값을 저장할 배열 triangularNumbers 초기화
		int[] triangularNumbers = new int[45];
		
		// for 반복문을 사용해
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 해당 숫자를
			int[] triNum = new int[45];
	        for(int i = 1; i < 45; i++) {
	            triNum[i] = i * (i + 1) / 2;
	        }
	        for(int i = 0; i < N; i++) {
	            int n = Integer.parseInt(br.readLine());
	            int result =  eureka(n, triNum);
	            System.out.println(result);
	        }
	    }
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}