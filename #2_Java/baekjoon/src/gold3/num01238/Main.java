package gold3.num01238;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 학생의 수, 도로의 수, 목적지 마을을 저장할 각 변수 초기화
	static int studentNum;
	static int roadNum;
	static int targetTown;
	
	// 연결된 도로의 정보를 저장할 각 배열 초기화
	static List<int[]>[] toRoads;
	static List<int[]>[] fromRoads;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수, 도로의 수, 목적지 마을을 각 변수에 할당
		studentNum = Integer.parseInt(st.nextToken());
		roadNum = Integer.parseInt(st.nextToken());
		targetTown = Integer.parseInt(st.nextToken());
		
		// 연결된 도로의 정보를 저장할 각 배열 초기화
		toRoads = new ArrayList[studentNum + 1];
		fromRoads = new ArrayList[studentNum + 1];	
		
		// for 반복문을 사용해 연결된 도로의 정보를 저장할 각 배열의 원소를 초기화
		for (int idx = 0; idx <= studentNum; idx++) {
			toRoads[idx] = new ArrayList<>();
			fromRoads[idx] = new ArrayList<>();			
		}
		
		// 해당 마을과 목적지 마을 사이의 최소 소요 시간의 값을 저장할 각 배열 초기화
		int[] toMinTime = new int[studentNum + 1];
		int[] fromMinTime = new int[studentNum + 1];
		
		// fill() 메서드를 사용해 각 배열의 최소 소요 시간의 값을 초기화
		Arrays.fill(toMinTime, Integer.MAX_VALUE);
		Arrays.fill(fromMinTime, Integer.MAX_VALUE);
		
		// for 반복문을 사용해 각 도로의 정보를 순회
		for (int road = 0; road < roadNum; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도로의 시작점, 끝점, 소요 시간을 각 변수에 할당
			int fromTown = Integer.parseInt(st.nextToken());
			int toTown = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 연결된 도로의 정보를 각 배열에 추가
			toRoads[toTown].add(new int[] {fromTown, time});
			fromRoads[fromTown].add(new int[] {toTown, time});
		}
		
		// timeCalculator() 메서드를 호출해 최소 소요 시간의 값을 갱신
		timeCalculator(toMinTime);
		timeCalculator(fromMinTime);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	public static void timeCalculator(int[] fromMinTime) {
		// TODO Auto-generated method stub
		
	}
}