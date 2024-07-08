package bronze1.num24243;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 스크린의 세로 크기 및 가로 크기, 기차역의 수를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int stationNum = Integer.parseInt(st.nextToken());
		
		// 현재 일치하는 스크린의 개수를 저장할 변수 count 초기화
		int count = stationNum;
		
		// 각 역의 스크린이 현재 스크린과 일치하는지 여부를 저장할 배열 matched 초기화
		boolean[] matched = new boolean[stationNum];
		
		// fill() 메서드를 사용해 각 역의 스크린의 일치 여부를 초기화
		Arrays.fill(matched, true);
		
		// 현재 스크린을 저장할 2차원 배열 screen 초기화
		char[][] screen = new char[height][width];
		
		// 각 기차역의 스크린을 저장할 3차원 배열 stations 초기화
		char[][][] stations = new char[stationNum][height][width];
		
		// for 반복문을 사용해 각 기차역을 순회
		for (int station = 0; station < stationNum; station++) {
			
			// for 반복문을 사용해 해당 기차역의 스크린을 3차원 배열 stations에 저장
			for (int r = 0; r < height; r++)
				stations[station][r] = in.readLine().toCharArray();
		}
		
		// for 반복문을 사용해 현재 스크린을 2차원 배열 screen에 저장
		for (int r = 0; r < height; r++)
			screen[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 스크린의 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 칸이 꺼져 있는 경우 다음 칸을 순회
				if (screen[r][c] == '.')
					continue;
				
				// for 반복문을 사용해 각 역을 순회
				for (int station = 0; station < stationNum; station++) {
					
					// 해당 역의 스크린이 일치하지 않는 스크린인 경우 다음 역을 순회
					if (!matched[station])
						continue;
					
					// 해당 역의 스크린과 일치하지 않는 경우 스크린의 일치 여부 및 그 개수를 갱신
					if (stations[station][r][c] == '.') {
						matched[station] = false;
						count--;
					}
				}
			}
		}
		
		// write() 메서드를 사용해 다음 역이 어떤 역인지 알 수 있는지 여부를 출력
		out.write((count == 1) ? "yes" : "no");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}