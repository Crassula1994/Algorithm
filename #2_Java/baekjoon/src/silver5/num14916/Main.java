package silver5.num14916;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 거스름돈의 액수를 변수 change에 할당
		int change = Integer.parseInt(in.readLine());
		
		// 거스름돈의 최소 개수를 저장할 변수 count 초기화
		int minCount = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 5원을 사용하는 각 경우를 순회
		for (int n = 0; n <= change / 5; n++) {
			
			// 남은 거스름돈을 저장할 변수 remains 초기화
			int remains = change - 5 * n;
			
			// 2원으로 나누어 떨어지지 않는 경우 다음 경우를 순회
			if (remains % 2 != 0)
				continue;
			
			// min() 메서드를 사용해 거스름돈의 최소 개수를 갱신
			minCount = Math.min(n + remains / 2, minCount);
		}
		
		// 거슬러 줄 수 없는 경우 -1을 출력
		if (minCount == Integer.MAX_VALUE) {
			out.write(String.valueOf(-1));
		
		// 거슬러 줄 수 있는 경우 거스름돈 동전의 최소 개수를 출력
		} else {
			out.write(String.valueOf(minCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}