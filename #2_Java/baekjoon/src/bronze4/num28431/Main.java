package bronze4.num28431;

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
		
		// 각 숫자의 양말이 등장한 횟수를 저장할 배열 counter 초기화
		int[] counter = new int[10];
		
		// for 반복문을 사용해 다섯 개 양말의 숫자별 개수를 갱신
		for (int sock = 0; sock < 5; sock++)
			counter[Integer.parseInt(in.readLine())]++;
		
		// for 반복문을 사용해 각 양말의 숫자를 순회
		for (int number = 0; number < 10; number++) {
			
			// 한 짝의 양말만 존재하는 경우 양말에 쓰인 숫자를 출력 후 반복문 탈출
			if (counter[number] % 2 != 0) {
				out.write(String.valueOf(number));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}