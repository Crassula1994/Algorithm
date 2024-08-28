package bronze2.num07133;

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
		
		// 달성할 수 있는 최대 만족의 양을 저장할 변수 maxHapp 초기화
		int maxHapp = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 우유 첫 단위의 만족의 양, 한계만족체감분을 각 변수에 할당
		int milkInitHapp = Integer.parseInt(st.nextToken());
		int milkHappDec = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 꿀 첫 단위의 만족의 양, 한계만족체감분을 각 변수에 할당
		int honeyInitHapp = Integer.parseInt(st.nextToken());
		int honeyHappDec = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사육장의 수를 변수 fieldNum에 할당
		int fieldNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 사육장을 순회
		for (int field = 0; field < fieldNum; field++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소와 벌의 수용가능량을 각 변수에 할당
			int cowLimit = Integer.parseInt(st.nextToken());
			int beeLimit = Integer.parseInt(st.nextToken());
			
			// 소와 벌을 선택했을 때 만들 수 있는 만족의 양을 저장할 각 변수 초기화
			int cowHapp = 0;
			int beeHapp = 0;
			
			// for 반복문을 사용해 각 소를 순회
			for (int cow = 0; cow < cowLimit; cow++) {
				
				// max() 메서드를 사용해 현재 소가 만들 수 있는 만족의 양을 변수 milkHapp에 할당
				int milkHapp = Math.max(milkInitHapp - cow * milkHappDec, 0);
				
				// 현재 소가 만들 수 있는 만족의 양이 0인 경우 반복문 탈출
				if (milkHapp == 0)
					break;
				
				// 소를 선택했을 때 만들 수 있는 만족의 양을 갱신
				cowHapp += milkHapp;
			}
			
			// for 반복문을 사용해 각 벌을 순회
			for (int bee = 0; bee < beeLimit; bee++) {
				
				// max() 메서드를 사용해 현재 벌이 만들 수 있는 만족의 양을 변수 honeyHapp에 할당
				int honeyHapp = Math.max(honeyInitHapp - bee * honeyHappDec, 0);
				
				// 현재 벌이 만들 수 있는 만족의 양이 0인 경우 반복문 탈출
				if (honeyHapp == 0)
					break;
				
				// 벌을 선택했을 때 만들 수 있는 만족의 양을 갱신
				beeHapp += honeyHapp;
			}
			
			// max() 메서드를 사용해 달성할 수 있는 최대 만족의 양을 갱신
			maxHapp += Math.max(cowHapp, beeHapp);
		}
		
		// valueOf() 및 write() 메서드를 사용해 달성할 수 있는 최대 만족의 양을 출력
		out.write(String.valueOf(maxHapp));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}