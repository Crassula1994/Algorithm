package bronze4.num25238;

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
		
		// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 몬스터의 방어율과 유저의 방어율 무시 비율를 각 변수에 할당
		double defenseValue = Double.parseDouble(st.nextToken());
		double ignoringRate = Double.parseDouble(st.nextToken());
		
		// 몬스터의 방어율이 100 미만인 경우 1 출력
		if (defenseValue < 100) {
			out.write(String.valueOf(1));
		
		// 몬스터의 방어율이 100 이상인 경우
		} else {
			
			// 유저가 체감하는 방어율 수치를 계산해 변수 newDefesneValue에 할당
			double newDefenseValue = defenseValue * (100 - ignoringRate) / 100;
			
			// 유저가 체감하는 방어율 수치가 100 미만인 경우 1 출력
			if (newDefenseValue < 100) {
				out.write(String.valueOf(1));
				
			// 유저가 체감하는 방어율 수치가 100 이상인 경우 0 출력
			} else {
				out.write(String.valueOf(0));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}