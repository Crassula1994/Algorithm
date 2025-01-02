package gold4.num20033;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 히스토그램에 속한 각 막대의 높이를 저장할 배열 histogram 초기화
	static int[] histogram;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 히스토그램에 속한 막대의 개수를 변수 barNum에 할당
		int barNum = Integer.parseInt(in.readLine());
		
		// 히스토그램에서 가능한 정사각형 크기의 범위와 그 최댓값를 나타낼 각 변수 초기화
		int minSize = 1;
		int maxSize = barNum + 1;
		int maxSquare = 0;
		
		// 히스토그램에 속한 각 막대의 높이를 저장할 배열 histogram 초기화
		histogram = new int[barNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 히스토그램에 속한 각 막대의 높이를 배열 histogram에 저장
		for (int idx = 0; idx < histogram.length; idx++)
			histogram[idx] = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 히스토그램에서 가능한 정사각형 크기를 찾을 때까지 순회
		while (minSize < maxSize) {
			
			// 범위의 가운데 위치한 정사각형의 크기를 계산해 변수 midSize에 할당
			int midSize = (minSize + maxSize) / 2;
			
			// 해당 크기의 정사각형이 존재하는 경우 히스토그램에서 가능한 정사각형 크기의 최댓값과 범위의 하한을 갱신
			if (squareChecker(midSize)) {
				minSize = midSize + 1;
				maxSquare = midSize;
				
			// 해당 크기의 정사각형이 존재하지 않는 경우 범위의 상한을 갱신
			} else {
				maxSize = midSize;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 히스토그램에서 가능한 정사각형 크기의 최댓값을 출력
		out.write(String.valueOf(maxSquare));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// squareChecker() 메서드 정의
	public static boolean squareChecker(int size) {
		
		// for 반복문을 사용해 히스토그램에 속한 각 막대를 순회
		for (int idx = 0, count = 0; idx < histogram.length; idx++) {
			
			// 해당 막대의 높이가 정사각형 크기 이상인 경우 이를 만족하는 막대의 개수를 갱신
			if (histogram[idx] >= size) {
				count++;
				
			// 해당 막대의 높이가 정사각형 크기 미만인 경우 이를 만족하는 막대의 개수를 초기화
			} else {
				count = 0;
			}
			
			// 해당 정사각형을 만들 수 있는 경우 true 반환
			if (count == size)
				return true;
		}
		
		// 해당 정사각형을 만들 수 없는 경우 false 반환
		return false;
	}
}