package gold5.num02212;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 센서의 개수 및 집중국의 개수를 각 변수에 할당
		int sensorNum = Integer.parseInt(in.readLine());
		int centerNum = Integer.parseInt(in.readLine());
		
		// 집중국의 수신 가능 영역 길이의 합의 최솟값을 저장할 변수 minLength 초기화
		int minLength = 0;
		
		// 각 센서의 위치, 센서 간 거리를 저장할 각 배열 초기화
		int[] sensors = new int[sensorNum];
		int[] distances = new int[sensorNum - 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 센서의 위치를 배열 sensors에 저장
		for (int idx = 0; idx < sensors.length; idx++)
			sensors[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 각 센서의 위치를 오름차순으로 정렬
		Arrays.sort(sensors);
		
		// for 반복문을 사용해 각 센서 간 거리를 배열 distances에 저장
		for (int idx = 0; idx < distances.length; idx++)
			distances[idx] = sensors[idx + 1] - sensors[idx];
		
		// sort() 메서드를 사용해 각 센서 간 거리를 오름차순으로 정렬
		Arrays.sort(distances);
		
		// for 반복문을 사용해 수신 가능 영역 길이의 합의 최솟값을 갱신
		for (int idx = 0; idx < distances.length - centerNum + 1; idx++)
			minLength += distances[idx];
		
		// valueOf() 및 write() 메서드를 사용해 집중국의 수신 가능 영역 길이의 합의 최솟값을 출력
		out.write(String.valueOf(minLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}