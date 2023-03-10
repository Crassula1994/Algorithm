package silver5.num01476;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 연도를 각 변수에 할당
		int earthYear = Integer.parseInt(st.nextToken());
		int sunYear = Integer.parseInt(st.nextToken());
		int moonYear = Integer.parseInt(st.nextToken());
		
		// 해당 연도로 표시되는 가장 빠른 연도를 저장할 변수 year 초기화
		int year = 0;
		
		// 각 연도 중 최대 범위에 해당하는 경우 나머지 연산을 위해 해당 값을 0으로 변경
		if (earthYear == 15) earthYear = 0;
		if (sunYear == 28) sunYear = 0;
		if (moonYear == 19) moonYear = 0;
		
		// while 반복문을 사용해 가장 빠른 연도를 찾을 때까지 순회
		while (true) {
			
			// 다음 연도 갱신
			year++;
			
			// 해당 연도의 변환 결과가 각 연도와 일치하는 경우 반복문 탈출
			if (year % 15 == earthYear && year % 28 == sunYear && year % 19 == moonYear)
				break;
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 연도로 표시되는 가장 빠른 연도를 출력
		out.write(String.valueOf(year));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}