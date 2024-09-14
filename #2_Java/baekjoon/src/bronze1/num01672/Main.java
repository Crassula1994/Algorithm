package bronze1.num01672;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// 염기서열의 순서를 저장할 배열 order 초기화
	static char[] order = {'A', 'G', 'C', 'T'};
	
	// 염기서열을 해독하기 위한 표를 저장할 2차원 배열 table 초기화
	static char[][] table = {{'A', 'C', 'A', 'G'}, {'C', 'G', 'T', 'A'},
			{'A', 'T', 'C', 'G'}, {'G', 'A', 'G', 'T'}};
	
	// 염기서열 글자의 위치를 나타낼 Map 객체 nucleobase 초기화
	static Map<Character, Integer> nucleobase = new HashMap<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 염기서열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 염기서열을 배열 genome에 할당
		char[] genome = in.readLine().toCharArray();
		
		// for 반복문을 사용해 염기서열 글자의 위치를 nucleobase에 저장
		for (int idx = 0; idx < order.length; idx++)
			nucleobase.put(order[idx], idx);
		
		// 이전 글자를 해독한 결과를 저장할 변수 result 초기화
		char result = genome[length - 1];
		
		// for 반복문을 사용해 각 글자를 해독한 결과를 갱신
		for (int idx = length - 2; idx >= 0; idx--)
			result = table[nucleobase.get(genome[idx])][nucleobase.get(result)];
		
		// write() 메서드를 사용해 해독된 최종 염기를 출력
		out.write(result);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}