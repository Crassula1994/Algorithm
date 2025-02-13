package silver5.num19947;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 초기 투자 비용 및 투자 기간을 각 변수에 할당
		int initialCost = Integer.parseInt(st.nextToken());
		int duration = Integer.parseInt(st.nextToken());
		
		// 각 기간 동안의 최대 자산을 저장할 배열 maxAssets 초기화
		int[] maxAssets = new int[duration + 1];
		
		// 초기 투자 비용을 배열 maxProperties에 저장
		maxAssets[0] = initialCost;
		
		// for 반복문을 사용해 각 기간을 순회
		for (int year = 1; year <= duration; year++) {
			
			// A 방식으로 투자한 경우 해당 기간의 최대 자산을 갱신
			maxAssets[year] = (int) (maxAssets[year - 1] * 1.05);
				
			// B 방식으로 투자할 수 있는 경우 해당 기간의 최대 자산을 갱신
			if (year >= 3)
				maxAssets[year] = Math.max((int) (maxAssets[year - 3] * 1.2), maxAssets[year]);
				
			// C 방식으로 투자할 수 있는 경우 해당 기간의 최대 자산을 갱신
			if (year >= 5)
				maxAssets[year] = Math.max((int) (maxAssets[year - 5] * 1.35), maxAssets[year]);
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 많은 이득을 얻었을 때의 총 자산을 출력
		out.write(String.valueOf(maxAssets[duration]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}