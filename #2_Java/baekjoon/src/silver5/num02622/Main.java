package silver5.num02622;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 성냥개비의 개수를 변수 matchNum에 할당
		int matchNum = Integer.parseInt(in.readLine());
		
		// 만들 수 있는 삼각형의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 가능한 두 변의 길이를 순회
		for (int side1 = 1; side1 <= matchNum - 2; side1++) {
			for (int side2 = side1; side2 <= matchNum - side1 - side2; side2++) {
				
				// 나머지 가장 긴 변의 길이를 변수 side3에 할당
				int side3 = matchNum - side1 - side2;
				
				// 각 변의 길이로 삼각형을 만들 수 있는 경우 만들 수 있는 삼각형의 개수를 갱신
				if (side1 + side2 > side3)
					count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 삼각형의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}