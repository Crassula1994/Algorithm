package bronze3.num05612;

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
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 조사한 시간
		및 조사 시작 시 터널 안의 차량 수를 각 변수에 할당 */
		int totalTime = Integer.parseInt(in.readLine());
		int curCount = Integer.parseInt(in.readLine());
		
		/* 터널 안에 있는 차량의 수의 최댓값 및
		터널 안에 있는 차량의 수가 0보다 작은 경우가 발생했는지 여부를 저장할 각 변수 초기화 */
		int maxCount = curCount;
		boolean isError = false;
		
		// while 반복문을 사용해 각 시간을 순회
		while (totalTime-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 터널 안에 있는 차량의 수를 갱신
			curCount += Integer.parseInt(st.nextToken());
			curCount -= Integer.parseInt(st.nextToken());
			
			// 현재 터널 안에 있는 차량의 수가 0보다 작은 경우 해당 경우가 발생했는지 여부를 갱신 후 반복문 탈출
			if (curCount < 0) {
				isError = true;
				break;
			}
			
			// 현재 터널 안에 있는 차량의 수가 저장된 최댓값보다 큰 경우 최댓값을 갱신
			if (curCount > maxCount)
				maxCount = curCount;
		}
		
		// valueOf() 및 write() 메서드를 사용해 터널 안에 있는 차량의 수의 최댓값을 출력
		out.write((isError) ? "0" : String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}