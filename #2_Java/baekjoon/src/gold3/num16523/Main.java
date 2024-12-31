package gold3.num16523;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 이동 정보를 저장할 배열 trips 초기화
	static Trip[] trips;
	
	// 각 이동 횟수, 할인 횟수, 구간 내 이동 시작 시간에 따른 최소 비용을 저장할 3차원 배열 minCosts 초기화
	static Double[][][] minCosts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Trip 클래스 정의
	static class Trip {
		
		// 이동 시간 및 비용을 저장할 각 변수 초기화
		int duration;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Trip(int duration, int cost) {
			this.duration = duration;
			this.cost = cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이동 횟수를 변수 tripNum에 할당
		int tripNum = Integer.parseInt(in.readLine());
		
		// 각 이동 정보를 저장할 배열 trips 초기화
		trips = new Trip[tripNum];
		
		// 각 이동 횟수, 할인 횟수, 구간 내 이동 시작 시간에 따른 최소 비용을 저장할 3차원 배열 minCosts 초기화
		minCosts = new Double[tripNum][7][121];
		
		// for 반복문을 사용해 각 이동 정보를 순회
		for (int idx = 0; idx < trips.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 이동의 소요 시간 및 비용을 각 변수에 할당
			int duration = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 해당 이동의 정보를 배열 trips에 저장
			trips[idx] = new Trip(duration, cost);
		}
		
		//
		out.write(String.format("%.2f", args));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}