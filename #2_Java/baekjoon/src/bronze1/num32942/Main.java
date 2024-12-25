package bronze1.num32942;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방정식의 계수를 각 변수에 할당
		int coefficientX = Integer.parseInt(st.nextToken());
		int coefficientY = Integer.parseInt(st.nextToken());
		int constant = Integer.parseInt(st.nextToken());
		
		// 각 정점에서 간선을 1개 지나서 도착할 수 있는 정점들을 저장할 배열 nodes 초기화
		List<Integer>[] nodes = new ArrayList[11];
		
		// for 반복문을 사용해 각 정점에서 간선을 1개 지나서 도착할 수 있는 정점들을 저장할 각 List 객체 초기화
		for (int idx = 0; idx < nodes.length; idx++)
			nodes[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 가능한 x와 y의 조합을 순회
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				
				// 해당 방정식의 그래프가 해당 조합의 점을 지나는 경우 간선을 추가
				if (coefficientX * x + coefficientY * y == constant)
					nodes[x].add(y);
			}
		}
		
		// for 반복문을 사용해 각 정점을 순회
		for (int curNode = 1; curNode <= 10; curNode++) {
			
			// 해당 정점에서 간선을 1개 지나서 도착할 수 있는 정점이 없는 경우 0을 출력
			if (nodes[curNode].isEmpty()) {
				out.write(String.valueOf(0));
				
			// 해당 정점에서 간선을 1개 지나서 도착할 수 있는 정점이 있는 경우
			} else {
				
				// for 반복문을 사용해  해당 정점에서 간선을 1개 지나서 도착할 수 있는 정점을 출력
				for (int nextNode : nodes[curNode])
					out.write(nextNode + " ");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}