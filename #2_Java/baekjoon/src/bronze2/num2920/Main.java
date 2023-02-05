package bronze2.num2920;

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
		
		// 각 음계를 저장할 배열 scales 초기화
		int[] scales = new int[8];
		
		// for 반복문을 사용해 각 여덟 자리의 숫자를 순회하며 숫자를 배열 scales에 저장
		for (int i = 0; i < 8; i++)
			scales[i] = Integer.parseInt(st.nextToken());
		
		// 첫 음계가 1인 경우
		if (scales[0] == 1) {
			
			// for 반복문을 사용해 두 번째 인덱스부터 마지막 인덱스까지 순회
			for (int i = 1; i < scales.length; i++) {
				
				// 오름차순이 아닌 경우 'mixed' 출력 후 반복문 탈출
				if (scales[i - 1] != scales[i] - 1) {
					out.write("mixed");
					break;
				}
				
				// 오름차순인 경우 'ascending' 출력
				if (i == scales.length - 1)
					out.write("ascending");
			}
		
		// 첫 음계가 8인 경우
		} else if (scales[0] == 8) {
			
			// for 반복문을 사용해 두 번째 인덱스부터 마지막 인덱스까지 순회
			for (int j = 1; j < scales.length; j++) {
				
				// 내림차순이 아닌 경우 'mixed' 출력 후 반복문 탈출
				if (scales[j - 1] != scales[j] + 1) {
					out.write("mixed");
					break;
				}
				
				// 내림차순인 경우 'descending' 출력
				if (j == scales.length - 1)
					out.write("descending");
			}
			
		// 첫 음계가 1과 8이 아닌 경우 'mixed' 출력
		} else {
			out.write("mixed");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}