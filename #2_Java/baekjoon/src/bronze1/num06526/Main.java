package bronze1.num06526;

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

		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 순열의 원소 개수를 변수 maxElement에 할당
			int maxElement = Integer.parseInt(in.readLine());
			
			// 순열의 원소 개수가 0인 경우 반복문 탈출
			if (maxElement == 0)
				break;
			
			// 해당 순열이 모호한 순열인지 여부를 저장할 변수 isAmbiguous 초기화
			boolean isAmbiguous = true;
			
			// 입력 받은 순열을 저장할 배열 permutation 초기화
			int[] permutation = new int[maxElement + 1];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 순열을 배열 permutation에 저장
			for (int idx = 1; idx < permutation.length; idx++)
				permutation[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 순열의 원소를 순회
			for (int element = 1; element <= maxElement; element++) {
				
				// 해당 순열이 모호한 순열이 아닌 경우 해당 순열이 모호한 순열인지 여부를 갱신 후 반복문 탈출
				if (permutation[permutation[element]] != element) {
					isAmbiguous = false;
					break;
				}
			}
			
			// write() 메서드를 사용해 해당 순열이 모호한 순열인지 여부를 출력
			out.write((isAmbiguous) ? "ambiguous" : "not ambiguous");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}