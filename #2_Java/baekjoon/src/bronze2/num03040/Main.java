package bronze2.num03040;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 아홉 난쟁이의 모자에 적힌 숫자, 해당 난쟁이가 진짜인지를 저장할 각 배열 초기화
	static int[] dwarves = new int[9];
	static boolean[] isGenuine = new boolean[9];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 입력 받은 아홉 난쟁이의 모자에 적힌 숫자를 배열 dwarves에 저장
		for (int idx = 0; idx < 9; idx++)
			dwarves[idx] = Integer.parseInt(in.readLine());
		
		// dwarfFinder() 메서드를 호출해 일곱 난쟁이가 쓴 모자에 쓰여 있는 수를 출력
		dwarfFinder(0, 0, 0, out);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// dwarfFinder() 메서드 정의
	public static void dwarfFinder(int start, int selected, int sum, BufferedWriter out) throws IOException {
		
		// 일곱 명의 난쟁이를 모두 선택한 경우
		if (selected == 7) {

			// 일곱 난쟁이를 제대로 찾은 경우
			if (sum == 100) {
				
				// for 반복문을 사용해 각 난쟁이를 순회
				for (int idx = 0; idx < 9; idx++) {
					
					// 해당 난쟁이가 선택된 경우 해당 난쟁이를 출력
					if (isGenuine[idx])
						out.write(dwarves[idx] + "\n");
				}
				
				// flush() 메서드를 사용해 출력하려는 내용을 출력
				out.flush();
				
				// exit() 메서드를 사용해 JVM을 정상 종료
				System.exit(0);
			}
			
			// 메서드 종료
			return;
		}
		
		// 끝에 도달한 경우 메서드 종료
		if (start >= 9)
			return;
		
		// 해당 난쟁이를 선택 처리
		isGenuine[start] = true;
		
		// dwarfFinder() 메서드 재귀 호출
		dwarfFinder(start + 1, selected + 1, sum + dwarves[start], out);
		
		// 해당 난쟁이를 선택하지 않은 것으로 처리
		isGenuine[start] = false;
		
		// dwarfFinder() 메서드 재귀 호출
		dwarfFinder(start + 1, selected, sum, out);
	}
}