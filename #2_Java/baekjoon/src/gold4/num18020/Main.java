package gold4.num18020;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 초콜릿 바의 크기, 앨리스와 밥이 가져갈 초콜릿 조각의 수를 각 변수에 할당
		long height = Long.parseLong(st.nextToken());
		long width = Long.parseLong(st.nextToken());
		long countAlice = Long.parseLong(st.nextToken());
		long countBob = height * width - countAlice;
		
		// 초콜릿을 한 번만에 나눌 수 있는 경우 1을 출력
		if (countAlice % height == 0 || countAlice % width == 0) {
			out.write(String.valueOf(1));
			
		// 초콜릿을 두 번만에 나눌 수 있는 경우 2를 출력
		} else if (chocolateDivider(height, width, countAlice) || chocolateDivider(height, width, countBob)) {
			out.write(String.valueOf(2));
			
		// 나머지 경우 세 번만에 모든 초콜릿 조각을 만들 수 있으므로 3을 출력
		} else {
			out.write(String.valueOf(3));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// chocolateDivider() 메서드 정의
	public static boolean chocolateDivider(long height, long width, long targetCount) {
		
		// for 반복문을 사용해 가능한 각 세로 크기를 순회
		for (long length = 1; length <= height; length++) {
			
			// 해당 세로 크기로 원하는 초콜릿 조각을 만들 수 없는 경우 다음 크기를 순회
			if (targetCount % length > 0)
				continue;
			
			// 해당 초콜릿 조각의 가로 크기가 주어진 초콜릿의 가로 크기 이하인 경우 true 반환
			if (targetCount / length <= width)
				return true;
		}
		
		// 해당 조각의 초콜릿을 두 번만에 만들 수 없는 경우 false 반환
		return false;
	}
}