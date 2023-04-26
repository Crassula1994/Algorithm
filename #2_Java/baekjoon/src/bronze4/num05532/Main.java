package bronze4.num05532;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 방학일수, 풀어야 하는 숙제의 페이지 수, 하루에 풀 수 있는 페이지 수를 각 변수에 할당
		int vacationLen = Integer.parseInt(in.readLine());
		int totalKorean = Integer.parseInt(in.readLine());
		int totalMath = Integer.parseInt(in.readLine());
		int dayKorean = Integer.parseInt(in.readLine());
		int dayMath = Integer.parseInt(in.readLine());
		
		// 각 과목을 푸는 데 필요한 최소 일수를 계산해 각 변수에 할당
		int minKorean = (totalKorean % dayKorean == 0) ? totalKorean / dayKorean : totalKorean / dayKorean + 1;
		int minMath = (totalMath % dayMath == 0) ? totalMath / dayMath : totalMath / dayMath + 1;
		
		// max() 메서드를 사용해 상근이가 놀 수 있는 최대 날의 수를 계산하고 변수 maxVacation에 할당
		int maxVacation = vacationLen - Math.max(minKorean, minMath);
		
		// valueOf() 및 write() 메서드를 사용해 상근이가 놀 수 있는 최대 날의 수를 출력
		out.write(String.valueOf(maxVacation));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}