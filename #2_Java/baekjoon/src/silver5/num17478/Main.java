package silver5.num17478;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 재귀의 횟수를 변수 recurCnt에 할당
		int recurCnt = Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 정해진 문장을 출력
		out.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		// chatterBot() 메서드를 호출해 정해진 문장을 출력
		chatterBot(0, recurCnt, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// chatterBot() 메서드 정의
	public static void chatterBot(int currentCnt, int recurCnt, BufferedWriter out) throws IOException {
		
		// lineMaker() 메서드를 호출해 밑줄을 출력
		lineMaker(currentCnt, out);
		
		// write() 메서드를 사용해 정해진 문구를 출력
		out.write("\"재귀함수가 뭔가요?\"\n");
		
		// 마지막 호출인 경우
		if (currentCnt == recurCnt) {
			
			// lineMaker() 메서드를 호출해 밑줄을 출력
			lineMaker(currentCnt, out);
			
			// write() 메서드를 사용해 정해진 문구를 출력
			out.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			
			// lineMaker() 메서드를 호출해 밑줄을 출력
			lineMaker(currentCnt, out);
			
			// write() 메서드를 사용해 정해진 문구를 출력
			out.write("라고 답변하였지.\n");
			
			// 함수 종료
			return;
		}
		
		// lineMaker() 메서드를 호출해 밑줄을 출력
		lineMaker(currentCnt, out);
		
		// write() 메서드를 사용해 정해진 문구를 출력
		out.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		
		// lineMaker() 메서드를 호출해 밑줄을 출력
		lineMaker(currentCnt, out);
		
		// write() 메서드를 사용해 정해진 문구를 출력
		out.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		
		// lineMaker() 메서드를 호출해 밑줄을 출력
		lineMaker(currentCnt, out);
		
		// write() 메서드를 사용해 정해진 문구를 출력
		out.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		// chatterBot() 메서드를 재귀 호출해 정해진 문장을 출력
		chatterBot(currentCnt + 1, recurCnt, out);
		
		// lineMaker() 메서드를 호출해 밑줄을 출력
		lineMaker(currentCnt, out);
		
		// write() 메서드를 사용해 정해진 문구를 출력
		out.write("라고 답변하였지.\n");
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// lineMaker() 메서드 정의
	public static void lineMaker(int currentCnt, BufferedWriter out) throws IOException {
		
		// for 반복문을 사용해 재귀 횟수만큼 밑줄을 출력
		for (int i = 0; i < 4 * currentCnt; i++)
			out.write("_");
	}
}