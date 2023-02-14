package silver5.num7568;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수를 변수 personNum에 할당
		int personNum = Integer.parseInt(in.readLine());
		
		// 각 사람의 몸무게와 키를 저장할 2차원 배열 weightHeight 초기화
		int[][] weightHeight = new int[personNum][2];
		
		// 각 사람의 순위를 저장할 배열 rank 초기화
		int[] rank = new int[personNum];
		
		// for 반복문을 사용해 각 사람의 몸무게와 키를 순회
		for (int p = 0; p < personNum; p++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 몸무게와 키를 배열 weightHeight에 저장
			weightHeight[p][0] = Integer.parseInt(st.nextToken());
			weightHeight[p][1] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 사람을 순회
		for (int p = 0; p < personNum; p++) {
			
			// 해당 사람의 순위 초기화
			rank[p] += 1;
			
			// for 반복문을 사용해 다른 사람의 키와 몸무게를 순회
			for (int q = p + 1; q < personNum; q++) {
				
				// 다른 사람보다 덩치가 큰 경우 다른 사람의 순위 증가
				if (weightHeight[p][0] > weightHeight[q][0] && weightHeight[p][1] > weightHeight[q][1]) {
					rank[q] += 1;
				
				// 다른 사람보다 덩치가 작은 경우 해당 사람의 순위 증가 
				} else if (weightHeight[p][0] < weightHeight[q][0] && weightHeight[p][1] < weightHeight[q][1]) {
					rank[p] += 1;
				}
			} 
		}
		
		// for 반복문을 사용해 각 덩치 등수를 출력
		for (int idx = 0; idx < rank.length; idx++)
			out.write(rank[idx] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}