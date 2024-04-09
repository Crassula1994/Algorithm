package gold5.num02166;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 다각형의 점 개수를 변수 apexNum에 할당
		int apexNum = Integer.parseInt(in.readLine());
		
		// 각 다각형의 점 좌표를 저장할 2차원 배열 coordinates 초기화
		long[][] coordinates = new long[apexNum + 2][2];

		// for 반복문을 사용해 입력 받은 각 다각형의 좌표를 순회
		for (int idx = 1; idx <= apexNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseLong() 메서드를 사용해 다각형의 점 좌표를 2차원 배열 coordinates에 저장
			coordinates[idx][0] = Long.parseLong(st.nextToken());
			coordinates[idx][1] = Long.parseLong(st.nextToken());
		}
		
		// 신발끈 공식을 위한 처음과 마지막 다각형의 좌표를 갱신
		coordinates[0][0] = coordinates[apexNum][0];
		coordinates[0][1] = coordinates[apexNum][1];
		coordinates[apexNum + 1][0] = coordinates[1][0];
		coordinates[apexNum + 1][1] = coordinates[1][1];
		
		// 다각형의 면적을 저장할 변수 area 초기화
		long area = 0;
		
		// for 반복문을 사용해 신발끈 공식을 통한 다각형의 면적을 계산
		for (int idx = 1; idx <= apexNum; idx++)
			area += coordinates[idx][0] * (coordinates[idx + 1][1] - coordinates[idx - 1][1]);
		
		// abs(), format(), write() 메서드를 사용해 신발끈 공식을 통한 다각형의 면적을 소수점 첫째 자리까지 출력
		out.write(String.format("%.1f", 0.5 * Math.abs(area)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}