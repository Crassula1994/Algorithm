package bronze1.num02246;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 콘도의 정보를 저장할 배열 resorts 초기화
	static Resort[] resorts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Resort 클래스 정의
	static class Resort {
		
		// 콘도의 바닷가로부터의 거리와 숙박비를 저장할 각 변수 초기화
		int distance;
		int charge;
		
		// 매개변수를 입력 받는 생성자 정의
		public Resort(int distance, int charge) {
			this.distance = distance;
			this.charge = charge;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 콘도의 개수를 변수 resortNum에 할당
		int resortNum = Integer.parseInt(in.readLine());
		
		// 후보가 될 수 있는 콘도의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 콘도의 정보를 저장할 배열 resorts 초기화
		resorts = new Resort[resortNum];
		
		// for 반복문을 사용해 각 콘도의 정보를 순회
		for (int idx = 0; idx < resorts.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 콘도의 바닷가로부터의 거리와 숙박비를 각 변수에 할당
			int distance = Integer.parseInt(st.nextToken());
			int charge = Integer.parseInt(st.nextToken());
			
			// 해당 콘도의 정보를 배열 resorts에 저장
			resorts[idx] = new Resort(distance, charge);
		}
		
		// for 반복문을 사용해 각 콘도를 순회
		for (int idx = 0; idx < resorts.length; idx++) {
			
			// 해당 콘도가 후보가 될 수 없는 경우 다음 콘도를 순회
			if (!resortChecker(idx))
				continue;
			
			// 후보가 될 수 있는 콘도의 수를 갱신
			count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 후보가 될 수 있는 콘도의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// resortChecker() 메서드 정의
	public static boolean resortChecker(int curIdx) {
		
		// 현재 콘도의 정보를 변수 curResort에 할당
		Resort curResort = resorts[curIdx];
		
		// for 반복문을 사용해 각 콘도를 순회
		for (int idx = 0; idx < resorts.length; idx++) {
			
			// 현재 확인 중인 콘도인 경우 다음 콘도를 순회
			if (idx == curIdx)
				continue;
			
			// 해당 콘도가 거리는 더 가까운데, 숙박비는 같거나 싼 경우 false 반환
			if (resorts[idx].distance < curResort.distance && resorts[idx].charge <= curResort.charge)
				return false;
			
			// 해당 콘도가 가격은 더 싼데, 거리가 같거나 더 가까운 경우 false 반환
			if (resorts[idx].charge < curResort.charge && resorts[idx].distance <= curResort.distance)
				return false;
		}
		
		// 해당 콘도가 후보가 될 수 있는 경우 true 반환
		return true;
	}
}