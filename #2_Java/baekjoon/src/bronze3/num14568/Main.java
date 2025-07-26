package bronze3.num14568;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사탕의 총 개수를 변수 candyNum에 할당
		int candyNum = Integer.parseInt(in.readLine());
		
		// 세 사람이 사탕을 분배하는 방법의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 영훈이가 받는 사탕의 수를 순회
		for (int countY = 1; countY * 2 + 3 <= candyNum; countY++) {
			
			// for 반복문을 사용해 남규가 받는 사탕의 수를 순회
			for (int countN = countY + 2; countN + countY + 1 <= candyNum; countN++) {
				
				// 택희가 받는 사탕의 수가 짝수 개인 경우 세 사람이 사탕을 분배하는 방법의 수를 갱신
				if (((candyNum - countY - countN) & 1) == 0)
					count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 세 사람이 사탕을 분배하는 방법의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}