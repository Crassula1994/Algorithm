package gold5.num30641;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 게임에서 사용된 단어의 개수를 나눌 숫자를 나타낼 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 회문의 길이 범위를 각 변수에 할당
		int lowerLimit = Integer.parseInt(st.nextToken());
		int upperLimit = Integer.parseInt(st.nextToken());
		
		// 호영이가 승자인지 여부 및 게임에서 사용된 단어의 개수를 저장할 각 변수 초기화
		boolean isWinner = (lowerLimit == 1 && upperLimit == 1) || lowerLimit == 2;
		long totalCount = 0;
		
		// 각 회문의 길이별 사용된 단어의 개수를 저장할 배열 counts 초기화
		long[] counts = new long[upperLimit + 1];
		
		// for 반복문을 사용해 각 회문의 길이를 순회
		for (int length = 1; length <= upperLimit; length++) {
			
			// 회문의 길이가 1 또는 2인 경우 단어의 개수를 갱신
			if (length < 3) {
				counts[length] = 1;
				
			// 회문의 길이가 3 이상인 홀수인 경우 단어의 개수를 갱신
			} else if (length % 2 != 0) {
				counts[length] = (counts[length - 1] * 26) % DIVISOR;
			
			// 회문의 길이가 3 이상인 짝수인 경우 단어의 개수를 갱신
			} else {
				counts[length] = counts[length - 1];
			}
			
			// 해당 회문의 길이가 범위에 포함되는 경우 게임에서 사용된 단어의 개수를 갱신
			if (length >= lowerLimit)
				totalCount = (totalCount + counts[length]) % DIVISOR;
		}
		
		// write() 메서드를 사용해 게임에서 이긴 사람을 출력
		out.write((isWinner) ? "H" : "A");
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// valueOf() 및 write() 메서드를 사용해 게임에서 사용된 단어의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}