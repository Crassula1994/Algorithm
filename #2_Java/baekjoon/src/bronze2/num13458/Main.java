package bronze2.num13458;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 시험장의 개수를 변수 testSiteNum에 할당
		int testSiteNum = Integer.parseInt(in.readLine());
		
		// 각 시험장별 응시자의 수를 저장할 배열 examinees 초기화
		int[] examinees = new int[testSiteNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 응시자 수를 배열 examinees에 저장
		for (int idx = 0; idx < examinees.length; idx++)
			examinees[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 총감독관, 부감독관의 감시 가능 인원을 각 변수에 할당
		int chief = Integer.parseInt(st.nextToken());
		int assistant = Integer.parseInt(st.nextToken());
		
		// 필요한 감독의 최소 수를 저장할 변수 minCnt 초기화
		long minCnt = 0;
		
		// for 반복문을 사용해 각 시험장별 응시자 수를 순회
		for (int idx = 0; idx < examinees.length; idx++) {
			
			// 해당 시험장의 응시자 수가 총감독관의 감시 가능 인원 이하인 경우 필요한 감독의 최소 수 갱신
			if (examinees[idx] <= chief) {
				minCnt++;
			
			// 해당 시험장의 응시자 수가 총감독관의 감시 가능 인원 이상인 경우
			} else {
				
				// 총감독관의 감시 가능 인원을 제외한 인원을 변수 remains에 할당
				int remains = examinees[idx] - chief;
				
				// 필요한 감독의 최소 수 갱신
				minCnt += remains / assistant + 1;
				
				// 나머지가 있는 경우 필요한 감독의 최소 수 갱신
				if (remains % assistant != 0)
					minCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 필요한 감독의 최소 수를 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}