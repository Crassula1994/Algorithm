package bronze4.num15025;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 무스의 왼쪽, 오른쪽 가지의 수를 각 변수에 할당
		int leftCount = Integer.parseInt(st.nextToken());
		int rightCount = Integer.parseInt(st.nextToken());
		
		// 무스가 아닌 경우 'Not a moose'를 출력
		if (leftCount == 0 && rightCount == 0) {
			out.write("Not a moose");
			
		// 무스인 경우 무스의 점수를 출력
		} else {
			out.write((leftCount == rightCount)
					? "Even " + (leftCount * 2) : "Odd " + (Math.max(leftCount, rightCount) * 2));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}