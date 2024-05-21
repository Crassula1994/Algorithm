package silver4.num02422;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 아이스크림 종류의 수와 섞어먹으면 안 되는 조합의 수를 각 변수에 할당
		int typeNum = Integer.parseInt(st.nextToken());
		int combNum = Integer.parseInt(st.nextToken());
		
		// 아이스크림을 세 가지 선택할 수 있는 방법의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 아이스크림의 조합이 섞어먹으면 안 되는 조합인지 여부를 저장할 2차원 배열 notMix 초기화
		boolean[][] notMix = new boolean[typeNum + 1][typeNum + 1];
		
		// for 반복문을 사용해 섞어먹으면 안 되는 조합을 순회
		for (int comb = 0; comb < combNum; comb++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 아이스크림의 조합을 각 변수에 할당
			int iceCreamA = Integer.parseInt(st.nextToken());
			int iceCreamB = Integer.parseInt(st.nextToken());
			
			// 섞어먹으면 안 되는 조합인지 여부를 2차원 배열 notMix에 저장
			notMix[iceCreamA][iceCreamB] = true;
			notMix[iceCreamB][iceCreamA] = true;
		}
		
		// for 반복문을 사용해 가능한 아이스크림 조합을 순회
		for (int i1 = 1; i1 <= typeNum - 2; i1++) {
			for (int i2 = i1 + 1; i2 <= typeNum - 1; i2++) {
				
				// 섞어먹으면 안 되는 조합이 있는 경우 다음 조합을 순회
				if (notMix[i1][i2])
					continue;
				
				// for 반복문을 사용해 가능한 아이스크림 조합을 순회
				for (int i3 = i2 + 1; i3 <= typeNum; i3++) {
					
					// 섞어먹으면 안 되는 조합이 있는 경우 다음 조합을 순회
					if (notMix[i1][i3] || notMix[i2][i3])
						continue;
					
					// 아이스크림을 세 가지 선택할 수 있는 방법의 수를 갱신
					count++;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 아이스크림을 세 가지 선택할 수 있는 방법의 수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}