package silver4.num17266;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 굴다리의 길이를 저장할 변수 passLen 초기화
	static int passLen;
	
	// 가로등의 위치를 저장할 배열 streetlights 초기화
	static int[] streetlights;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 굴다리의 길이 및 가로등의 개수를 각 변수에 할당
		passLen = Integer.parseInt(in.readLine());
		int lightNum = Integer.parseInt(in.readLine());
		
		// 가로등의 위치를 저장할 배열 streetlights 초기화
		streetlights = new int[lightNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 가로등의 위치를 배열 streetlights에 저장
		for (int idx = 0; idx < streetlights.length; idx++)
			streetlights[idx] = Integer.parseInt(st.nextToken());
		
		// 가로등의 최소 높이를 찾기 위한 최소 길이의 범위를 나타낼 각 변수 초기화
		int low = 1;
		int high = passLen + 1;
		
		// while 반복문을 사용해 가로등의 최소 높이를 찾을 때까지 순회
		while (low < high) {
			
			// 가능한 가로등 높이의 중간 높이를 계산해 변수 mid에 할당
			int mid = (low + high) / 2;
			
			// 가로등이 굴다리의 모든 범위를 밝히지 못하는 경우 범위의 시작을 갱신
			if (!passChecker(mid)) {
				low = mid + 1;
				
			// 가로등이 굴다리의 모든 범위를 밝히는 경우 범위의 끝을 갱신
			} else {
				high = mid;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가로등의 최소 높이를 출력
		out.write(String.valueOf(high));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// passChecker() 메서드 정의
	public static boolean passChecker(int height) {
		
		// 현재 밝히고 있는 범위의 끝을 저장할 변수 curLocation 초기화
		int curLocation = 0;
		
		// for 반복문을 사용해 각 가로등을 순회
		for (int idx = 0; idx < streetlights.length; idx++) {
			
			// 해당 가로등이 밝히지 못하는 범위가 있는 경우 false 반환
			if (streetlights[idx] - height > curLocation)
				return false;
			
			// 가로등이 밝히고 있는 범위의 끝을 갱신
			curLocation = streetlights[idx] + height;
		}
		
		// 가로등이 모든 범위를 밝힐 수 있는지 여부를 반환
		return curLocation >= passLen;
	}
}