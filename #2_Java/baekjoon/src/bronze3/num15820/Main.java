package bronze3.num15820;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 샘플 테스트 케이스의 개수와
		시스템 테스트 케이스의 개수를 각 변수에 할당 */
		int sampleTestCase = Integer.parseInt(st.nextToken());
		int systemTestCase = Integer.parseInt(st.nextToken());
		
		// 민영이가 샘플 테스트 케이스와 시스템 테스트 케이스를 통과했는지 여부를 저장할 각 변수 초기화
		boolean isSamplePassed = true;
		boolean isSystemPassed = true;
		
		// while 반복문을 사용해 각 샘플 테스트 케이스를 순회
		while (sampleTestCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			/* 해당 샘플 테스트 케이스를 통과하지 못한 경우
			민영이가 샘플 테스트 케이스를 통과했는지 여부를 갱신 후 반복문 탈출 */
			if (!st.nextToken().equals(st.nextToken())) {
				isSamplePassed = false;
				break;
			}
		}
		
		// 민영이의 코드가 샘플 테스트 케이스를 통과한 경우
		if (isSamplePassed) {
			
			// while 반복문을 사용해 각 시스템 테스트 케이스를 순회
			while (systemTestCase-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				/* 해당 시스템 테스트 케이스를 통과하지 못한 경우
				민영이가 시스템 테스트 케이스를 통과했는지 여부를 갱신 후 반복문 탈출 */
				if (!st.nextToken().equals(st.nextToken())) {
					isSystemPassed = false;
					break;
				}
			}
		}
		
		// 민영이의 코드가 모든 테스트 케이스에 대해 올바른 답을 생성한 경우 'Accepted' 출력
		if (isSamplePassed && isSystemPassed) {
			out.write("Accepted");
			
		// 민영이의 코드가 시스템 샘플 테스트 케이스는 맞았지만 시스템 테스트 케이스는 틀린 경우 'Why Wrong!!!' 출력
		} else if (isSamplePassed) {
			out.write("Why Wrong!!!");
			
		// 민영이의 코드가 샘플 테스트 케이스를 틀린 경우 'Wrong Answer' 출력
		} else {
			out.write("Wrong Answer");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}