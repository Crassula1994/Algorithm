package bronze4.num30402;

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

		// for 반복문을 사용해 픽셀의 각 행을 순회
		outer: for (int r = 0; r < 15; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 픽셀의 각 열을 순회
			for (int c = 0; c < 15; c++) {
				
				// nextToken() 메서드를 사용해 입력 받은 픽셀 값을 변수 pixel에 할당
				String pixel = st.nextToken();
				
				/* switch 조건문을 사용해 해당 픽셀의 색으로 어떤 고양이인지 알 수 있는 경우
				해당 고양이 이름을 출력 후 반복문 탈출 */
				switch (pixel) {
					case "w":
						out.write("chunbae");
						break outer;
					case "b":
						out.write("nabi");
						break outer;
					case "g":
						out.write("yeongcheol");
						break outer;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}