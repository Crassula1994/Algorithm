package bronze5.num27294;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시간과 술의 유무를 각 변수에 할당
		int time = Integer.parseInt(st.nextToken());
		int isDrink = Integer.parseInt(st.nextToken());
		
		// 술이 없고 점심 식사인 경우 주영이가 만들어야 하는 초밥의 밥알의 개수를 320개로 출력
		if (isDrink == 0 && time >= 12 && time <= 16) {
			out.write(String.valueOf(320));
		
		// 나머지 경우 주영이가 만들어야 하는 초밥의 밥알의 개수를 280개로 출력
		} else {
			out.write(String.valueOf(280));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}