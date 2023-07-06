package bronze3.num01703;

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

		// while 반복문을 사용해 각 나무를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 나무의 나이를 변수 age에 할당
			int age = Integer.parseInt(st.nextToken());
			
			// 나무의 나이가 0인 경우 반복문 탈출
			if (age == 0)
				break;
			
			// 해당 나무에 달려있는 잎의 수를 저장할 변수 count 초기화
			int count = 1;
			
			// for 반복문을 사용해 각 나무의 성장연도를 순회
			for (int a = 0; a < age; a++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 생장점이 나뉜 가지의 숫자, 가지치기 한 가지의 수를 각 변수에 할당
				int splitBranch = Integer.parseInt(st.nextToken());
				int prunedBranch = Integer.parseInt(st.nextToken());
				
				// 나무에 달려있는 잎의 수를 갱신
				count = count * splitBranch - prunedBranch;
			}
			
			// write() 메서드를 사용해 해당 나무에 달려있는 잎의 수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}