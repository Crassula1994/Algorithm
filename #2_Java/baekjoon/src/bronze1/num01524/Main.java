package bronze1.num01524;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 빈 줄을 제거
			in.readLine();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 세준이와 세비의 병사 수를 각 변수에 할당
			int countSJ = Integer.parseInt(st.nextToken());
			int countSB = Integer.parseInt(st.nextToken());
			
			// 세준이와 세비의 가장 강한 병사의 힘을 저장할 각 변수 초기화
			int maxSoldierSJ = 0;
			int maxSoldierSB = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 세준이의 가장 강한 병사를 갱신
			while (countSJ-- > 0)
				maxSoldierSJ = Math.max(Integer.parseInt(st.nextToken()), maxSoldierSJ);
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 세비의 가장 강한 병사를 갱신
			while (countSB-- > 0)
				maxSoldierSB = Math.max(Integer.parseInt(st.nextToken()), maxSoldierSB);
			
			// write() 메서드를 사용해 세준이와 세비 중 이기는 사람을 출력
			out.write((maxSoldierSJ >= maxSoldierSB) ? "S" : "B");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}