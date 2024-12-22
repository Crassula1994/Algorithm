package bronze4.num32941;

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
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 예약할 수 있는 교시의 개수 및 건우가 예약한 교시를 각 변수에 할당
		int periodNum = Integer.parseInt(st.nextToken());
		int reservedPeriod = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 조원의 수를 변수 memberNum에 할당
		int memberNum = Integer.parseInt(in.readLine());
		
		// 모든 조원이 참석할 수 있는지 여부를 저장할 변수 isPossible 초기화
		boolean isPossible = true;
		
		// while 반복문을 사용해 각 조원을 순회
		while (memberNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 조원이 참석 가능한 교시의 개수를 변수 count에 할당
			int count = Integer.parseInt(in.readLine());
			
			// 해당 조원이 건우가 예약한 교시에 참석할 수 있는지 여부를 저장할 변수 canAttend 초기화
			boolean canAttend = false;
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 각 조원이 참석 가능한 교시를 순회
			while (count-- > 0) {
				
				// 해당 교시가 건우가 예약한 교시인 경우 해당 조원이 건우가 예약한 교시에 참석할 수 있는지 여부를 갱신 후 반복문 탈출
				if (Integer.parseInt(st.nextToken()) == reservedPeriod) {
					canAttend = true;
					break;
				}
			}
			
			// 해당 조원이 건우가 예약한 교시에 참석할 수 없는 경우
			if (!canAttend) {
				
				// write() 메서드를 사용해 'NO' 출력
				out.write("NO");
				
				// 모든 조원이 참석할 수 있는지 여부를 갱신 후 반복문 탈출
				isPossible = false;
				break;
			}
		}
		
		// 모든 조원이 참석할 수 있는 경우 'YES' 출력
		if (isPossible)
			out.write("YES");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}