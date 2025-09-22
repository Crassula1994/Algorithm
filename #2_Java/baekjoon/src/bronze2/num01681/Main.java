package bronze2.num01681;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수 및 쓰지 않을 숫자를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int digitLimit = Integer.parseInt(st.nextToken());
		
		// 마지막 학생의 번호 라벨을 저장할 변수 lastLabel 초기화
		int lastLabel = 0;
		
		// while 반복문을 사용해 각 학생을 순회
		while (studentNum-- > 0) {
			
			// do while 반복문을 사용해 해당 학생에게 부여할 번호 라벨을 갱신
			do {
				lastLabel++;
			} while (!numberChecker(lastLabel, digitLimit));
		}
		
		// valueOf() 및 write() 메서드를 사용해 마지막 학생의 번호 라벨을 출력
		out.write(String.valueOf(lastLabel));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberChecker() 메서드 정의
	public static boolean numberChecker(int numberLabel, int digitLimit) {
		
		// while 반복문을 사용해 각 자릿수를 순회
		while (numberLabel > 0) {
			
			// 해당 번호 라벨에 쓰지 않을 숫자가 포함된 경우 false 반환
			if (numberLabel % 10 == digitLimit)
				return false;
			
			// 다음 자릿수를 확인하기 위해 번호 라벨 갱신
			numberLabel /= 10;
		}
		
		// 해당 번호 라벨에 쓰지 않을 숫자가 포함되지 않은 경우 true 반환
		return true;
	}
}