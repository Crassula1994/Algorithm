package bronze2.num09546;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			 
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정류장의 수를 변수 stationNum에 할당
			int stationNum = Integer.parseInt(in.readLine());
			
			// append() 메서드를 사용해 처음 버스에 타고 있던 승객의 수를 sb에 저장
			sb.append((1 << stationNum) - 1).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 테스트 케이스별 처음 버스에 타고 있던 승객의 수를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}