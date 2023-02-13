package bronze1.num3985;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 케이크 길이 및 방청객 수를 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		int audience = Integer.parseInt(in.readLine());
		
		// 케이크 조각을 나타낼 배열 cakes 초기화
		int[] cakes = new int[length];
		
		// 가장 많은 예상 케이크 조각의 수 및 방청객 번호를 저장할 각 변수 초기화
		int expectedMax = 0;
		int expectedAud = 0;
		
		// 실제 받은 가장 많은 케이크 조각의 수 및 방청객 번호를 저장할 각 변수 초기화
		int realMax = 0;
		int realAud = 0;
		
		// for 반복문을 사용해 각 방청객을 순회
		for (int audNum = 1; audNum < audience + 1; audNum++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 적어낸 수를 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 실제 케이크 조각의 개수를 셀 변수 count 초기화
			int count = 0;
			
			// 예상 케이크 조각의 수가 최대인 경우 각 변수 갱신
			if (end - start + 1 > expectedMax) {
				expectedMax = end - start + 1;
				expectedAud = audNum;
			}
			
			// for 반복문을 사용해 각 케이크 조각을 순회
			for (int idx = start - 1; idx < end; idx++) {
				
				// 해당 케이크 조각의 소유자가 없는 경우 
				if (cakes[idx] == 0) {
					
					// 케이크 조각의 소유자 갱신
					cakes[idx] = audNum;
					
					// 실제 받은 케이크의 수 갱신
					count++;
				}
			}
			
			// 실제 받은 케이크 조각의 수가 최대인 경우 각 변수 갱신
			if (count > realMax) {
				realMax = count;
				realAud = audNum;
			}
		}
		
		// write() 메서드를 사용해 각 방청객의 번호를 출력
		out.write(expectedAud + "\n" + realAud);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}