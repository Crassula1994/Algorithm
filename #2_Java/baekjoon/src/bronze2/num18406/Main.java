package bronze2.num18406;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
	    
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 점수를 변수 score에 할당
		String score = in.readLine();
		
		// 점수의 조건을 검증하기 위한 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 점수의 자릿수를 순회
		for (int idx = 0; idx < score.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 자리의 숫자를 변수 number에 할당
			int number = score.charAt(idx) - '0';
			
			// 절반 이전의 숫자인 경우 변수 sum에 합산
			if (idx < score.length() / 2) {
				sum += number;
				
			// 절반 이후의 숫자인 경우 변수 sum에서 감산
			} else {
				sum -= number;
			}
		}
		
		// 럭키 스트레이트를 사용할 수 있는 경우 'LUCKY' 출력
		if (sum == 0) {
			out.write("LUCKY");
			
		// 럭키 스트레이트를 사용할 수 없는 경우 'READY' 출력
		} else {
			out.write("READY");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}