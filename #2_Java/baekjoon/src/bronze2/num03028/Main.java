package bronze2.num03028;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 순서별로 바뀌는 공의 위치를 저장할 2차원 배열 methods 초기화
	static int[][] methods = {{2, 1, 3}, {1, 3, 2}, {3, 2, 1}};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 현재 공의 위치를 저장할 변수 curCup 초기화
		int curCup = 1;
		
		// readLine() 및 toCharArray() 메서드를 사용해 정인이가 컵을 섞은 순서를 배열 orders에 저장
		char[] orders = in.readLine().toCharArray();
		
		// for 반복문을 사용해 현재 공이 있는 위치를 갱신
		for (char order : orders)
			curCup = methods[order - 'A'][curCup - 1];
		
		// valueOf() 및 write() 메서드를 사용해 현재 공이 있는 위치를 출력
		out.write(String.valueOf(curCup));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}