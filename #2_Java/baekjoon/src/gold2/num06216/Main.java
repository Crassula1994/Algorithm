package gold2.num06216;

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
		
		// 소와 헛간 사이의 소요 시간, 시간당 훼손하는 꽃의 양, 이동 시간 중 훼손하는 꽃의 양을 저장할 각 변수 초기화
		int time;
		int damage;
		double damagePerTime;
		
		// Cow 클래스 정의
		public Cow(int time, int damage) {
			this.time = time;
			this.damage = damage;
			this.damagePerTime = (double) damage / time;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Cow anotherCow) {
			
			// compare() 메서드를 사용해 이동 시간 중 훼손하는 꽃의 양이 많은 순서대로 정렬
			return Double.compare(anotherCow.damagePerTime, this.damagePerTime);
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
		
		// 시간당 훼손되는 꽃의 양 및 최소로 훼손된 꽃의 양을 저장할 각 변수 초기화
		long damagePerTime = 0;
		long minDamage = 0;
		
		// 소와 헛간 사이의 소요 시간 및 시간당 훼손하는 꽃의 양을 저장할 배열 cows 초기화
		Cow[] cows = new Cow[cowNum];
		
		// for 반복문을 사용해 각 소의 정보를 순회
		for (int idx = 0; idx < cows.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소와 헛간 사이의 소요 시간 및
			시간당 훼손하는 꽃의 양을 각 변수에 할당 */
			int time = Integer.parseInt(st.nextToken());
			int damage = Integer.parseInt(st.nextToken());
			
			// 입력 받은 소의 정보를 배열 cows에 저장
			cows[idx] = new Cow(time, damage);
			
			// 시간당 훼손되는 꽃의 양을 갱신
			damagePerTime += damage;
		}
		
		// sort() 메서드를 사용해 소를 이동 시간 중 훼손하는 꽃의 양이 많은 순서대로 정렬
		Arrays.sort(cows);
		
		// for 반복문을 사용해 시간당 훼손되는 꽃의 양 및 최소로 훼손된 꽃의 양을 갱신
		for (Cow cow : cows) {
			damagePerTime -= cow.damage;
			minDamage += damagePerTime * cow.time * 2;
		}
			
		// valueOf() 및 write() 메서드를 사용해 최소로 훼손된 꽃의 양을 출력
		out.write(String.valueOf(minDamage));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}