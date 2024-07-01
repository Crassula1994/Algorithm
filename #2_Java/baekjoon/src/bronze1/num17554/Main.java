package bronze1.num17554;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 전등의 개수, 해커의 프로그램 사용 횟수를 각 변수에 할당
		int lightNum = Integer.parseInt(in.readLine());
		int usageCount = Integer.parseInt(in.readLine());
		
		// 현재 꺼져 있는 전등의 개수 및 최대로 꺼져 있는 전등의 수를 저장할 각 변수 초기화
		int offCount = 0;
		int maxOffCount = 0;
		
		// 현재 전등의 상태를 저장할 배열 lights 초기화
		boolean[] lights = new boolean[lightNum + 1];
		
		// for 반복문을 사용해 각 프로그램 사용 횟수를 순회
		for (int count = 0; count < usageCount; count++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 전등의 번호를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 현재 꺼져 있는 전등의 개수 및 전등의 상태를 갱신
			for (int n = number; n < lights.length; n += number) {
				offCount = (lights[n]) ? offCount - 1 : offCount + 1;
				lights[n] = !lights[n];
			}
			
			// max() 메서드를 사용해 최대로 꺼져 있는 전등의 수를 갱신
			maxOffCount = Math.max(offCount, maxOffCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 최대로 꺼져 있는 전등의 수를 출력
		out.write(String.valueOf(maxOffCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}