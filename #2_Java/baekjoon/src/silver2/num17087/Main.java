package silver2.num17087;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동생의 수와 수빈이의 위치를 각 변수에 할당
		int siblingNum = Integer.parseInt(st.nextToken());
		int startLoc = Integer.parseInt(st.nextToken());
		
		// 각 동생이 수빈이로부터 떨어진 거리를 저장할 배열 locations 초기화
		int[] locations = new int[siblingNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 동생의 위치를 순회
		for (int idx = 0; idx < locations.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동생의 위치를 변수 location에 할당
			int location = Integer.parseInt(st.nextToken());
			
			// abs() 메서들르 사용해 수빈이로부터 떨어진 거리를 배열 locations에 저장
			locations[idx] = Math.abs(location - startLoc);
		}
		
		// 모든 동생을 찾기 위한 이동 거리를 저장할 변수 maxDist 초기화
		int maxDist = locations[0];
		
		// for 반복문을 사용해 모든 동생을 찾기 위한 이동 거리를 갱신
		for (int idx = 1; idx < locations.length; idx++)
			maxDist = distFinder(Math.max(locations[idx], maxDist), Math.min(locations[idx], maxDist));
		
		// valueOf() 및 write() 메서드를 사용해 모든 동생을 찾기 위한 이동 거리를 출력
		out.write(String.valueOf(maxDist));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// distFinder() 메서드 정의
	public static int distFinder(int distA, int distB) {
		
		// 나머지가 0인 경우 제수가 최대공약수이므로 최대공약수를 반환
		if (distB == 0)
			return distA;
		
		// distFinder() 메서드를 재귀 호출해 최대공약수를 반환
		return distFinder(distB, distA % distB);
	}
}