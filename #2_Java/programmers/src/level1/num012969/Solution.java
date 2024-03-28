package level1.num012969;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 직사각형의 길이를 각 변수에 할당
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 별 문자를 출력
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++)
				out.write("*");
			
			// 마지막 줄이 아닌 경우 줄바꿈을 출력
			if (r != height - 1)
				out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}