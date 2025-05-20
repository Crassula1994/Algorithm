package bronze1.num17072;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 그림의 세로 길이와 가로 길이를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 그림의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 그림의 각 픽셀을 순회
			for (int c = 0; c < width; c++) {
				
				// 강도 함수(Intensity Function)의 결과 값을 저장할 변수 result 초기화
				int result = 0;
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 픽셀의 강도 함수 결과 값을 갱신
				result += 2126 * Integer.parseInt(st.nextToken());
				result += 7152 * Integer.parseInt(st.nextToken());
				result += 722 * Integer.parseInt(st.nextToken());
				
				// 강도 함수 결과 값이 2040000 이상인 경우 '.'을 출력
				if (result >= 2040000) {
					out.write(".");
					
				// 강도 함수 결과 값이 1530000 이상 2040000 미만인 경우 '-'을 출력
				} else if (result >= 1530000) {
					out.write("-");
					
				// 강도 함수 결과 값이 1020000 이상 1530000 미만인 경우 '+'를 출력
				} else if (result >= 1020000) {
					out.write("+");
					
				// 강도 함수 결과 값이 510000 이상 1020000 미만인 경우 'o'를 출력
				} else if (result >= 510000) {
					out.write("o");
					
				// 강도 함수 결과 값이 0 이상 510000 미만인 경우 '#'을 출력
				} else {
					out.write("#");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}