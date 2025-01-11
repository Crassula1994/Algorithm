package bronze4.num04714;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 지구에서의 무게를 변수 earthWeight에 할당
			double earthWeight = Double.parseDouble(in.readLine());
			
			// 마지막 테스트 케이스를 확인한 경우 반복문 탈출
			if (earthWeight < 0)
				break;
			
			// format() 및 write() 메서드를 사용해 지구에서의 무게와 달에서의 무게를 출력
			out.write(String.format("Objects weighing %.2f on Earth will weigh %.2f on the moon.",
					earthWeight, earthWeight * 0.167));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}