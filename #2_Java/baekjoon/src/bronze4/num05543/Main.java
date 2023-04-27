package bronze4.num05543;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 햄버거의 가격 및 음료의 가격을 저장할 각 배열 초기화
		int[] hamburgers = new int[3];
		int[] beverages = new int[2];
		
		// for 반복문을 사용해 입력 받은 각 햄버거의 가격을 배열 hamburgers에 저장
		for (int idx = 0; idx < hamburgers.length; idx++)
			hamburgers[idx] = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 음료의 가격을 배열 beverages에 저장
		for (int idx = 0; idx < beverages.length; idx++)
			beverages[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 각 배열을 오름차순으로 정렬
		Arrays.sort(hamburgers);
		Arrays.sort(beverages);
				
		// 가장 저렴한 세트 메뉴의 가격을 계산해 변수 minSetMenu에 할당
		int minSetMenu = hamburgers[0] + beverages[0] - 50;
		
		// valueOf() 및 write() 메서드를 사용해 가장 저렴한 세트 메뉴의 가격을 출력
		out.write(String.valueOf(minSetMenu));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}