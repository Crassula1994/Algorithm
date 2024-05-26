package bronze1.num31880;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 주문서의 개수를 각 변수에 할당
		int spellCntA = Integer.parseInt(st.nextToken());
		int spellCntB = Integer.parseInt(st.nextToken());
		
		// 만들 수 있는 행운 수치의 최댓값을 저장할 변수 maxValue 초기화
		long maxValue = 0;
		
		// 두 번째 주문서의 행운 수치를 저장할 배열 spellBooks 초기화
		int[] spellBooks = new int[spellCntB];
		
		// StringTokenizer 객체를 불러와 각 주문서의 행운 수치를 각 변수에 할당
		StringTokenizer spellBooksA = new StringTokenizer(in.readLine());
		StringTokenizer spellBooksB = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 첫 번째 주문서의 행운 수치로 행운 수치의 최댓값을 갱신
		for (int spell = 0; spell < spellCntA; spell++)
			maxValue += Integer.parseInt(spellBooksA.nextToken());
		
		// for 반복문을 사용해 입력 받은 두 번째 주문서의 행운 수치를 배열 spellBooks에 할당
		for (int idx = 0; idx < spellBooks.length; idx++)
			spellBooks[idx] = Integer.parseInt(spellBooksB.nextToken());
		
		// sort() 메서드를 사용해 두 번째 주문서의 행운 수치를 오름차순으로 정렬
		Arrays.sort(spellBooks);
		
		// for 반복문을 사용해 두 번째 주문서의 행운 수치를 순회
		for (int idx = 0; idx < spellBooks.length; idx++) {
			
			// 두 번째 주문서의 행운 수치가 0인 경우 가장 먼저 사용한 것으로 처리
			if (spellBooks[idx] == 0)
				continue;
			
			// 두 번째 주문서의 행운 수치로 행운 수치의 최댓값을 갱신
			maxValue *= spellBooks[idx];
		}
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 행운 수치의 최댓값을 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}