package silver2.num01793;

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
		
		// 각 가로 길이를 지닌 직사각형을 채우는 방법의 수를 저장할 배열 counts 초기화
		BigInteger[] counts = new BigInteger[251];
		
		// 가로 길이가 0과 1일 때 직사각형을 채우는 방법의 수를 갱신
		counts[0] = new BigInteger("1");
		counts[1] = new BigInteger("1");
		
		// for 반복문을 사용해 각 가로 길이를 지닌 직사각형을 채우는 방법의 수를 갱신
		for (int idx = 2; idx < counts.length; idx++)
			counts[idx] = counts[idx - 2].multiply(new BigInteger("2")).add(counts[idx - 1]);
		
		// 입력 받은 테스트 케이스를 저장할 변수 line 초기화
		String line;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while ((line = in.readLine()) != null) {
			
			// parseInt() 메서드를 사용해 입력 받은 직사각형의 가로 길이를 변수 width에 할당
			int width = Integer.parseInt(line);
			
			// toString() 및 write() 메서드를 사용해 해당 가로 길이를 지닌 직사각형을 채우는 방법의 수를 출력
			out.write(counts[width].toString() + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}