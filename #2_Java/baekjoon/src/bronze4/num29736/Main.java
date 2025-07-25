package bronze4.num29736;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사람들이 푼 문제의 수의 범위를 각 변수에 할당
		int startCount = Integer.parseInt(st.nextToken());
		int endCount = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 브실이가 푼 문제와 친구가 될 수 있는 문제 수 차이를 각 변수에 할당
		int targetCount = Integer.parseInt(st.nextToken());
		int difference = Integer.parseInt(st.nextToken());
		
		// max() 메서드를 사용해 브실이가 친구가 될 수 있는 문제 수의 범위를 계산하고 각 변수에 할당
		int minLimit = Math.max(targetCount - difference, 0);
		int maxLimit = targetCount + difference;
		
		// 친구가 될 수 있는 사람이 단 한 명도 없는 경우 'IMPOSSIBLE'을 출력
		if (startCount > maxLimit || endCount < minLimit) {
			out.write("IMPOSSIBLE");
			
		// 친구가 될 수 있는 사람이 있는 경우 해당 사람의 수를 출력
		} else {
			out.write(String.valueOf(Math.min(maxLimit, endCount) - Math.max(minLimit, startCount) + 1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}