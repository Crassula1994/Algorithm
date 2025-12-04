package bronze4.num22015;

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
		
		// 세 사람이 먹은 별사탕의 개수의 합 및 가장 많이 먹은 사람의 별사탕의 개수를 저장할 각 변수 초기화
		int totalCount = 0;
		int maxCount = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 사람이 먹은 별사탕의 개수를 순회
		for (int c = 0; c < 3; c++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 사람이 먹은 별사탕의 개수를 변수 count에 할당
			int count = Integer.parseInt(st.nextToken());
			
			// max() 메서드를 사용해 가장 많이 먹은 사람의 별사탕의 개수를 갱신
			maxCount = Math.max(count, maxCount);
			
			// 세 사람이 먹은 별사탕의 개수의 합을 갱신
			totalCount += count;
		}
		
		// valueOf() 및 write() 메서드를 사용해 추가로 먹어야 하는 별사탕 개수의 최솟값을 출력
		out.write(String.valueOf(maxCount * 3 - totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}