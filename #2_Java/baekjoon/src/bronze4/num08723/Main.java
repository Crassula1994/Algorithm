package bronze4.num08723;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 삼각형의 각 변의 길이를 저장할 배열 triangle 초기화
		int[] triangle = new int[3];
		
		// for 반복문을 사용해 입력 받은 삼각형의 각 변의 길이를 배열 triangle에 저장
		for (int idx = 0; idx < triangle.length; idx++)
			triangle[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 삼각형의 각 변의 길이를 오름차순으로 정렬
		Arrays.sort(triangle);
		
		// 정삼각형을 만들 수 있는 경우 2를 출력
		if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
			out.write(String.valueOf(2));
			
		// 직각삼각형을 만들 수 있는 경우 1을 출력
		} else if (triangle[0] * triangle[0] + triangle[1] * triangle[1] == triangle[2] * triangle[2]) {
			out.write(String.valueOf(1));
			
		// 직각삼각형도 정삼각형도 만들 수 없는 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}