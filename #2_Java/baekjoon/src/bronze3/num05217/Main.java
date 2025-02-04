package bronze3.num05217;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 목표 숫자를 변수 targetNumber에 할당
			int targetNumber = Integer.parseInt(in.readLine());
			
			// write() 메서드를 사용해 입력 받은 목표 숫자를 정해진 형식대로 출력
			out.write("Pairs for " + targetNumber + ": ");
			
			// for 반복문을 사용해 가능한 각 쌍의 작은 수를 순회
			for (int smallNum = 1; smallNum <= targetNumber / 2; smallNum++) {
				
				// 쌍의 두 숫자가 같은 경우 반복문 탈출
				if (smallNum == targetNumber - smallNum)
					break;
				
				// 첫 번째 쌍이 아닌 경우 반점을 출력
				if (smallNum > 1)
					out.write(", ");
				
				// write() 메서드를 사용해 해당 쌍을 출력
				out.write(smallNum + " " + (targetNumber - smallNum));
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}