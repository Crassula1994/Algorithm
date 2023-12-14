package bronze4.num23795;

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
		
		// 윤성이가 도박판에서 버린 돈의 총합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// while 반복문을 사용해 윤성이가 배팅한 각 돈을 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배팅 금액을 변수 money에 할당
			int money = Integer.parseInt(in.readLine());
			
			// -1이 입력된 경우 반복문 탈출
			if (money == -1)
				break;
			
			// 윤성이가 도박판에서 버린 돈의 총합을 갱신
			sum += money;
		}
		
		// valueOf() 및 write() 메서드를 사용해 윤성이가 도박판에서 버린 돈의 총합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}