package bronze3.num03449;

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
			
			// readLine() 메서드를 사용해 입력 받은 두 이진수를 각 변수에 할당
			String binaryStringA = in.readLine();
			String binaryStringB = in.readLine();
			
			// 두 이진수 사이의 해밍 거리를 저장할 변수 distance 초기화
			int distance = 0;
			
			// for 반복문을 사용해 두 이진수의 각 자릿수를 순회
			for (int idx = 0; idx < binaryStringA.length(); idx++) {
				
				// 두 이진수의 자릿수가 다른 경우 두 이진수 사이의 해밍 거리를 갱신
				if (binaryStringA.charAt(idx) != binaryStringB.charAt(idx))
					distance++;
			}
			
			// write() 메서드를 사용해 두 이진수 사이의 해밍 거리를 출력
			out.write("Hamming distance is " + distance + ".\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}