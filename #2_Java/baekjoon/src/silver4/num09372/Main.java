package silver4.num09372;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 국가의 수 및 비행기의 종류를 각 변수에 할당
			int countryNum = Integer.parseInt(st.nextToken());
			int airplaneNum = Integer.parseInt(st.nextToken());
			
			// 비행기의 연결 정보를 저장할 배열 flights 초기화
			@SuppressWarnings("unchecked")
			List<Integer>[] flights = new ArrayList[countryNum + 1];
			
			// for 반복문을 사용해 비행기의 연결 정보를 저장할 List 객체 초기화
			for (int idx = 0; idx < flights.length; idx++)
				flights[idx] = new ArrayList<>();
			
			// for 반복문을 사용해 각 비행기의 정보를 순회
			for (int airplane = 0; airplane < airplaneNum; airplane++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 국가를 각 변수에 할당
				int countryA = Integer.parseInt(st.nextToken());
				int countryB = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 각 비행기의 연결 정보를 배열 flights에 저장
				flights[countryA].add(countryB);
				flights[countryB].add(countryA);
			}
			
			// 상근이가 모든 국가를 여행하기 위해 타야 하는 비행기의 최소 개수를 출력
			out.write((countryNum - 1) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}