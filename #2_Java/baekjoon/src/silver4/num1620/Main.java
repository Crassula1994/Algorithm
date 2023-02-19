package silver4.num1620;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 포켓몬의 수 및 문제의 개수를 각 변수에 할당
		int inLength = Integer.parseInt(st.nextToken());
		int outLength = Integer.parseInt(st.nextToken());
		
		// 포켓몬 이름 및 도감 번호를 저장할 Map 객체 pokemonDict 초기화
		Map<String, Integer> pokemonDict = new HashMap<>();
		
		// 포켓몬 이름을 저장할 배열 pokemonName 초기화
		String[] pokemonName = new String[inLength];
		
		// for 반복문을 사용해 각 포켓몬을 순회
		for (int i = 0, number = 1; i < inLength; i++) {
			
			// readLine() 메서드를 사용해 입력 받은 포켓몬 이름을 변수 name에 할당
			String name = in.readLine();
			
			// put() 메서드를 사용해 포켓몬 이름과 도감 번호를 추가
			pokemonDict.put(name, number++);
			
			// 포켓몬 이름을 배열 pokemonName에 추가
			pokemonName[i] = name;
		}
		
		// for 반복문을 사용해 각 문제를 순회
		for (int j = 0; j < outLength; j++) {
			
			// readLine() 메서드를 사용해 입력 받은 문제를 변수 question에 할당
			String question = in.readLine();
			
			// 정수가 입력된 경우
			try {
				
				// parseInt() 메서드를 사용해 입력 받은 도감 번호를 변수 pokemonNum에 할당
				int pokemonNum = Integer.parseInt(question);
				
				// write() 메서드를 사용해 해당하는 포켓몬 이름 출력
				out.write(pokemonName[pokemonNum - 1] + "\n");

			// 문자열이 입력된 경우 
			} catch (NumberFormatException e) {
				
				// get() 및 write() 메서드를 사용해 해당하는 포켓몬 번호 출력
				out.write(pokemonDict.get(question) + "\n");
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}