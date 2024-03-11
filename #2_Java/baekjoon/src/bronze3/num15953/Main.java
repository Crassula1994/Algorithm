package bronze3.num15953;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 등수를 각 변수에 할당
			int rankA = Integer.parseInt(st.nextToken());
			int rankB = Integer.parseInt(st.nextToken());
			
			// 총 상금의 액수를 저장할 변수 sum 초기화
			int sum = 0;
			
			// 제1회 코드 페스티벌 본선에 진출한 경우
			if (rankA > 0) {
				
				// 1등을 한 경우 상금을 갱신
				if (rankA < 2) {
					sum += 5000000;
				
				// 2등을 한 경우 상금을 갱신
				} else if (rankA < 4) {
					sum += 3000000;
				
				// 3등을 한 경우 상금을 갱신
				} else if (rankA < 7) {
					sum += 2000000;
					
				// 4등을 한 경우 상금을 갱신
				} else if (rankA < 11) {
					sum += 500000;
					
				// 5등을 한 경우 상금을 갱신
				} else if (rankA < 16) {
					sum += 300000;
					
				// 6등을 한 경우 상금을 갱신
				} else if (rankA < 22) {
					sum += 100000;
				}
			}
			
			// 제2회 코드 페스티벌 본선에 진출한 경우
			if (rankB > 0) {
				
				// 1등을 한 경우 상금을 갱신
				if (rankB < 2) {
					sum += 5120000;
				
				// 2등을 한 경우 상금을 갱신
				} else if (rankB < 4) {
					sum += 2560000;
				
				// 3등을 한 경우 상금을 갱신
				} else if (rankB < 8) {
					sum += 1280000;
					
				// 4등을 한 경우 상금을 갱신
				} else if (rankB < 16) {
					sum += 640000;
					
				// 5등을 한 경우 상금을 갱신
				} else if (rankB < 32) {
					sum += 320000;
				}
			}
			
			// write() 메서드를 사용해 총 상금의 액수를 출력
			out.write(sum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}