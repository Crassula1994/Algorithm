package silver4.num10157;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 공연장의 크기를 각 변수에 할당
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		// 공연장의 좌석을 저장할 2차원 배열 seats 초기화
		int[][] seats = new int[row][column];
		
		// readLine() 및 parseInt() 메서드를 사용해 관객의 대기번호를 변수 targetNum에 할당
		int targetNum = Integer.parseInt(in.readLine());
		
		// 관객의 대기번호가 공연장의 좌석 수를 초과한 경우 0을 출력
		if (targetNum > row * column) {
			out.write("0");
		
		// 관객의 대기번호가 공연장의 좌석 수를 초과하지 않는 경우
		} else {
			
			// 현재의 행과 열의 번호를 담을 각 변수 초기화
			int r = 0;
			int c = 0;
			
			// 좌석을 배정할 관객의 대기번호를 저장할 변수 num 초기화
			int num = 0;
			
			// while 반복문을 사용해 목표로 하는 관객의 대기번호가 나올 때까지 순회
			while (true) {
				
				// while 반복문을 사용해 공연장의 아래쪽 끝에 도달할 때까지 순회
				while (true) {
					
					seats[r][c]
					
				}
				
			}
			
		}
		
		// valueOf() 및 write() 메서드를 사용해 최단 거리의 합 출력
		out.write(String.valueOf(sum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}