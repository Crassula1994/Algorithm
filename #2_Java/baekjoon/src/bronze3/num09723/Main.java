package bronze3.num09723;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 해당 삼각형의 각 변의 길이를 저장할 배열 triangle 초기화
			int[] triangle = new int[3];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 삼각형의 변의 길이를 배열 triangle에 저장
			for (int idx = 0; idx < triangle.length; idx++)
				triangle[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 각 삼각형의 변의 길이를 오름차순으로 정렬
			Arrays.sort(triangle);
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write("Case #" + tc + ": ");
			
			// rightAngleChecker() 및 write() 메서드를 사용해 해당 삼각형이 직각삼각형인지 여부를 출력
			out.write((rightAngleChecker(triangle)) ? "YES" : "NO");

			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// rightAngleChecker() 메서드 정의
	public static boolean rightAngleChecker(int[] triangle) {
		
		// 해당 삼각형이 직각삼각형인지 여부를 반환
		return triangle[0] * triangle[0] + triangle[1] * triangle[1] == triangle[2] * triangle[2];
	}
}