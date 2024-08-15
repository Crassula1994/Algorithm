package gold3.num16894;

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
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 숫자를 변수 startNumber에 할당
		long startNumber = Long.parseLong(in.readLine());
		
		// 인수를 찾을 숫자, 해당 숫자를 이루는 인수의 개수를 저장할 각 변수 초기화
		long dividend = startNumber;
		int factorCnt = 0;
			
		// for 반복문을 사용해 각 가능한 인수를 순회
		for (long factor = 2; factor * factor <= dividend && factorCnt < 2; factor++) {
			
			// while 반복문을 사용해 해당 인수로 나누어 떨어지지 않을 때까지 순회
			while (dividend % factor == 0 && factorCnt < 2) {
				
				// 인수를 찾을 숫자 및 해당 숫자를 이루는 인수의 개수를 갱신
				dividend /= factor;
				factorCnt++;
			}
		}
		
		// 나머지가 존재하는 경우 그 자체로 인수이므로 인수의 개수를 갱신
		if (dividend > 1)
			factorCnt++;
		
		// write() 메서드를 사용해 게임에서 이기는 사람을 출력
		out.write((factorCnt == 2) ? "cubelover" : "koosaga");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}