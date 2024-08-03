package silver4.num12788;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 회원의 수를 변수 memberNum에 할당
		int memberNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 대회에 참가한 팀의 수 및 팀원의 수를 각 변수에 할당
		int teamNum = Integer.parseInt(st.nextToken());
		int teamMemberNum = Integer.parseInt(st.nextToken());
		
		// 회원들이 보유한 모든 펜의 수를 저장할 변수 penNum 초기화
		int penNum = 0;
		
		// 각 회원이 가지고 있는 펜의 수를 저장할 배열 pens 초기화
		Integer[] pens = new Integer[memberNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 회원을 순회
		for (int idx = 0; idx < pens.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 펜의 수를 배열 pens에 저장
			pens[idx] = Integer.parseInt(st.nextToken());
			
			// 회원들이 보유한 모든 펜의 수를 갱신
			penNum += pens[idx];
		}
		
		// 펜이 부족한 경우 'STRESS' 출력
		if (penNum < teamNum * teamMemberNum) {
			out.write("STRESS");
			
		// 펜이 부족하지 않은 경우
		} else {
			
			// 최소한으로 빌린 펜의 개수를 저장할 변수 minCount 초기화
			int minCount = 0;
			
			// reverseOrder() 및 sort() 메서드를 사용해 회원들이 보유한 펜의 수를 내림차순 정렬
			Arrays.sort(pens, Collections.reverseOrder());
			
			// for 반복문을 사용해 각 회원을 순회
			for (int idx = 0; idx < pens.length; idx++) {
				
				// 최소한으로 빌린 펜의 개수를 갱신
				minCount += pens[idx];
				
				// 필요한 펜의 수만큼 빌린 경우 최소한으로 펜을 빌린 회원의 수를 출력 후 반복문 탈출
				if (minCount >= teamNum * teamMemberNum) {
					out.write(String.valueOf(idx + 1));
					break;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}