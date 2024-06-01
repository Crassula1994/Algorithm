package bronze3.num30802;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 수를 변수 participants에 할당
		int participants = Integer.parseInt(in.readLine());
		
		// 주문해야 하는 티셔츠의 묶음 수를 저장할 변수 shirtNum 초기화
		int shirtNum = 0;
		
		// 티셔츠의 각 사이즈별 신청자의 수를 저장할 배열 sizes 초기화
		int[] sizes = new int[6];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 사이즈별 신청자의 수를 배열 sizes에 저장
		for (int idx = 0; idx < 6; idx++)
			sizes[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 티셔츠와 펜의 묶음 수를 각 변수에 할당
		int shirtBundle = Integer.parseInt(st.nextToken());
		int penBundle = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 주문해야 하는 티셔츠의 묶음 수를 갱신
		for (int idx = 0; idx < 6; idx++)
			shirtNum = (sizes[idx] % shirtBundle == 0)
					? shirtNum + sizes[idx] / shirtBundle : shirtNum + sizes[idx] / shirtBundle + 1;
		
		// write() 메서드를 사용해 주문해야 하는 티셔츠와 펜의 묶음 수, 한 자루씩 주문하는 펜의 수를 출력
		out.write(shirtNum + "\n" + (participants / penBundle) + " " + (participants % penBundle));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}