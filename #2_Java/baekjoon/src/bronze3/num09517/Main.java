package bronze3.num09517;

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
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 게임이 시작했을 때
		폭탄을 들고 있는 사람의 번호와 질문의 개수를 각 변수에 할당 */
		int curPlayer = Integer.parseInt(in.readLine());
		int questionNum = Integer.parseInt(in.readLine());
		
		// 게임으로부터 흐른 시간을 저장할 변수 curTime 초기화
		int curTime = 0;
		
		// while 반복문을 사용해 각 질문을 순회
		while (questionNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 게임으로부터 흐른 시간을 갱신
			curTime += Integer.parseInt(st.nextToken());
			
			// 폭탄이 터진 경우 반복문 탈출
			if (curTime >= 210)
				break;
			
			// 해당 플레이어의 대답이 맞은 경우 현재 플레이어를 갱신
			if (st.nextToken().equals("T"))
				curPlayer = curPlayer % 8 + 1;
		}
		
		// valueOf() 및 write() 메서드를 사용해 폭탄을 터뜨린 사람의 번호를 출력
		out.write(String.valueOf(curPlayer));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}