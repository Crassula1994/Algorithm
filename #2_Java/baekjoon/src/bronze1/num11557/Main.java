package bronze1.num11557;

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
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학교의 숫자를 변수 univNum에 할당
			int univNum = Integer.parseInt(in.readLine());
			
			// 가장 술 소비가 많은 학교의 이름과 소비한 술의 양을 저장할 각 변수 초기화
			String maxUniv = "";
			int maxAmount = Integer.MIN_VALUE;
			
			// for 반복문을 사용해 각 대학교를 순회
			for (int u = 0; u < univNum; u++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 대학교의 이름과 술 소비량을 각 변수에 할당
				String name = st.nextToken();
				int amount = Integer.parseInt(st.nextToken());
				
				// 해당 대학교가 술 소비가 가장 많은 경우 가장 술 소비가 많은 학교의 이름과 소비한 술의 양을 갱신
				if (amount > maxAmount) {
					maxAmount = amount;
					maxUniv = name;
				}
			}
			
			// write() 메서드를 사용해 가장 술 소비가 많은 학교의 이름을 출력
			out.write(maxUniv + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}