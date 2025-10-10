package bronze4.num28453;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 레벨의 개수를 변수 levelNum에 할당
		int levelNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 레벨을 순회
		while (levelNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 레벨을 변수 level에 할당
			int level = Integer.parseInt(st.nextToken());
			
			// 해당 레벨이 만렙인 경우 '1'을 출력
			if (level == 300) {
				out.write("1 ");
				
			// 해당 레벨이 구만렙 이상 만렙 미만인 경우 '2'를 출력
			} else if (level >= 275) {
				out.write("2 ");
				
			// 해당 레벨이 뀨만렙 이상 구만렙 미만인 경우 '3'을 출력
			} else if (level >= 250) {
				out.write("3 ");
				
			// 해당 레벨이 뀨만렙 미만인 경우 '4'를 출력
			} else {
				out.write("4 ");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}