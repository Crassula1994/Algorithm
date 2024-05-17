package silver3.num01448;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 빨대의 개수를 변수 strawNum에 할당
		int strawNum = Integer.parseInt(in.readLine());
		
		// 각 빨대의 길이를 저장할 배열 straws 초기화
		Integer[] straws = new Integer[strawNum];
		
		// for 반복문을 사용해 입력 받은 각 빨대의 길이를 배열 straws에 저장
		for (int idx = 0; idx < straws.length; idx++)
			straws[idx] = Integer.parseInt(in.readLine());
		
		// reverseOrder() 및 sort() 메서드를 사용해 빨대의 길이를 내림차순으로 정렬
		Arrays.sort(straws, Collections.reverseOrder());
		
		// 삼각형을 만들 수 있는지를 나타낼 변수 isPossible 초기화
		boolean isPossible = false;
		
		// for 반복문을 사용해 가장 긴 변의 길이를 순회
		for (int idx = 0; idx < straws.length - 2; idx++) {
			
			// 삼각형을 만들 수 있는 경우
			if (straws[idx] < straws[idx + 1] + straws[idx + 2]) {
				
				// valueOf() 및 write() 메서드를 사용해 세 변의 길이의 합의 최댓값을 출력
				out.write(String.valueOf(straws[idx] + straws[idx + 1] + straws[idx + 2]));
				
				// 삼각형을 만들 수 있는지 여부를 갱신 후 반복문 탈출
				isPossible = true;
				break;
			}
		}
		
		// 삼각형을 만들 수 없는 경우 -1 출력
		if (!isPossible)
			out.write(String.valueOf(-1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}