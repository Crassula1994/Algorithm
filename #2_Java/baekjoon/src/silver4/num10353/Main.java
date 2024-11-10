package silver4.num10353;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 사각형의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사각형의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 타일의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// frameChecker() 및 write() 메서드를 사용해 해당 타일로 사각형의 틀을 채울 수 있는지 여부를 출력
			out.write((frameChecker(size)) ? "YES" : "NO");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// frameChecker() 메서드 정의
	public static boolean frameChecker(int size) {
		
		// 가로 변을 먼저 타일로 모두 채우고 남은 세로 변을 타일로 채울 수 있는 경우 true 반환
		if ((height - 2) % size == 0 && width % size == 0)
			return true;
		
		// 세로 변을 먼저 타일로 모두 채우고 남은 가로 변을 타일로 채울 수 있는 경우 true 반환
		if (height % size == 0 && (width - 2) % size == 0)
			return true;
		
		// 가로 변과 세로 변을 한 칸씩 비워서 타일로 채울 수 있는 경우 true 반환
		if ((height - 1) % size == 0 && (width - 1) % size == 0)
			return true;
		
		// 가로의 한 변을 먼저 타일로 채우고 세로 변을 타일로 채운 다음, 남은 가로의 한 변을 타일로 채울 수 있는 경우 true 반환
		if ((height - 1) % size == 0 && width % size == 0 && (width - 2) % size == 0)
			return true;
		
		// 세로의 한 변을 먼저 타일로 채우고 가로 변을 타일로 채운 다음, 남은 세로의 한 변을 타일로 채울 수 있는 경우 true 반환
		if (height % size == 0 && (height - 2) % size == 0 && (width - 1) % size == 0)
			return true;
		
		// 해당 크기의 타일로 사각형의 틀을 채울 수 없는 경우 false 반환
		return false;
	}
}