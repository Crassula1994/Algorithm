package silver5.num02822;

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
		
		// 총점을 저장할 변수 totalPoint 초기화
		int totalPoint = 0;
		
		// 해당 문제가 최종 점수에 포함되는지를 나타낼 배열 isInclude 초기화
		boolean[] isInclude = new boolean[9];
		
		// 참가자의 점수를 저장할 PriorityQueue 객체 points 초기화
		PriorityQueue<int[]> points = new PriorityQueue<>((p1, p2) -> {
			return p2[1] - p1[1];
		});
		
		// for 반복문을 사용해 입력 받은 각 점수를 순회
		for (int problem = 1; problem <= 8; problem++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 점수를 변수 point에 할당
			int point = Integer.parseInt(in.readLine());
			
			// offer() 메서드를 사용해 해당 점수를 points에 추가
			points.offer(new int[] {problem, point});
		}
		
		// for 반복문을 사용해 가장 높은 점수 5개까지를 순회
		for (int rank = 1; rank <= 5; rank++) {
			
			// poll() 메서드를 사용해 해당 점수 정보를 배열 problem에 할당
			int[] problem = points.poll();
			
			// 해당 점수를 총점에 합산하고, 문제의 번호가 최종 점수에 포함되는지를 갱신
			totalPoint += problem[1];
			isInclude[problem[0]] = true;
		}
		
		// write() 메서드를 사용해 참가자의 총점을 출력
		out.write(totalPoint + "\n");
		
		// for 반복문을 사용해 최종 점수에 포함되는 문제를 출력
		for (int idx = 1; idx <= 8; idx++) {
			if (isInclude[idx])
				out.write(idx + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}