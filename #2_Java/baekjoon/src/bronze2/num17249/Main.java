package bronze2.num17249;

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

		// readLine() 메서드를 사용해 입력 받은 혜정이의 모습을 변수 figureString에 할당
		String figureString = in.readLine();
		
		// 왼손의 잔상의 수와 오른손의 잔상의 수, 혜정이의 얼굴이 나왔는지 여부를 저장할 각 변수 초기화
		int leftCount = 0;
		int rightCount = 0;
		boolean isRight = false;
		
		// for 반복문을 사용해 혜정이의 모습을 나타내는 문자열의 각 글자를 순회
		for (int idx = 0; idx < figureString.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 문자열의 글자를 변수 character에 할당
			char character = figureString.charAt(idx);
			
			// 해당 글자가 주먹의 잔상인 경우 왼손과 오른손의 잔상의 수를 갱신
			if (character == '@') {
				leftCount = (isRight) ? leftCount : leftCount + 1;
				rightCount = (isRight) ? rightCount + 1 : rightCount;
				
			// 해당 글자가 얼굴 형태의 시작인 경우 혜정이의 얼굴이 나왔는지 여부를 갱신
			} else if (character == '(') {
				isRight = true;
			}
		}
		
		// write() 메서드를 사용해 왼손과 오른손의 잔상의 수를 출력
		out.write(leftCount + " " + rightCount);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}