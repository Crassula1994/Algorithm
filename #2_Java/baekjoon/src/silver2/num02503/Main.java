package silver2.num02503;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 1부터 9까지의 숫자의 사용 여부를 저장할 배열 isSelected 초기화
	static boolean[] isSelected = new boolean[10];
	
	// 가능한 숫자를 저장할 Set 객체 possibleNum 초기화
	static Set<Integer> possibleNum = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질문의 횟수를 각 변수에 할당
		int questionNum = Integer.parseInt(in.readLine());

		// numberMaker() 메서드를 호출해 가능한 숫자를 possibleNum에 추가
		numberMaker(0, 0);
		
		// 실제 남아 있는 값을 저장할 Set 객체 remainNum 초기화
		Set<Integer> remainNum = new HashSet<>(possibleNum);
		
		// for 반복문을 사용해 입력 받은 각 질문을 순회
		for (int question = 0; question < questionNum; question++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 질문한 숫자, 스트라이크 개수, 볼 개수를 각 변수에 할당
			int targetNum = Integer.parseInt(st.nextToken());
			int strikeNum = Integer.parseInt(st.nextToken());
			int ballNum = Integer.parseInt(st.nextToken());
			
			// 입력 받은 질문한 숫자의 세 숫자를 각 변수에 할당
			int targetHundreds = targetNum / 100;
			int targetTens = (targetNum % 100) / 10;
			int targetUnits = (targetNum % 100) % 10;
			
			// for 반복문을 사용해 가능한 숫자를 모두 순회
			for (int number : possibleNum) {
				
				// 해당 숫자의 세 숫자를 각 변수에 할당
				int hundreds = number / 100;
				int tens = (number % 100) / 10;
				int units = (number % 100) % 10;
				
				// 각 숫자의 스트라이크 개수와 볼 개수를 저장할 각 변수 초기화
				int strikeCnt = 0;
				int ballCnt = 0;
				
				// 백의 자리 숫자에 따라 스트라이크의 개수와 볼의 개수를 갱신
				if (hundreds == targetHundreds) {
					strikeCnt++;
				} else if (hundreds == targetTens || hundreds == targetUnits) {
					ballCnt++;
				}
				
				// 십의 자리 숫자에 따라 스트라이크의 개수와 볼의 개수를 갱신
				if (tens == targetTens) {
					strikeCnt++;
				} else if (tens == targetHundreds || tens == targetUnits) {
					ballCnt++;
				}
				
				// 일의 자리 숫자에 따라 스트라이크의 개수와 볼의 개수를 갱신
				if (units == targetUnits) {
					strikeCnt++;
				} else if (units == targetHundreds || units == targetTens) {
					ballCnt++;
				}
				
				// 스트라이크 개수와 볼 개수 중 하나라도 일치하지 않는 경우 남아 있는 숫자에서 제거
				if (strikeNum != strikeCnt || ballCnt != ballNum)
					remainNum.remove(number);
			}
		}
		
		// size(), valueOf(), write() 메서드를 사용해 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력
		out.write(String.valueOf(remainNum.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberMaker() 메서드 정의
	public static void numberMaker(int selectedNum, int result) {
		
		// 세 자리 숫자를 모두 만든 경우
		if (selectedNum == 3) {
			
			// add() 메서드를 사용해 가능한 숫자를 possibleNum에 추가 후 메서드 종료
			possibleNum.add(result);
			return;
		}
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int n = 1; n < 10; n++) {
			
			// 해당 숫자를 이미 사용한 경우 다음 숫자를 순회
			if (isSelected[n])
				continue;
			
			// 해당 숫자를 사용한 것으로 처리
			isSelected[n] = true;
			
			// 해당 숫자를 사용하여 numberMaker() 메서드 재귀 호출
			numberMaker(selectedNum + 1, result * 10 + n);
			
			// 해당 숫자를 사용하지 않은 것으로 원상 복구
			isSelected[n] = false;
		}
	}
}