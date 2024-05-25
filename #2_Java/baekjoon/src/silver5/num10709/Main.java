package silver5.num10709;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 JOI시의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 각 구역이 몇 분 후에 구름이 뜨는지를 저장할 2차원 배열 clouds 초기화
		int[][] clouds = new int[height + 1][width + 1];
		
		// for 반복문을 사용해 빈 구역의 값을 -1로 초기화
		for (int r = 1; r <= height; r++)
			clouds[r][0] = -1;
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 1; r <= height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 각 구역을 순회
			for (int c = 1; c <= width; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 곳의 현재 기상 상태를 변수 weather에 할당
				char weather = line.charAt(c - 1);
				
				// 해당 구역에 구름이 떠 있지 않은 경우
				if (weather == '.') {
					
					// 이전에 구름이 존재하지 않는 경우 구름이 뜨지 않을 것이므로 -1을 저장
					if (clouds[r][c - 1] == -1) {
						clouds[r][c] = -1;
						
					// 이전에 구름이 존재하는 경우 구름이 뜰 시간을 저장
					} else {
						clouds[r][c] = clouds[r][c - 1] + 1;
					}
				}
				
				// write() 메서드를 사용해 해당 구역에 구름이 뜨는 데 필요한 시간을 출력
				out.write(clouds[r][c] + " ");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}