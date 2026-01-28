package bronze3.num09366;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 삼각형 세 변의 길이를 저장할 배열 triangle 초기화
			int[] triangle = new int[3];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 삼각형의 세 변의 길이를 배열 triangle에 저장
			for (int idx = 0; idx < triangle.length; idx++)
				triangle[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 삼각형의 세 변의 길이를 오름차순으로 정렬
			Arrays.sort(triangle);
			
			// append() 메서드를 사용해 해당 테스트 케이스의 번호를 sb에 저장
			sb.append("Case #").append(tc).append(": ");
			
			// 삼각형을 만들 수 없는 경우 'invalid!'를 sb에 저장
			if (triangle[2] >= triangle[0] + triangle[1]) {
				sb.append("invalid!\n");
				
			// 해당 삼각형이 정삼각형인 경우 'equilateral'을 sb에 저장
			} else if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
				sb.append("equilateral\n");
				
			// 해당 삼각형이 이등변삼각형인 경우 'isosceles'를 sb에 저장
			} else if (triangle[0] == triangle[1] || triangle[1] == triangle[2]) {
				sb.append("isosceles\n");
				
			// 해당 삼각형이 부등변삼각형인 경우 'scalene'을 sb에 저장
			} else {
				sb.append("scalene\n");
			}
		}
		
		// toString() 및 write() 메서드를 사용해 각 테스트 케이스의 삼각형 타입을 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}