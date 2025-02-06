package bronze1.num17247;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 높이와 가로를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 두 1의 위치를 저장할 각 변수 초기화
		int startR = 0;
		int startC = 0;
		int endR = 0;
		int endC = 0;
		
		// for 반복문을 사용해 각 문자열의 높이를 순회
		outer: for (int r = 1; r <= height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int c = 1; c <= width; c++) {
				
				// 해당 숫자가 0인 경우 다음 숫자를 순회
				if (st.nextToken().equals("0"))
					continue;
				
				// 시작 위치를 찾지 못한 경우 시작 위치를 갱신
				if (startR == 0) {
					startR = r;
					startC = c;
					
				// 시작 위치를 찾은 경우 끝 위치를 갱신 후 반복문 탈출
				} else {
					endR = r;
					endC = c;
					break outer;
				}
			}
		}
		
		// abs(), valueOf(), write() 메서드를 사용해 두 1 사이의 택시 거리를 출력
		out.write(String.valueOf(endR - startR + Math.abs(endC - startC)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}