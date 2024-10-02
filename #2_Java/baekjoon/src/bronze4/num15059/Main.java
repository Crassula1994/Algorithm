package bronze4.num15059;

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
		
		// 선택한 식사를 받지 못하는 승객의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 비행기에 남은 음식의 양과 손님들이 요청한 음식의 양을 저장할 각 배열 초기화
		int[] supplies = new int[3];
		int[] demands = new int[3];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 비행기에 남은 치킨, 소고기, 파스타의 수를 배열 supplies에 저장
		for (int idx = 0; idx < supplies.length; idx++)
			supplies[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 손님들이 요청한 치킨, 소고기, 파스타의 수를 배열 demands에 저장
		for (int idx = 0; idx < demands.length; idx++)
			demands[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 선택한 식사를 받지 못하는 승객의 수를 갱신
		for (int idx = 0; idx < 3; idx++)
			count += Math.max(demands[idx] - supplies[idx], 0);
		
		// valueOf() 및 write() 메서드를 사용해 선택한 식사를 받지 못하는 승객의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}