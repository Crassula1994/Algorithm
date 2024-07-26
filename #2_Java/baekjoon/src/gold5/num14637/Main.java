package gold5.num14637;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 여행 구간의 수와 총 소요 시간을 각 변수에 할당
		int sectionNum = Integer.parseInt(st.nextToken());
		int totalTime = Integer.parseInt(st.nextToken());
		
		// 정확한 속도의 보정치를 찾기 위한 각 구간의 끝을 나타낼 각 변수 초기화
		double low = 1001;
		double high = 10000000;
		
		// 각 여행 구간의 거리와 기록된 속도계 눈금을 저장할 각 배열 초기화
		double[] distances = new double[sectionNum];
		double[] records = new double[sectionNum];
		
		// for 반복문을 사용해 각 여행 구간을 순회
		for (int idx = 0; idx < sectionNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 해당 여행 구간의 거리와 기록된 속도계 눈금을 각 배열에 저장
			distances[idx] = Double.parseDouble(st.nextToken());
			records[idx] = Double.parseDouble(st.nextToken());
			
			// min() 메서드를 사용해 보정치의 하한을 갱신
			low = Math.min(records[idx], low);
		}
		
		// 보정치의 하한을 갱신
		low = -low;
		
		// for 반복문을 사용해 보정치에 근사할 때까지 이분탐색을 실행
		for (int count = 0; count < 100; count++) {
			
			// 보정치 구간의 중간을 계산하여 변수 mid에 할당
			double mid = (low + high) / 2;
			
			// 해당 보정치의 속도로 달렸을 때의 시간을 저장할 변수 curTime 초기화
			double curTime = 0;
			
			// for 반복문을 사용해 해당 보정치의 속도로 달렸을 때의 시간을 갱신
			for (int idx = 0; idx < sectionNum; idx++)
				curTime += distances[idx] / (records[idx] + mid);
			
			// 해당 보정치의 속도로 달렸을 때의 시간이 더 오래 걸린 경우 구간의 하한을 갱신
			if (curTime > totalTime) {
				low = mid;
				
			// 해당 보정치의 속도로 달렸을 때의 시간이 같거나 더 적게 걸린 경우 구간의 상한을 갱신
			} else {
				high = mid;
			}
		}
		
		// format() 및 write() 메서드를 사용해 속도의 보정치를 출력
		out.write(String.format("%.9f", high));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}