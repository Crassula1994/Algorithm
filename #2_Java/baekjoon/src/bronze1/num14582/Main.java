package bronze1.num14582;

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
		
		// 울림 제미니스가 역전패를 당했는지 여부, 각 팀의 합계 스코어를 나타낼 각 변수 초기화
		boolean isReversed = false;
		int geminisSum = 0;
		int gulliversSum = 0;
		
		// StringTokenizer 객체를 불러와 각 변수에 할당
		StringTokenizer geminis = new StringTokenizer(in.readLine());
		StringTokenizer gullivers = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 이닝의 득점을 순회
		for (int inning = 1; inning < 10; inning++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 이닝의 각 팀 득점을 각 변수에 할당
			int geminisScore = Integer.parseInt(geminis.nextToken());
			int gulliversScore = Integer.parseInt(gullivers.nextToken());
			
			// 울림 제미니스의 득점을 갱신
			geminisSum += geminisScore;
			
			// 울림 제미니스가 스타트링크 걸리버스의 득점을 앞지른 경우 울림 제미니스가 역전패를 당했는지 여부를 갱신 후 반복문 탈출
			if (geminisSum > gulliversSum) {
				isReversed = true;
				break;
			}
			
			// 스타트링크 걸리버스의 득점을 갱신
			gulliversSum += gulliversScore;
		}
		
		// write() 메서드를 사용해 울림 제미니스가 역전패를 당했는지 여부를 출력
		out.write((isReversed) ? "Yes" : "No");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}