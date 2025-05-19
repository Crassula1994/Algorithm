package bronze2.num02399;

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
		
		// 각 점의 쌍 사이 거리의 합을 저장할 변수 distanceSum 초기화
		long distanceSum = 0;
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점의 개수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 각 점의 좌표를 저장할 배열 points 초기화
		long[] points = new long[pointNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 점의 좌표를 배열 points에 저장
		for (int idx = 0; idx < points.length; idx++)
			points[idx] = Long.parseLong(st.nextToken());
		
		// sort() 메서드를 사용해 각 점의 좌표를 오름차순으로 정렬
		Arrays.sort(points);
		
		// for 반복문을 사용해 각 점의 쌍 사이 거리의 합을 갱신
		for (int idx = 0; idx < points.length; idx++)
			distanceSum += (points[idx] * idx - points[idx] * (pointNum - idx - 1)) * 2;
		
		// valueOf() 및 write() 메서드를 사용해 각 점의 쌍 사이 거리의 합을 출력
		out.write(String.valueOf(distanceSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}