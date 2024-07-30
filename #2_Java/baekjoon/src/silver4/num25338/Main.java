package silver4.num25338;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 하체 둘레 공식의 각 정수를 각 변수에 할당
		int numberA = Integer.parseInt(st.nextToken());
		int numberB = Integer.parseInt(st.nextToken());
		int numberC = Integer.parseInt(st.nextToken());
		int numberD = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 바지의 개수를 변수 pantsNum에 할당
		int pantsNum = Integer.parseInt(in.readLine());
		
		// 시루가 입을 수 있는 바지의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 바지를 순회
		for (int pants = 0; pants < pantsNum; pants++) {
			
			//StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 바지의 둘레와 길이를 각 변수에 할당
			int circumference = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// max() 메서드를 사용해 해당 바지에 맞는 시루의 하체 둘레를 계산해 변수 lowerBody에 할당
			int lowerBody = Math.max(numberA * (length - numberB) * (length - numberB) + numberC, numberD);
			
			// 시루가 입을 수 없는 바지인 경우 다음 바지를 순회
			if (circumference != lowerBody)
				continue;
			
			// 시루가 입을 수 있는 바지의 수를 갱신
			count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 시루가 입을 수 있는 바지의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}