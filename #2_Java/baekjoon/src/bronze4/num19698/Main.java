package bronze4.num19698;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소의 수, 헛간의 크기, 배정되는 공간의 크기를 각 변수에 할당
		int cowNum = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());
		
		// 최대 입주 가능한 소의 숫자를 계산해 변수 maxNum에 할당
		int maxNum = (width / size) * (height / size);
		
		// 최대 입주 가능한 수가 입력 받은 소의 수보다 많은 경우 소의 숫자를 출력
		if (maxNum > cowNum) {
			out.write(String.valueOf(cowNum));
			
		// 최대 입주 가능한 수가 입력 받은 소의 수보다 작거나 같은 경우 최대 입주 가능한 수를 출력
		} else {
			out.write(String.valueOf(maxNum));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}