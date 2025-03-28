package bronze2.num13410;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 단의 수와 항의 수를 각 변수에 할당
		int tableNum = Integer.parseInt(st.nextToken());
		int termNum = Integer.parseInt(st.nextToken());
		
		// 주어진 단과 항에서 나올 수 있는 가장 큰 거꾸로 구구단의 값을 저장할 변수 maxValue 초기화
		int maxValue = 0;
		
		// for 반복문을 사용해 각 항을 순회
		for (int term = 1; term <= termNum; term++) {
			
			// 해당 항의 구구단 값과 거꾸로 구구단 값을 저장할 각 변수 초기화
			int value = tableNum * term;
			int reversedValue = 0;
			
			// while 반복문을 사용해 해당 항의 거꾸로 구구단 값을 갱신
			while (value > 0) {
				reversedValue *= 10;
				reversedValue += value % 10;
				value /= 10;
			}
			
			// max() 메서드를 사용해 주어진 단과 항에서 나올 수 있는 가장 큰 거꾸로 구구단의 값을 갱신
			maxValue = Math.max(reversedValue, maxValue);
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 단과 항에서 나올 수 있는 가장 큰 거꾸로 구구단의 값을 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}