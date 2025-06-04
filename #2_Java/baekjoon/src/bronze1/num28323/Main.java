package bronze1.num28323;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 이전 값이 홀수인지 짝수인지 여부,
		만들 수 있는 불안정한 수열의 최대 길이를 저장할 각 변수 초기화 */
		int prevParity = Integer.parseInt(st.nextToken()) & 1;
		int maxLength = 1;
		
		// while 반복문을 사용해 각 자연수를 순회
		while (numberCnt-- > 1) {
		
			// nextToken() 및 parseInt() 메서드를 사용해 현재 값이 홀수인지 짝수인지 여부를 변수 변수 curParity에 저장
			int curParity = Integer.parseInt(st.nextToken()) & 1;
			
			// 이전 값과 다른 경우 만들 수 있는 불안정한 수열의 최대 길이를 갱신
			if (curParity != prevParity)
				maxLength++;
			
			// 이전 값이 홀수인지 짝수인지 여부를 갱신
			prevParity = curParity;
		}
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 불안정한 수열의 최대 길이를 출력
		out.write(String.valueOf(maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}