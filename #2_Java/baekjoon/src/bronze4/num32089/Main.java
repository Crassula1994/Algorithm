package bronze4.num32089;

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
		
		// while 반복문을 사용해 각 데이터 세트를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 신입 동아리원의 수가 기록된 연도의 수를 변수 yearNum에 할당
			int yearNum = Integer.parseInt(in.readLine());
			
			// 모든 데이터 세트를 확인한 경우 반복문 탈출
			if (yearNum == 0)
				break;
			
			// 현재 동아리원 및 최대 동아리원의 수를 저장할 각 변수 초기화
			int curCount = 0;
			int maxCount = 0;
			
			// 각 연도별 신입 동아리원의 수를 저장할 배열 counts 초기화
			int[] counts = new int[yearNum + 3];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 연도를 순회
			for (int idx = 3; idx < counts.length; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 연도의 신입 동아리원의 수를 배열 counts에 저장
				counts[idx] = Integer.parseInt(st.nextToken());
				
				// 현재 동아리원의 수를 갱신
				curCount += counts[idx] - counts[idx - 3];
				
				// max() 메서드를 사용해 최대 동아리원의 수를 갱신
				maxCount = Math.max(curCount, maxCount);
			}
			
			// write() 메서드를 사용해 최대 동아리원의 수를 출력
			out.write(maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}