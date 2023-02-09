package bronze1.num2309;

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
		
		// 각 난쟁이가 존재하는지 여부를 담은 배열 dwarves 초기화
		boolean[] dwarves = new boolean[101];
		
		// 난쟁이의 키의 총합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 아홉 난쟁이의 키를 순회
		for (int i = 0; i < 9; i++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 난쟁이의 키를 변수 height에 할당
			int height = Integer.parseInt(in.readLine());
			
			// 난쟁이의 키의 총합에 해당 난쟁이의 키 반영
			sum += height;
			
			// 해당 난쟁이의 존재를 배열 dwarves에 반영
			dwarves[height] = true;
		}
		
		// for 반복문을 사용해 배열 dwarves 순회
		for (int idx = 0; idx < dwarves.length; idx++) {
			
			// (sum - idx - 100)의 값이 인덱스를 넘지 않는 경우
			if (sum - idx >= 100 && sum - idx < 201) {
				
				// 100을 넘어서게 만드는 두 난쟁이의 경우를 제거 후 반복문 탈출
				if (dwarves[idx] && dwarves[sum - idx - 100]) {
					dwarves[idx] = false;
					dwarves[sum - idx - 100] = false;
					break;
				}
			}
		}
		
		// for 반복문을 사용해 배열 dwarves 순회
		for (int idx = 0; idx < dwarves.length; idx++) {
			
			// 해당 난쟁이가 존재하는 경우 write() 메서드를 사용해 난쟁이의 키 출력
			if (dwarves[idx])
				out.write(idx + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}