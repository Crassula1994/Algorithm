package bronze3.num01547;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 컵의 위치를 바꾼 횟수를 변수 shiftNum에 할당
		int shiftNum = Integer.parseInt(in.readLine());
		
		// 공에 위치한 컵의 번호를 저장할 변수 cupNum 초기화
		int cupNum = 1;
		
		// for 반복문을 사용해 각 컵의 위치를 바꾼 방법을 순회
		for (int shift = 0; shift < shiftNum; shift++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 위치를 바꾼 컵의 번호를 각 변수에 할당
			int cup1 = Integer.parseInt(st.nextToken());
			int cup2 = Integer.parseInt(st.nextToken());
			
			// 첫 번째 입력 받은 컵이 현재 공에 위치한 컵인 경우 공에 위치한 컵의 번호를 갱신
			if (cup1 == cupNum) {
				cupNum = cup2;
				
			// 두 번째 입력 받은 컵이 현재 공에 위치한 컵인 경우 공에 위치한 컵의 번호를 갱신
			} else if (cup2 == cupNum) {
				cupNum = cup1;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 공에 위치한 컵을 출력
		out.write(String.valueOf(cupNum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}