package bronze1.num17206;

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
		
		// 각 숫자까지의 3 또는 7의 양의 배수를 모두 더한 값을 저장할 배열 sumArray 초기화
		int[] sumArray = new int[80001];
		
		// for 반복문을 사용해 각 숫자까지의 3 또는 7의 양의 배수를 모두 더한 값을 배열 sumArray에 저장
		for (int idx = 3; idx < sumArray.length; idx++)
			sumArray[idx] = (idx % 3 == 0 || idx % 7 == 0) ? sumArray[idx - 1] + idx : sumArray[idx - 1];
			
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문제의 수를 변수 quesitonNum에 할당
		int questionNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 문제의 정답을 출력
		while (questionNum-- > 0)
			out.write(sumArray[Integer.parseInt(st.nextToken())] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}