package gold4.num05864;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소의 수, 기지국 설치를 위한 고정 비용, 전송 거리 단위당 비용을 각 변수에 할당
		int cowNum = Integer.parseInt(st.nextToken());
		int fixedCost = Integer.parseInt(st.nextToken());
		int unitCost = Integer.parseInt(st.nextToken());
		
		// 각 소의 위치를 저장할 배열 cows 초기화
		int[] cows = new int[cowNum];
		
		// for 반복문을 사용해 입력 받은 소의 위치를 배열 cows에 저장
		for (int idx = 0; idx < cows.length; idx++)
			cows[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 입력 받은 소의 위치를 오름차순으로 정렬
		Arrays.sort(cows);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}