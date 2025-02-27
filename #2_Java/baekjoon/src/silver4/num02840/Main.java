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
		
		// 현재 화살표의 위치를 나타낼 변수 curIdx 초기화
		int curIdx = 0;
		
		// 각 바퀴의 칸에 적힌 알파벳 및 해당 알파벳을 사용했는지 여부를 저장할 각 배열 초기화
		char[] alphabets = new char[spaceNum];
		boolean[] used = new boolean[26];
		
		// fill() 메서드를 사용해 각 바퀴의 칸에 적힌 알파벳을 '?'로 초기화
		Arrays.fill(alphabets, '?');
		
		// while 반복문을 사용해 각 바퀴를 돌린 횟수를 순회
		while (spinCnt-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			/* nextToken(), parseInt(), charAt() 메서드를 사용해 입력 받은 화살표가 가리키는 글자가 바뀐 횟수
			및 회전을 멈추었을 때 화살표가 가리키는 글자를 각 변수에 할당 */
			int count = Integer.parseInt(st.nextToken());
			char result = st.nextToken().charAt(0);
			
			// 현재 화살표의 위치를 갱신
			curIdx = (curIdx + count) % spaceNum;
			
			// 이미 해당 칸에 다른 알파벳이 존재하는 경우 반복문 탈출
			if (alphabets[curIdx] != '?' && alphabets[curIdx] != result)
				break;
			
			// 이미 해당 알파벳을 다른 칸에 저장한 경우 반복문 탈출
			if (alphabets[curIdx] == '?' && used[result - 'A'])
				break;
			
			// 현재 화살표의 위치에 해당 알파벳을 저장
			alphabets[curIdx] = result;
			
			// 해당 알파벳을 사용한 것으로 처리
			used[result - 'A'] = true;
		}
		
		// 상덕이가 적어 놓은 종이에 해당하는 행운의 바퀴가 존재하지 않는 경우 '!'를 출력
		if (spinCnt > -1) {
			out.write("!");
			
		// 상덕이가 적어 놓은 종이에 해당하는 행운의 바퀴가 존재하는 경우
		} else {
			
			// for 반복문을 사용해 현재 화살표를 기준으로 알파벳을 시계 방향으로 출력
			for (int idx = curIdx; idx >= 0; idx--)
				out.write(alphabets[idx]);
			
			// for 반복문을 사용해 현재 화살표를 기준으로 알파벳을 시계 방향으로 출력
			for (int idx = alphabets.length - 1; idx > curIdx; idx--)
				out.write(alphabets[idx]);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}