package silver5.num30993;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 주차장 칸 수 및 빨간색, 초록색, 파란색 자동차의 대수를 각 변수에 할당
		int garageCount = Integer.parseInt(st.nextToken());
		int redCount = Integer.parseInt(st.nextToken());
		int greenCount = Integer.parseInt(st.nextToken());
		int blueCount = Integer.parseInt(st.nextToken());
		
		// factorial() 메서드를 호출해 자동차를 주차할 수 있는 경우의 수를 계산하고 변수 totalCount에 할당
		long totalCount = factorial(garageCount) / (factorial(redCount) * factorial(greenCount) * factorial(blueCount));
		
		// valueOf() 및 write() 메서드를 사용해 자동차를 주차할 수 있는 경우의 수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// factorial() 메서드 정의
	public static long factorial(int number) {
		
		// 팩토리얼을 계산한 결과를 저장할 변수 result 초기화
		long result = 1;
		
		// while 반복문을 사용해 팩토리얼을 계산
		while (number > 0)
			result *= number--;
		
		// 팩토리얼을 계산한 결과를 반환
		return result;
	}
}