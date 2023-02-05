package silver5.num1193;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 저장
		int number = Integer.parseInt(in.readLine());
		
		// 분수의 위치를 저장할 변수 line 초기화
		int line = 0;
		
		// 각 위치의 마지막 분수 번호를 저장할 변수 lastFraction 초기화
		int lastFraction = 0;
		
		// while 반복문을 사용해 주어진 숫자까지의 분수를 순회
		while (true) {
			
			// 분수의 위치 조정
			line++;
			
			// 마지막 분수의 번호를 갱신
			lastFraction += line;
			
			// 입력 받은 번호가 마지막 분수 번호 이전에 있는 경우 반복문 탈출
			if (number <= lastFraction)
				break;
		}
		
		// 홀수 위치인 경우 분수 출력
		if (line % 2 == 1) {
			out.write((1 - number + lastFraction) + "/" + (number - lastFraction + line) + "\n");
			
		// 짝수 위치인 경우 분수 출력
		} else {
			out.write((number - lastFraction + line) + "/" + (1 - number + lastFraction) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}