package silver3.num19941;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 식탁의 길이 및 햄버거를 선택할 수 있는 거리를 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 사람과 햄버거의 위치를 배열 table에 저장
		char[] table = in.readLine().toCharArray();
		
		// 해당 햄버거를 먹었는지 여부를 저장할 배열 isEaten 초기화
		boolean[] isEaten = new boolean[length];
		
		// 햄버거를 먹을 수 있는 최대 사람 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// for 반복문을 사용해 식탁의 각 위치를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 위치에 햄버가가 있는 경우 다음 위치를 순회
			if (table[idx] == 'H')
				continue;
				
			// for 반복문을 사용해 햄버거를 먹을 수 있는 범위를 순회
			for (int r = Math.max(idx - distance, 0); r <= Math.min(idx + distance, length - 1); r++) {
				
				// 해당 위치에 햄버거가 있고 아직 먹지 않은 경우
				if (table[r] == 'H' && !isEaten[r]) {
					
					// 해당 위치의 햄버거를 먹은 것으로 처리 및 햄버거를 먹을 수 있는 최대 사람 수 갱신
					isEaten[r] = true;
					maxCount++;
					
					// 반복문 탈출
					break;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 햄버거를 먹을 수 있는 최대 사람 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}