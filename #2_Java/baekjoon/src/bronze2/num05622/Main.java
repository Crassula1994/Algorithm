package bronze2.num05622;

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
	
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 배열 characterArray에 저장
		char[] characterArray = in.readLine().toCharArray();
		
		// 각 알파벳별 걸리는 시간을 담은 배열 time 초기화
		int[] time = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
		
		// 전화를 걸기 위해 필요한 총 시간을 저장할 변수 totalTime 초기화
		int totalTime = 0;
		
		// for 반복문을 사용해 배열 characterArray의 각 원소를 순회
		for (char character : characterArray)

			// 해당 알파벳의 소요 시간을 총 시간에 더해 갱신
			totalTime += time[character - 'A'];
		
		// valueOf(), write() 메서드를 사용해 총 소요 시간를 출력
		out.write(String.valueOf(totalTime));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}