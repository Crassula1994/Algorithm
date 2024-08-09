package silver5.num03135;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 현재 주파수와 듣고 싶은 주파수를 각 변수에 할당
		int currentFreq = Integer.parseInt(st.nextToken());
		int targetFreq = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 정해진 주파수의 개수를 변수 buttonNum에 할당
		int buttonNum = Integer.parseInt(in.readLine());
		
		// abs() 메서드를 사용해 목표로 하는 주파수까지 눌러야 하는 버튼 수의 최솟값을 저장할 변수 minCount 초기화
		int minCount = Math.abs(targetFreq - currentFreq);
		
		// for 반복문을 사용해 각 지정된 주파수를 순회
		for (int button = 0; button < buttonNum; button++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 지정된 주파수를 변수 speedFreq에 할당
			int speedFreq = Integer.parseInt(in.readLine());
			
			// abs() 및 min() 메서드를 사용해 목표로 하는 주파수까지 눌러야 하는 버튼 수의 최솟값을 갱신
			minCount = Math.min(Math.abs(targetFreq - speedFreq) + 1, minCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표로 하는 주파수까지 눌러야 하는 버튼 수의 최솟값을 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}