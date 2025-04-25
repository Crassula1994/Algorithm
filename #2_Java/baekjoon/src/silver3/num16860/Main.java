package silver3.num16860;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 스파이의 위치 및 도청기의 개수를 각 변수에 할당
		int spyX = Integer.parseInt(st.nextToken());
		int spyY = Integer.parseInt(st.nextToken());
		int deviceNum = Integer.parseInt(st.nextToken());
		
		// 스파이의 위치로부터 각 도청기의 청취 범위까지의 거리를 저장할 배열 distances 초기화
		double[] distances = new double[deviceNum];
		
		// for 반복문을 사용해 각 도청기의 정보를 순회
		for (int idx = 0; idx < distances.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도청기의 위치 및 청취 범위의 반지름을 각 변수에 할당
			int deviceX = Integer.parseInt(st.nextToken());
			int deviceY = Integer.parseInt(st.nextToken());
			int radius = Integer.parseInt(st.nextToken());
			
			// 스파이의 위치로부터 해당 도청기의 청취 범위까지의 거리를 계산해 변수 distance에 할당
			double distance = Math.sqrt((spyX - deviceX) * (spyX - deviceX) + (spyY - deviceY) * (spyY - deviceY)) - radius;
			
			// max() 메서드를 사용해 스파이의 위치로부터 해당 도청기의 청취 범위까지의 거리를 배열 distances에 저장
			distances[idx] = Math.max(0, distance);
		}
		
		// sort() 메서드를 사용해 스파이의 위치로부터 가까운 순서대로 거리를 정렬
		Arrays.sort(distances);
		
		// valueOf() 및 write() 메서드를 사용해 최대 통신 범위의 반지름을 출력
		out.write(String.valueOf((int) distances[2]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}