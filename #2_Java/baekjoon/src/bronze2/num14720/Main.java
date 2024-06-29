package bronze2.num14720;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 우유 가게의 수를 변수 storeNum에 할당
		int storeNum = Integer.parseInt(in.readLine());
		
		// 영학이가 마실 수 있는 우유의 최대 개수, 영학이가 마신 마지막 우유를 저장할 각 변수 초기화
		int maxCount = 0;
		int lastMilk = 2;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 우유 가게를 순회
		for (int store = 0; store < storeNum; store++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 우유의 종류를 변수 category에 할당
			int category = Integer.parseInt(st.nextToken());
			
			// 해당 우유가 다음에 마실 우유인 경우 영학이가 마실 수 있는 우유의 최대 개수, 마신 마지막 우유를 갱신
			if (category == (lastMilk + 1) % 3) {
				maxCount++;
				lastMilk = (lastMilk + 1) % 3;
			}
		}

		// valueOf() 및 write() 메서드를 사용해 영학이가 마실 수 있는 우유의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}