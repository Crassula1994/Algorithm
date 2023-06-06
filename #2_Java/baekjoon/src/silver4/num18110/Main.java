package silver4.num18110;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 난이도 의견의 개수를 변수 opinionNum에 할당
		int opinionNum = Integer.parseInt(in.readLine());
		
		// round() 메서드를 사용해 난이도 의견에서 제외할 의견의 수를 계산하고 변수 trimmedOpinion에 할당
		int trimmedOpinion = (int) Math.round(opinionNum * 0.15);
		
		// 각 난이도 의견의 점수를 저장할 PriorityQueue 객체 opinions 초기화
		PriorityQueue<Integer> opinions = new PriorityQueue<>();
		
		// for 반복문을 사용해 입력 받은 각 난이도 의견을 opinions에 추가
		for (int opinion = 0; opinion < opinionNum; opinion++)
			opinions.offer(Integer.parseInt(in.readLine()));
		
		// 확인한 난이도 의견의 개수, 계산을 위해 필요한 난이도 의견의 합을 저장할 각 변수 초기화
		int count = 0;
		int sum = 0;
		
		// while 반복문을 사용해 계산에 필요한 난이도 의견을 순회
		while (opinions.size() > trimmedOpinion) {
			
			// poll() 메서드를 사용해 확인할 난이도 의견을 변수 opinion에 할당
			int opinion = opinions.poll();
			
			// 확인한 난이도 의견의 개수 갱신
			count++;
			
			// 확인한 난이도 의견이 필요 없는 경우 다음 난이도 의견을 순회
			if (count <= trimmedOpinion)
				continue;
			
			// 필요한 난이도 의견을 총합에 합산
			sum += opinion;
		}
		
		// round() 메서드를 사용해 문제의 난이도를 계산하고 변수 difficulty에 할당
		int difficulty = (int) Math.round(sum / (opinionNum - (trimmedOpinion * 2.0)));
		
		// valueOf() 및 write() 메서드를 사용해 계산한 문제의 난이도를 출력
		out.write(String.valueOf(difficulty));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}