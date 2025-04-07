package gold4.num01107;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 목표 채널 및 고장난 버튼의 개수를 각 변수에 할당
		int targetChannel = Integer.parseInt(in.readLine());
		int brokenButtons = Integer.parseInt(in.readLine());
		
		// 버튼의 고장 여부를 저장할 배열 isBroken 초기화
		boolean[] isBroken = new boolean[10];
		
		// 고장난 버튼이 있는 경우
		if (brokenButtons != 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 버튼의 고장 여부를 갱신
			for (int button = 0; button < brokenButtons; button++)
				isBroken[Integer.parseInt(st.nextToken())] = true;
		}
		
		// abs() 메서드를 사용해 목표 채널까지 버튼을 누른 최소 횟수를 저장할 변수 minCnt 초기화
		int minCnt = Math.abs(targetChannel - 100);

		// for 반복문을 사용해 접근 가능한 모든 채널을 순회
		outer: for (int channel = 0; channel < 1000000; channel++) {
			
			// 버튼을 누르는 횟수를 저장할 변수 count 초기화
			int count = 0;
			
			// 0번 채널의 경우
			if (channel == 0) {
							
				// 0번 버튼이 고장난 경우 다음 숫자를 검사
				if (isBroken[0])
					continue;
				
				// 0번 버튼을 누르기 위한 횟수 갱신
				count++;
			
			// 0번 채널이 아닌 경우
			} else {
				
				// 해당 채널 번호를 변수 cNums에 할당
				int cNums = channel;
				
				// while 반복문을 사용해 각 번호의 접근 가능 여부를 검사
				while (cNums > 0) {
					
					// 해당 자릿수에 접근이 불가능한 경우 다음 채널 탐색
					if (isBroken[cNums % 10])
						continue outer;
					
					// 다음 자릿수 탐색을 위해 채널 번호 조정
					cNums /= 10;
					
					// 해당 버튼을 누르기 위한 횟수 갱신
					count++;
				}
			}
			
			// 해당 번호에서 목표 채널까지 이동하기 위한 횟수 갱신
			count += Math.abs(targetChannel - channel);
			
			// min() 메서드를 사용해 버튼을 누른 최소 횟수 갱신
			minCnt = Math.min(count, minCnt);
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표 채널까지 버튼을 누른 최소 횟수를 출력
		out.write(String.valueOf(minCnt));
	
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}