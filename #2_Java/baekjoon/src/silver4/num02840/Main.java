package silver4.num02840;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 바퀴의 칸 수 및 상덕이가 바퀴를 돌리는 횟수를 각 변수에 할당
		int spaceNum = Integer.parseInt(st.nextToken());
		int spinCnt = Integer.parseInt(st.nextToken());
		
		// 상덕이가 적어 놓은 종이에 해당하는 행운의 바퀴가 존재하는지 여부를 나타낼 변수 isPossible 초기화
		boolean isPossible = true;
		
		// 각 바퀴의 칸에 적힌 알파벳을 저장할 배열 alphabets 초기화
		char[] alphabets = new char[spaceNum];
		
		// fill() 메서드를 사용해 각 바퀴의 칸에 적힌 알파벳을 '?'로 초기화
		Arrays.fill(alphabets, '?');
		
		// while 반복문을 사용해 각 바퀴를 돌린 횟수를 순회
		while (spinCnt-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			
		}
		
		// 상덕이가 적어 놓은 종이에 해당하는 행운의 바퀴가 존재하지 않는 경우 '!'를 출력
		if (!isPossible) {
			out.write("!");
			
		// 
		} else {
			
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}