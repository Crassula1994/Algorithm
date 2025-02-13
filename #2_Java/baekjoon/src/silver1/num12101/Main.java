package silver1.num12101;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 목표 숫자와 사전 순서, 지금까지 찾은 방법의 수를 저장할 각 변수 초기화
	static int number;
	static int targetOrder;
	static int count = 0;
	
	// 현재 목표 숫자를 만드는 방법을 저장할 List 객체 method 초기화
	static List<Integer> method = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 목표 숫자와 사전 순서를 각 변수에 할당
		number = Integer.parseInt(st.nextToken());
		targetOrder = Integer.parseInt(st.nextToken());
		
		// methodFinder() 메서드를 호출해 찾고자 하는 사전 순서에 해당하는 방법을 갱신
		methodFinder(0, 0);
		
		// 찾고자 하는 사전 순서에 해당하는 방법이 없는 경우 -1을 출력
		if (count < targetOrder) {
			out.write(String.valueOf(-1));
			
		// 찾고자 하는 사전 순서에 해당하는 방법이 있는 경우
		} else {
			
			// for 반복문을 사용해 해당 방법의 각 숫자를 순회
			for (int idx = 0; idx < method.size(); idx++) {}
			
			
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// methodFinder() 메서드 정의
	public static void methodFinder(int sum, int curIdx) {
		
	}
}