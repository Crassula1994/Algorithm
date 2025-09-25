package bronze3.num04118;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 복권의 번호가 존재하는지 여부를 저장할 배열 covered 초기화
	static boolean[] covered;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 프레드가 구입한 복권의 수를 변수 ticketNum에 할당
			int ticketNum = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (ticketNum == 0)
				break;
			
			// 프레드가 구입한 복권의 수가 9개 미만인 경우
			if (ticketNum < 9) {
				
				// while 반복문을 사용해 복권을 구입한 내역을 순회
				while (ticketNum-- > 0)
					in.readLine();
				
				// write() 메서드를 사용해 'No' 출력
				out.write("No");
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
				
				// 다음 테스트 케이스를 순회
				continue;
			}
			
			// 각 복권의 번호가 존재하는지 여부를 저장할 배열 covered 초기화
			covered = new boolean[50];
			
			// while 반복문을 사용해 복권을 구입한 내역을 순회
			while (ticketNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 각 복권의 번호의 존재 여부를 갱신
				for (int number = 0; number < 6; number++)
					covered[Integer.parseInt(st.nextToken())] = true;
			}
			
			// ticketChecker() 및 write() 메서드를 사용해 프레드가 구입한 복권에 모든 번호가 존재하는지 여부를 출력
			out.write((ticketChecker()) ? "Yes" : "No");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ticketChecker() 메서드 정의
	public static boolean ticketChecker() {
		
		// for 반복문을 사용해 복권의 각 숫자를 순회
		for (int number = 1; number < 50; number++) {
			
			// 해당 숫자가 존재하지 않는 경우 false 반환
			if (!covered[number])
				return false;
		}
		
		// 복권의 모든 숫자가 존재하는 경우 true 반환
		return true;
	}
}