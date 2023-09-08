package bronze1.num04796;

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
		
		// 테스트 케이스의 번호를 저장할 변수 testCase 초기화
		int testCase = 0;
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 캠핑장의 사용 가능 기간 및 휴가일수를 각 변수에 할당
			int availableDay = Integer.parseInt(st.nextToken());
			int entireDay = Integer.parseInt(st.nextToken());
			int vacation = Integer.parseInt(st.nextToken());
			
			// 0이 세 개 주어진 경우 반복문 탈출
			if (availableDay == 0 && entireDay == 0 && vacation == 0)
				break;
			
			// min() 메서드를 사용해 캠핑장을 사용할 수 있는 최대 일수를 계산해 변수 maxDay에 저장
			int maxDay = (vacation / entireDay) * availableDay + Math.min(availableDay, vacation % entireDay);
			
			// 테스트 케이스의 번호를 갱신
			testCase++;
			
			// write() 메서드를 사용해 캠핑장을 사용할 수 있는 최대 일수를 출력
			out.write("Case " + testCase + ": " + maxDay + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}