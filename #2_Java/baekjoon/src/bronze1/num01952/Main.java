package bronze1.num01952;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 표의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 표의 행의 수가 열의 수보다 많은 경우 선이 꺾어지는 횟수를 출력
		if (height > width) {
			out.write(String.valueOf(2 * width - 1));
		
		// 표의 행의 수가 열의 수와 같거나 작은 경우 선이 꺾어지는 횟수를 출력
		} else {
			out.write(String.valueOf(2 * height - 2));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}