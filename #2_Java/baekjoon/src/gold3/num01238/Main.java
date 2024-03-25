package gold3.num01238;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 학생의 수, 도로의 수, 목적지 마을을 저장할 각 변수 초기화
	static int studentNum;
	static int roadNum;
	static int targetTown;
	
	// 연결된 도로의 정보 및 해당 마을까지의 최소 소요 시간의 값을 저장할 각 배열 초기화
	static List<int[]>[] roads;
	static int[] minTime;
	
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
		
		// 연결된 도로의 정보 및 해당 마을까지의 최소 소요 시간의 값을 저장할 각 배열 초기화
		roads = new ArrayList[studentNum + 1];
		minTime = new int[studentNum + 1];
		
		// for 반복문을 사용해 입력 받은 

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}