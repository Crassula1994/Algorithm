package gold3.num02482;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 인접한 두 색을 동시에 선택하지 않고 색을 선택할 수 있는 경우의 수를 나눌 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000003;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 색상환의 색의 개수와 선택할 색의 개수를 각 변수에 할당
		int colorNum = Integer.parseInt(in.readLine());
		int selectedNum = Integer.parseInt(in.readLine());

		// 각 색상환의 색의 개수와 선택한 색의 개수에 따른 경우의 수를 저장할 2차원 배열 counts 초기화
		int[][] counts = new int[colorNum + 1][selectedNum + 1];
		
		// for 반복문을 사용해 어떤 색도 고르지 않는 경우 및 1개의 색을 고르는 방법의 수를 갱신
		for (int color = 0; color <= colorNum; color++) {
			counts[color][0] = 1;
			counts[color][1] = color;
		}
		
		// for 반복문을 사용해 각 색상의 개수를 순회
		for (int color = 3; color <= colorNum; color++) {
			
			// for 반복문을 사용해 선택해야 하는 각 색상의 개수를 고르는 방법의 수를 갱신
			for (int selection = 2; selection <= Math.min((color + 1) / 2, selectedNum); selection++)
				counts[color][selection] = (counts[color - 1][selection] + counts[color - 2][selection - 1]) % DIVISOR;
		}
		
		// 인접한 두 색을 동시에 선택하지 않고 색을 고를 수 있는 경우의 수를 계산해 변수 totalCount에 할당
		int totalCount = (counts[colorNum - 3][selectedNum - 1] + counts[colorNum - 1][selectedNum]) % DIVISOR;
		
		// valueOf() 및 write() 메서드를 사용해 인접한 두 색을 동시에 선택하지 않고 색을 고를 수 있는 경우의 수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}