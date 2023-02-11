package bronze3.num4153;

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
		
		// while 반복문을 사용해 각 삼각형을 순회
		outer: while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 삼각형의 각 변을 저장할 배열 triangle 초기화
			int[] triangle = new int[3];
			
			// for 반복문을 사용해 입력 받은 삼각형의 각 변을 순회
			for (int i = 0; i < 3; i++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 삼각형의 변을 변수 side에 할당
				int side = Integer.parseInt(st.nextToken());
				
				// 입력 받은 삼각형의 변이 0인 경우 반복문 탈출
				if (side == 0)
					break outer;
				
				// 배열 triangle에 입력 받은 삼각형의 변을 추가
				triangle[i] = side;
			}
			
			// sort() 메서드를 사용해 배열의 각 원소를 오름차순으로 정렬
			Arrays.sort(triangle);
			
			// 직각삼각형인 경우 write() 메서드를 사용해 'right' 출력
			if (triangle[2] * triangle[2] == triangle[0] * triangle[0] + triangle[1] * triangle[1]) {
				out.write("right\n");
				
			// 직각삼각형이 아닌 경우 write() 메서드를 사용해 'wrong' 출력
			} else {
				out.write("wrong\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}