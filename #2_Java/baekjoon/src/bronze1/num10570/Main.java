package bronze1.num10570;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 전체 테스트의 개수를 변수 testNum에 할당
		int testNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트를 순회
		while (testNum-- > 0) {
			
			// 가장 많이 선택된 수와 그 개수를 저장할 각 변수 초기화
			int maxNumber = Integer.MAX_VALUE;
			int maxCount = 0;
			
			// 쪽지의 개수를 저장할 배열 noteCounts 초기화
			int[] noteCounts = new int[1001];
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 쪽지의 개수를 변수 noteNum에 할당
			int noteNum = Integer.parseInt(in.readLine());
			
			// while 반복문을 사용해 각 쪽지를 순회
			while (noteNum-- > 0) {
				
				// readLine() 및 parseInt() 메서드를 사용해 해당 쪽지에 적힌 숫자를 변수 number에 할당
				int number = Integer.parseInt(in.readLine());
				
				// 해당 숫자가 적힌 쪽지의 개수를 갱신
				noteCounts[number]++;
				
				// 해당 숫자가 적힌 쪽지의 개수를 변수 count에 할당
				int count = noteCounts[number];
				
				// 해당 숫자가 현재 가장 많이 선택된 숫자인 경우 선택된 숫자와 그 개수를 갱신
				if (count > maxCount || (count == maxCount && number < maxNumber)) {
					maxCount = count;
					maxNumber = number;
				}
			}
			
			// write() 메서드를 사용해 쪽지에서 가장 많이 선택된 수를 출력
			out.write(maxNumber + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}