package silver4.num14469;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Cow 클래스 정의
	static class Cow implements Comparable<Cow> {
		
		// 해당 소의 도착 시각과 검문 시간을 저장할 각 변수 초기화
		int arrivalTime;
		int checkTime;
		
		// 매개변수를 입력 받는 생성자 정의
		public Cow(int arrivalTime, int checkTime) {
			this.arrivalTime = arrivalTime;
			this.checkTime = checkTime;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Cow anotherCow) {
			return this.arrivalTime - anotherCow.arrivalTime;
		}		
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 소의 수를 변수 cowNum에 할당
		int cowNum = Integer.parseInt(in.readLine());
		
		// 소가 입장하는 데 걸리는 최소 시간을 저장할 변수 minTime 초기화
		int minTime = 0;
		
		// 각 소의 도착 시각과 검문 시간을 저장할 배열 cows 초기화
		Cow[] cows = new Cow[cowNum];
		
		// for 반복문을 사용해 각 소의 정보를 순회
		for (int idx = 0; idx < cows.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소의 도착 시각과 검문 시간을 각 변수에 할당
			int arrivalTime = Integer.parseInt(st.nextToken());
			int checkTime = Integer.parseInt(st.nextToken());
			
			// 해당 소의 정보를 배열 cows에 저장
			cows[idx] = new Cow(arrivalTime, checkTime);
		}
		
		// sort() 메서드를 사용해 각 소의 도착 시각을 기준으로 오름차순 정렬
		Arrays.sort(cows);
		
		// for 반복문을 사용해 각 소를 순회
		for (Cow cow : cows) {
			
			// 소의 도착 시각이 지난 소의 검문이 끝난 시각과 같거나 그보다 뒤인 경우 입장하는 데 걸리는 최소 시간 갱신
			if (cow.arrivalTime >= minTime) {
				minTime = cow.arrivalTime + cow.checkTime;
			
			// 소의 도착 시각이 지난 소의 검문이 끝난 시각보다 앞선 경우 입장하는 데 걸리는 최소 시간 갱신
			} else {
				minTime += cow.checkTime;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 소가 입장하는 데 걸리는 최소 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}