package silver1.num25989;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 반지름의 개수 및 두 구멍 사이의 최소 거리를 각 변수에 할당
		int radiusNum = Integer.parseInt(st.nextToken());
		int minDist = Integer.parseInt(st.nextToken());
		
		// 샤워기 헤드에 만들 수 있는 구멍의 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 반지름을 순회
		while (radiusNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구멍을 뚫을 반지름을 변수 radius에 할당
			int radius = Integer.parseInt(st.nextToken());
			
			/* 지름의 길이가 두 구멍 사이의 최소 거리보다 작거나 같은 경우 구멍은 1개 또는 2개 밖에 뚫을 수 없으므로
			샤워기 헤드에 만들 수 있는 구멍의 최대 개수를 갱신 후 다음 반지름을 순회 */
			if (radius * 2 <= minDist) {
				maxCount = (radius * 2 < minDist) ? maxCount + 1 : maxCount + 2;
				continue;
			}
			
			// asin() 메서드를 사용해 최소 거리일 때 샤워기 헤드에 만들 수 있는 구멍의 최대 개수를 갱신
			maxCount += (int) (Math.PI / Math.asin((double) minDist / (2 * radius)) + 0.00001);
		}
		
		// valueOf() 및 write() 메서드를 사용해 샤워기 헤드에 만들 수 있는 구멍의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}