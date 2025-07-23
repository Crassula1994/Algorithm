package bronze3.num02547;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

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
			
			// readLine() 메서드를 사용해 테스트 케이스 사이의 빈 줄을 제거
			in.readLine();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
			int studentNum = Integer.parseInt(in.readLine());
			
			// 사탕 개수의 합을 저장할 변수 sum 초기화
			BigInteger sum = new BigInteger("0");
			
			// for 반복문을 사용해 사탕 개수의 합을 갱신
			for (int student = 0; student < studentNum; student++)
				sum = sum.add(new BigInteger(in.readLine()));
			
			// write() 메서드를 사용해 모두에게 같은 사탕을 나눠줄 수 있는지 여부를 출력
			out.write((sum.remainder(BigInteger.valueOf(studentNum)).toString().equals("0")) ? "YES" : "NO");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}