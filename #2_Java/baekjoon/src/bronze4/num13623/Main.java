package bronze4.num13623;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 하당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 앨리스, 베토, 클라라가 선택한 값을 저장할 각 List 객체 초기화
		List<Character> zeroVoters = new ArrayList<>();
		List<Character> oneVoters = new ArrayList<>();
		
		// for 반복문을 사용해 입력 받은 앨리스, 베토, 클라라가 선택한 값을 순회
		for (int count = 0; count < 3; count++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 사람이 선택한 값과 해당 사람을 나타내는 알파벳을 각 변수에 할당
			int value = Integer.parseInt(st.nextToken());
			char person = (char) ('A' + count);
			
			// 선택한 값이 0인 경우 zeroVoters에 해당 사람을 나타내는 알파벳을 추가
			if (value == 0) {
				zeroVoters.add(person);
				
			// 선택한 값이 1인 경우 oneVoters에 해당 사람을 나타내는 알파벳을 추가
			} else {
				oneVoters.add(person);
			}
		}
		
		// 0을 선택한 우승자가 존재하는 경우 해당 우승자를 출력
		if (zeroVoters.size() == 1) {
			out.write(zeroVoters.get(0));
			
		// 1을 선택한 우승자가 존재하는 경우 해당 우승자를 출력
		} else if (oneVoters.size() == 1) {
			out.write(oneVoters.get(0));
		
		// 우승자가 존재하지 않는 경우 '*'을 출력
		} else {
			out.write("*");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}