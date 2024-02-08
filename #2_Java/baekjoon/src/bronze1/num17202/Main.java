package bronze1.num17202;

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
		
		// readLine() 메서드를 사용해 입력 받은 핸드폰 번호를 각 변수에 할당
		String phoneNumberA = in.readLine();
		String phoneNumberB = in.readLine();
		
		// 핸드폰 번호 궁합률을 계산할 2차원 배열 calculator 초기화
		int[][] calculator = new int[15][16];
		
		// for 반복문을 사용해 A의 핸드폰 번호를 배열 calculator에 저장
		for (int idx = 0; idx < phoneNumberA.length(); idx++)
			calculator[0][idx * 2] = phoneNumberA.charAt(idx) - '0';
		
		// for 반복문을 사용해 B의 핸드폰 번호를 배열 calculator에 저장
		for (int idx = 0; idx < phoneNumberB.length(); idx++)
			calculator[0][idx * 2 + 1] = phoneNumberB.charAt(idx) - '0';
		
		// for 반복문을 사용해 핸드폰 번호 궁합률을 계산
		for (int r = 1; r < 15; r++) {
			for (int c = 0; c < 16 - r; c++)
				calculator[r][c] = (calculator[r - 1][c] + calculator[r - 1][c + 1]) % 10;
		}
		
		// valueOf() 및 write() 메서드를 사용해 핸드폰 번호 궁합률을 출력
		out.write(String.valueOf(calculator[14][0]) + String.valueOf(calculator[14][1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}