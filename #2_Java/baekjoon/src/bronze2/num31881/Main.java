package bronze2.num31881;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 컴퓨터의 개수와 쿼리의 개수를 각 변수에 할당
		int computerNum = Integer.parseInt(st.nextToken());
		int queryNum = Integer.parseInt(st.nextToken());
		
		// 현재 감염되지 않은 컴퓨터의 개수를 저장할 변수 count 초기화
		int count = computerNum;
		
		// 각 컴퓨터의 감염 여부를 저장할 배열 infected 초기화
		boolean[] infected = new boolean[computerNum + 1];
		
		// for 반복문을 사용해 각 쿼리를 순회
		for (int q = 0; q < queryNum; q++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 쿼리와 그 목표 컴퓨터를 각 변수에 할당
			int query = Integer.parseInt(st.nextToken());
			int target = (query == 3) ? 0 : Integer.parseInt(st.nextToken());
			
			// switch 조건문을 사용해 각 쿼리에 따른 명령을 수행
			switch (query) {
			
				// 1번 쿼리인 경우
				case 1:
					
					// 이미 해당 컴퓨터가 감염된 경우 다음 쿼리를 순회
					if (infected[target])
						continue;
					
					// 해당 컴퓨터 감염 처리 및 현재 감염되지 않은 컴퓨터의 개수 갱신
					infected[target] = true;
					count--;
					
					// 조건문 탈출
					break;
					
				// 2번 쿼리인 경우
				case 2:
					
					// 이미 해당 컴퓨터가 감염되지 않은 경우 다음 쿼리를 순회
					if (!infected[target])
						continue;
					
					// 해당 컴퓨터 치료 처리 및 현재 감염되지 않은 컴퓨터의 개수 갱신
					infected[target] = false;
					count++;
					
					// 조건문 탈출
					break;
					
				// 3번 쿼리인 경우 현재 감염되지 않은 컴퓨터의 개수를 출력
				default:
					out.write(count + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}