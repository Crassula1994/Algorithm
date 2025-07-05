package bronze5.num29163;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문에 있는 숫자의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 문에 적힌 숫자 중 홀수와 짝수의 개수를 저장할 각 변수 초기화
		int oddCnt = 0;
		int evenCnt = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 문에 있는 각 숫자를 순회
		while (numberCnt-- > 0) {
			
			// 문에 적힌 숫자가 홀수인 경우 홀수의 개수를 갱신
			if ((Integer.parseInt(st.nextToken()) & 1) == 1) {
				oddCnt++;
				
			// 문에 적힌 숫자가 짝수인 경우 짝수의 개수를 갱신
			} else {
				evenCnt++;
			}
		}
		
		// write() 메서드를 사용해 미스터 빈이 행복한지 여부를 출력
		out.write((evenCnt > oddCnt) ? "Happy" : "Sad");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}