package bronze3.num05789;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 binaryString에 할당
			String binaryString = in.readLine();
			
			// length() 메서드를 사용해 마지막 두 쌍의 위치를 각 변수에 할당
			int lastLeftIdx = binaryString.length() / 2 - 1;
			int lastRightIdx = lastLeftIdx + 1;
			
			// charAt() 및 write() 메서드를 사용해 상근이가 내린 결정을 출력
			out.write((binaryString.charAt(lastLeftIdx) == binaryString.charAt(lastRightIdx)) ? "Do-it" : "Do-it-Not");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}