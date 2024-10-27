package bronze2.num05032;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 준민이가 가지고 있는 빈 병의 수,
		발견한 빈 병의 수, 새 병으로 바꾸는 데 필요한 빈 병의 수를 각 변수에 할당 */
		int stockCount = Integer.parseInt(st.nextToken());
		int findCount = Integer.parseInt(st.nextToken());
		int changeCount = Integer.parseInt(st.nextToken());
		
		// 준민이가 현재 가진 빈 병의 수, 먹을 수 있는 탄산 음료의 개수를 저장할 각 변수 초기화
		int totalBottles = stockCount + findCount;
		int drinkCount = 0;
		
		// while 반복문을 사용해 더 이상 준민이가 탄산 음료를 먹을 수 없을 때까지 순회
		while (totalBottles >= changeCount) {
			
			// 준민이가 탄산 음료를 교환해 새로 생기는 빈 병의 수를 변수 newBottles에 할당
			int newBottles = totalBottles / changeCount;
			
			// 준민이가 먹을 수 있는 탄산 음료의 개수 및 현재 가진 빈 병의 수를 갱신
			drinkCount += newBottles;
			totalBottles = newBottles + (totalBottles % changeCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 준민이가 먹을 수 있는 탄산 음료의 개수를 출력
		out.write(String.valueOf(drinkCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}